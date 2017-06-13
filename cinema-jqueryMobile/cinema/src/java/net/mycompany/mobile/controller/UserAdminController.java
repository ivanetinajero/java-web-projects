package net.mycompany.mobile.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.mycompany.mobile.dao.*;
import net.mycompany.mobile.dto.User;

public class UserAdminController extends HttpServlet {
	
   public UserAdminController() { }

   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");          
        if ("add".equals(action))
            this.addUser(request,response);
        else if ("view".equals(action))
            this.viewUsers(request,response);
        else if ("delete".equals(action))
            this.deleteUser(request,response);        
	}
	
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibimos el parametro de accion, para ver que solicito el cliente.
		String action = request.getParameter("action");  
		if ("save".equals(action))
            this.saveUser(request,response);
	}

	protected void saveUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	   try {
         User user = new User(0);
         user.setName(request.getParameter("name"));
         user.setUsername(request.getParameter("username"));
         user.setPassword(request.getParameter("password"));

         // Insert user in DB	    		
         int idUser = UserDao.insert(user);
         if (idUser == 0) {
            request.setAttribute("message", "There was an error.");
         }else{
            request.setAttribute("message", "The user was saved.");
         }
            
      } catch (Exception ex) {
         request.setAttribute("message", "There was an error: " + ex.getMessage());
      }      
      String url="view/admin/user?action=view";		
		request.setAttribute("urlBack", url);
      RequestDispatcher rd;        
      rd = request.getRequestDispatcher("/view/admin/message.jsp");
		rd.forward(request, response);        
   }	
	
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		RequestDispatcher rd;		
		rd = request.getRequestDispatcher("/view/admin/user/addUser.jsp");
		rd.forward(request, response);
	}
	
	protected void viewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		RequestDispatcher rd;
		List<User> list = null;		
		try {			
			list = UserDao.getAll();
		} catch (Exception e) {
			System.out.println("Error: UserAdminController.java");
		} 
		request.setAttribute("users", list);
		rd = request.getRequestDispatcher("/view/admin/user/listUsers.jsp");
		rd.forward(request, response);
	}
	
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
		int idUser = Integer.parseInt(request.getParameter("id"));	
		int rows=0;
		RequestDispatcher rd;
		
		try {			
			rows = UserDao.delete(idUser);
		} catch (Exception e) {
			System.out.println("Error: UserAdminController.java");
		} 
		String msg ="";
		if (rows==1){
			msg="The user was deleted";
		}
		else
			msg="There was an error. The user was not deleted.";
		
		String url="view/admin/user?action=view";
		request.setAttribute("message", msg);	
		request.setAttribute("urlBack", url);
		rd = request.getRequestDispatcher("/view/admin/message.jsp");
		rd.forward(request, response);
	}

}
