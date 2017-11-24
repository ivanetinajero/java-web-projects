package net.itinajero;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadServlet extends HttpServlet {
 
   /**
    * Directory where uploaded files will be saved, its relative to the web
    * application directory.
    */
   private static final String UPLOAD_DIR = "uploads";

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // gets absolute path of the web application
      //String applicationPath = request.getServletContext().getRealPath("");
      
      // gets absolute path of the external directory to webapps (web.xml)
      String applicationPath = getServletContext().getInitParameter("file-upload");

      // constructs path of the directory to save uploaded file
      //String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
      String uploadFilePath = applicationPath + File.separator;

      String name = request.getParameter("name");
      System.out.println("Name: " + name);
      String email = request.getParameter("email");
      System.out.println("email: " + email);

      Part archivo = request.getPart("photo");

      System.out.println("part.getContentType : " + archivo.getContentType());
      System.out.println("part.getSize : " + archivo.getSize());
      System.out.println("part.getName : " + archivo.getName());
      System.out.println("part.getSubmittedFileName : " + archivo.getSubmittedFileName());
      
      String nombre = archivo.getSubmittedFileName();
      //String nombre = getFileName(archivo); // solo para IE
      
      /*
      
      // Podriamos validar el tipo de archivo de la siguiente forma.    
      if (nombre.endsWith("pdf") || nombre.endsWith("doc") || nombre.endsWith("docx")) {
         // archivo valido
      }else{
         // archivo no permitido
      }
      
      */
      // Escribimos el archivo al disco duro del servidor
      archivo.write(uploadFilePath + File.separator + nombre);
      request.setAttribute("message", "File uploaded successfully!");
      request.setAttribute("archivo", nombre);
      
      getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
   }
   /**
    * Metodo para que funcione en Internet Explorer. Este metodo lo que hace es que quita la ruta
    * del nombre del archivo, y deja solo el nombre del archivo seleccionado
    * @param part
    * @return 
    */
   private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                System.out.println("BUSCANDO EL NOMBRE EN EL HEADER");
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
