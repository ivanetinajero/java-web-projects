package net.mycompany.mobile.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mycompany.mobile.util.Utility;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

   public Logout() { }

   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("nextDays", Utility.getNextDays());		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}	
}
