package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveController extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      String id = request.getParameter("id");
      String newParent = request.getParameter("newParent");
      System.out.println("Id: " + id);
      System.out.println("New Parent: " + newParent);
               
      PrintWriter out = response.getWriter();
      out.println("exito");
      
   }

}
