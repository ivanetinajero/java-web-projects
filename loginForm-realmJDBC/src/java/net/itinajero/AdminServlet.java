package net.itinajero;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.itinajero.dto.Usuario;
import org.apache.catalina.realm.GenericPrincipal;

public class AdminServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      
      // Objeto para recuperar los datos de la sesion
      HttpSession session = request.getSession();
      
      // El objeto realmUser ya tiene los datos del usuario autenticado (username y roles asociados)
      GenericPrincipal realmUser = (GenericPrincipal) request.getUserPrincipal();
      String[] roles = realmUser.getRoles(); // Arreglos de String que contiene los roles
      
      // Podria ser una clase para traer datos de una BD buscando por username   
      //Usuario detalleUser = UsuarioDao.getByUserName(user.getName());
      
      // Aqui lo haremos de forma estatica
      Usuario detalleUser = new Usuario(0);
      detalleUser.setNombre("Juan Garcia");
      
      // Despues de traer los detalles del usuario de la bd, le asignamos los
      // roles que nos regreso el objero GenericPrincipal 
      detalleUser.setRoles(roles);
      
      // Lo ponemos en sesion para tenerlo para toda la aplicacion
      session.setAttribute("usuario", detalleUser);
      
      RequestDispatcher rd;
      rd = request.getRequestDispatcher("/protected/admin.jsp");
      rd.forward(request, response);
   }

}
