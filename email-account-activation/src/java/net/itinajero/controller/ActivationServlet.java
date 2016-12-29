package net.itinajero.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.itinajero.dao.ContactDao;
import net.itinajero.dao.DbConnection;

public class ActivationServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      String email = request.getParameter("email");
      String hash = request.getParameter("hash");
      
      DbConnection conn = new DbConnection();
      ContactDao dao = new ContactDao(conn);
      boolean encontrado = dao.getByEmailHash(email, hash);
      String activado = "No existe este email en la bd";
      if (encontrado) // Si esta listo para activarse
         activado = dao.activate(email);                       
      conn.disconnect();      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      if (activado.equals("ok")){
        // Aqui podriamos crear este usuario en otra BD para otro sistema 
        out.println("Usuario Activado");      
      }  
      else
        out.println(activado);      
   }

}
