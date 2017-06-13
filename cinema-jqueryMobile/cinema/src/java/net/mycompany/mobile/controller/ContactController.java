package net.mycompany.mobile.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactController extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String name=request.getParameter("name");
      String email=request.getParameter("email");
      String comments=request.getParameter("comments");
      System.out.println("Contact form");
      System.out.println("");
      System.out.println("Name: "+name);
      System.out.println("Email: "+email);
      System.out.println("Comments: "+comments);
      RequestDispatcher rd;
      request.setAttribute("message", "Thanks for your comments.");			
		rd = request.getRequestDispatcher("/contact.jsp");
		rd.forward(request, response);
   }
}
