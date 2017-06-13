package net.mycompany.mobile.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.mycompany.mobile.dao.*;
import net.mycompany.mobile.dto.*;

public class ScheduleAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    
   public ScheduleAdminController() { }

   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");  
        System.out.println("action: "+action);               
        if ("view".equals(action))
            this.viewSchedule(request,response);       
        else if ("delete".equals(action))
            this.deleteSchedule(request,response);        
	}
	
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Schedule schedule=new Schedule(0);			
	        int idMovie = Integer.parseInt(request.getParameter("idMovie"));	    
	    	String msg="";
	    	int rows=0;
			try {
				schedule.setDate(format.parse(request.getParameter("date")));
		        schedule.setTime(request.getParameter("time"));
		        schedule.setScreen(request.getParameter("screen"));
		        schedule.setCost(Double.parseDouble(request.getParameter("cost")));		       
		        schedule.setMovie(MovieDao.getById(idMovie));		        				
				rows=ScheduleDao.insert(schedule);				
				msg="The schedule was saved.";
			}
			catch (Exception e){
				System.out.println("error aqui");
				msg=e.getMessage();
			}
	        
	        String url="/view/admin/schedule?action=view&id="+idMovie;
	        
	        request.setAttribute("message", msg);
	        request.setAttribute("urlBack", url);
	        RequestDispatcher rd;
	        rd = request.getRequestDispatcher("/view/admin/message.jsp");
			rd.forward(request, response);	        	       
	}
	
	protected void viewSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String idMovie = request.getParameter("id");
		RequestDispatcher rd;
		List<Schedule> listSchedule = null;
		Movie movie = null;		
		try {		
			listSchedule = ScheduleDao.getByMovie(Integer.parseInt(idMovie));
			movie = MovieDao.getById(Integer.parseInt(idMovie));
		} catch (Exception e) {
			System.out.println("Error: ScheduleController.java");
		} 	
		request.setAttribute("schedule", listSchedule);		
		request.setAttribute("movie", movie);
		rd = request.getRequestDispatcher("/view/admin/schedule/viewSchedule.jsp");
		rd.forward(request, response);
	}
	
	protected void deleteSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		int idMovie = Integer.parseInt(request.getParameter("idMovie"));
		int idSchedule = Integer.parseInt(request.getParameter("idSchedule"));
		int rows=0;
		RequestDispatcher rd;		
		try {			
			rows = ScheduleDao.delete(idSchedule);
		} catch (Exception e) {
			System.out.println("Error: ScheduleController.java");
		}
		String msg ="";
		if (rows==1){
			msg="The schedule was deleted";
		}
		else
			msg="There was an error. The schedule was not deleted.";
		request.setAttribute("message", msg);		
		rd = request.getRequestDispatcher("/view/admin/schedule?action=view&id="+idMovie);
		rd.forward(request, response);
	}
	
}
