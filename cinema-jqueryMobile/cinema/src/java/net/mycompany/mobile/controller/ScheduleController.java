package net.mycompany.mobile.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.mycompany.mobile.dao.*;
import net.mycompany.mobile.dto.*;
import net.mycompany.mobile.util.Utility;

public class ScheduleController extends HttpServlet {
       
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        if ("search".equals(action))
            this.searchByDate(request,response);
        else if ("detailMovie".equals(action))
            this.showDetailMovie(request,response);
        else if ("coming".equals(action))
            this.showComing(request,response);
        else if ("playing".equals(action))
            this.playingNow(request,response);
	}
	
	protected void searchByDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("txtDate");
		RequestDispatcher rd;
		List<Schedule> list = null;		
		try {			
			list = ScheduleDao.getByDate(date);
		} catch (Exception e) {
			System.out.println("Error: ScheduleController.java");
		} 
		String msg=date+" | "+list.size()+" movies found.";
		request.setAttribute("nextDays", Utility.getNextDays());
		request.setAttribute("schedule", list);
		request.setAttribute("message", msg);
		request.setAttribute("dateMovie", date);
		rd = request.getRequestDispatcher("/view/schedule/playing.jsp");
		rd.forward(request, response);
	}
	
	protected void showDetailMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("txtDate");
		int idMovie = Integer.parseInt(request.getParameter("idMovie"));
		RequestDispatcher rd;
		List<Schedule> list = null;
		Movie objMovie=null;		
		try {				
			list = ScheduleDao.getByMovieAndDate(idMovie, date);
			objMovie = MovieDao.getById(idMovie);
		
		} catch (Exception e) {
			System.out.println("Error: ScheduleController.java");
		} 	
		String msg=date;
		request.setAttribute("nextDays", Utility.getNextDays());		
		request.setAttribute("message", msg);
		request.setAttribute("schedule", list);
		request.setAttribute("dateMovie", date);
		request.setAttribute("movie", objMovie);
		rd = request.getRequestDispatcher("/view/movie/detail.jsp");
		rd.forward(request, response);
	}
	
	protected void showComing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd;
		List<Movie> list = null;		
		try {
			
			list = MovieDao.getComingSoon();
		} catch (Exception e) {
			System.out.println("Error: ScheduleController.java");
		} 
		String msg="Next movies...";
		request.setAttribute("nextDays", Utility.getNextDays());
		request.setAttribute("movies", list);
		request.setAttribute("message", msg);
		request.setAttribute("dateMovie", "");
		rd = request.getRequestDispatcher("/view/movie/coming.jsp");
		rd.forward(request, response);
	}

	protected void playingNow(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		List<Schedule> list = null;	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		try {			
			list = ScheduleDao.getToday();
		} catch (Exception e) {
			System.out.println("Error: Index.java");
		} 
		String results="Now Playing";
		request.setAttribute("message", results);
		request.setAttribute("nextDays", Utility.getNextDays());
		request.setAttribute("schedule", list);
		request.setAttribute("dateMovie", sdf.format(new Date()));
		// request.getRequestDispatcher("WEB-INF/view/rptSucursal.jsp");
		rd = request.getRequestDispatcher("/view/schedule/playing.jsp");
		rd.forward(request, response);
	}
	
}
