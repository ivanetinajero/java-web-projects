package net.itinajero;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetImageController", urlPatterns = {"/image"})
public class GetImageController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {  
      
      int id = Integer.parseInt(request.getParameter("id"));
                  
      byte[] image = getImageInTable(id);
           
      response.setHeader("Content-Length", String.valueOf(image.length));
      String nameImage="myimage";
      response.setHeader("Content-Disposition", "inline; filename=\"" + nameImage + "\"");

      // Write image data to Response.
      response.getOutputStream().write(image);
   }

   private byte[] getImageInTable(int id){
      DbConnection conn = new DbConnection(); // connection to the database
      try {
         byte[] imageData=null;
         String sql = "Select * from contacts where contact_id = ?";
         PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
         pstm.setInt(1, id);
         ResultSet rs = pstm.executeQuery();
         if (rs.next()) {
            String name = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            imageData = rs.getBytes("photo");            
         }
         conn.disconnect();
         return imageData;
      } catch (SQLException ex) {
         System.out.println("Error: " + ex.getMessage());
         return null;
      }
   }

}
