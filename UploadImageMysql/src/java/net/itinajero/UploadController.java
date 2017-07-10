package net.itinajero;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadController", urlPatterns = {"/upload"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadController extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      // gets values of text fields
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");

      InputStream inputStream = null; // input stream of the upload file

      // obtains the upload file part in this multipart request
      Part filePart = request.getPart("photo");
      if (filePart != null) {
         // prints out some information for debugging
         System.out.println(filePart.getName());
         System.out.println(filePart.getSize());
         System.out.println(filePart.getContentType());

         // obtains input stream of the upload file
         inputStream = filePart.getInputStream();
      }

      DbConnection conn = new DbConnection(); // connection to the database
      String message = null;  // message will be sent back to client

      try {

         // constructs SQL statement
         String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
         PreparedStatement statement = conn.getConnection().prepareStatement(sql);
         statement.setString(1, firstName);
         statement.setString(2, lastName);

         if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            statement.setBlob(3, inputStream);
         }

         // sends the statement to the database server
         int row = statement.executeUpdate();
         if (row > 0) {
            message = "File uploaded and saved into database";
         }
         conn.disconnect();
      } catch (SQLException ex) {
         message = "ERROR: " + ex.getMessage();
         System.out.println("Error: " + message);
      }
      // sets the message in request scope
      request.setAttribute("msg", message);

      RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
      rd.forward(request, response);
      
   }
}
