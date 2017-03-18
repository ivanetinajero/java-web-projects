/*
  If using tomcat-users.xml

  <role rolename="gerente"/>
  <user username="juan" password="mypass" roles="gerente"/>
*/

package net.itinajero;

import java.io.*;
import javax.annotation.security.DeclareRoles;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request,
           HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      try {
         String userName = request.getParameter("txtUserName");
         String password = request.getParameter("txtPassword");

         out.println("Before Login" + "<br><br>");
         out.println("IsUserInRole?.." + request.isUserInRole("gerente") + "<br>");
         out.println("getRemoteUser?.." + request.getRemoteUser() + "<br>");
         out.println("getUserPrincipal?.." + request.getUserPrincipal() + "<br>");
         out.println("getAuthType?.." + request.getAuthType() + "<br><br>");

         request.login(userName, password); // Buscar el usuario y contraseña en el REALM por default
         
         out.println("After Login..." + "<br><br>");
         out.println("IsUserInRole?.." + request.isUserInRole("gerente") + "<br>");
         out.println("getRemoteUser?.." + request.getRemoteUser() + "<br>");
         out.println("getUserPrincipal?.." + request.getUserPrincipal() + "<br>");
         out.println("getAuthType?.." + request.getAuthType() + "<br><br>");

         request.logout();
         out.println("After Logout..." + "<br><br>");
         out.println("IsUserInRole?.." + request.isUserInRole("gerente") + "<br>");
         out.println("getRemoteUser?.." + request.getRemoteUser() + "<br>");
         out.println("getUserPrincipal?.." + request.getUserPrincipal() + "<br>");
         out.println("getAuthType?.." + request.getAuthType() + "<br>");
      } finally {
         out.close();
      }
   }

}
