package net.itinajero;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletValidaCurp extends HttpServlet {
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      // La respuesta del SERVLET sera texto     
      response.setContentType("text/html;charset=UTF-8");
      // Objeto para poder escribir texto como respuesta
      // Algo parecido a System.out.print()...
      PrintWriter out = response.getWriter();   
      
      // Recibimos la curp que nos manda la funcion AJAX.
      String curpForm = request.getParameter("paramCurp");
      
      // Funcion que valida si la curp enviada en el campo de texto ya esta en la BD
      boolean existe = validarCurp(curpForm);
      if (existe)      
         out.print("existe");// Mandamos de repuesta la cadena existe
      else
         out.print("noexiste");// Mandamos de repuesta la cadena no existe
   }
   
   /**
      Esta funciona tendria que validar la curp pasada como parametro con una
      consulta a la Base de Datos por ejemplo.
      En este demo unicamente estamos simulando una validacion   
   */ 
   private boolean validarCurp(String curpForm){
      String CURP_EN_BD = "tidi7911258t8"; // Supongamos que esta curp ya esta en la BD
      // Supongamos que ya existe
      if (curpForm.equals(CURP_EN_BD))
         return true; // Ya esta en la Base de Datos
      else
         return false; // No existe en la Base de datos
   }
}
