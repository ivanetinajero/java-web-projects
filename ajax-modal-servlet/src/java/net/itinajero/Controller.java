package net.itinajero;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      String curp = request.getParameter("curp");
      String nombre = request.getParameter("nombre");
      // Ya aqui podriamos guardar la curp y el nombre
      System.out.println("CURP: " + curp);
      System.out.println("Nombre: " + nombre); 
   
      request.setAttribute("msg", "DATOS GUARDADOS");
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      rd.forward(request, response);
      
   }
  
}
