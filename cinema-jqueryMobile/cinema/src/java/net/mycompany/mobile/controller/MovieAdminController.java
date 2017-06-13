package net.mycompany.mobile.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.mycompany.mobile.dao.*;
import net.mycompany.mobile.dto.Movie;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MovieAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "images/movies"; 
	
	 // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    public MovieAdminController() { }

   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");          
        if ("add".equals(action))
            this.addMovie(request,response);
        else if ("view".equals(action))
            this.viewMovies(request,response);
        else if ("delete".equals(action))
            this.deleteMovie(request,response);        
        else if ("active".equals(action))
            this.activeMovie(request,response);        
	}
	
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibimos el parametro de accion, para ver que solicito el cliente.
		String action = request.getParameter("action");  
		if ("save".equals(action))
            this.saveMovie(request,response);
	}

	protected void saveMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		// checks if the request actually contains upload file
        if (ServletFileUpload.isMultipartContent(request)) {
            // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // sets memory threshold - beyond which files are stored in disk
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // sets temporary location to store files
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	         
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	 
	        // constructs the directory path to store upload file
	        // this path is relative to application's directory
	        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
	         
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
	        	Movie movie= new Movie(0);
	            // parses the request's content to extract file data	            
	            List<FileItem> formItems = upload.parseRequest(request);
	            for (FileItem item : formItems) {
	                // processes only fields that are not form fields
	                if (!item.isFormField()) {
	                    String fileName = new File(item.getName()).getName();
	                    String filePath = uploadPath + File.separator + fileName;
	                    File storeFile = new File(filePath);
	 
	                    // saves the file on disk
	                    item.write(storeFile);	                    	                    	                   
	                    request.setAttribute("message","Upload has been done successfully!");
	                    movie.setImage(fileName);
	                }else{
	                	String name = item.getFieldName(); 
	                	String value = item.getString();	                	
	                	if(name.equals("title"))
	                		movie.setTitle(value);
	                	if(name.equals("cast"))
	                		movie.setCast(value);
	                	if(name.equals("director"))
	                		movie.setDirector(value);
	                	if(name.equals("year"))
	                		movie.setYear(Integer.parseInt(value));
	                	if(name.equals("duration"))
	                		movie.setDuration(Integer.parseInt(value));
	                	if(name.equals("genre"))
	                		movie.setGenre(value);
	                	if(name.equals("synopsis"))
	                		movie.setSynopsis(value);
	                }
	             } // for
	            movie.setStatus("coming");                
                // Insert Movie in DB	    		
	    		int idMovie=MovieDao.insert(movie);
	    		if (idMovie==0)
	    			request.setAttribute("message","There was an error");
            request.setAttribute("movie",movie);
	        } catch (Exception ex) {
	            request.setAttribute("message","There was an error: " + ex.getMessage());
	        }
        }
                
        RequestDispatcher rd;        
        rd = request.getRequestDispatcher("/view/admin/movie/detail.jsp");
		rd.forward(request, response);        
    }
	
	
	protected void addMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		RequestDispatcher rd;		
		rd = request.getRequestDispatcher("/view/admin/movie/addMovie.jsp");
		rd.forward(request, response);
	}
	
	protected void viewMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		RequestDispatcher rd;
		List<Movie> list = null;		
		try {			
			list = MovieDao.getAll();
		} catch (Exception e) {
			System.out.println("Error: MovieController.java");
		} 		
		request.setAttribute("movies", list);
		rd = request.getRequestDispatcher("/view/admin/movie/listMovies.jsp");
		rd.forward(request, response);
	}
	
	protected void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
		int idMovie = Integer.parseInt(request.getParameter("id"));	
		int rows=0;
		RequestDispatcher rd;
		
		try {			
			rows = MovieDao.delete(idMovie);
		} catch (Exception e) {
			System.out.println("Error: MovieController.java");
		} 
		String msg ="";
		if (rows==1){
			msg="The movie was deleted.";
		}
		else
			msg="There was an error. The movie was not deleted.";
		
		String url="view/admin/movie?action=view";
		request.setAttribute("message", msg);	
		request.setAttribute("urlBack", url);
		rd = request.getRequestDispatcher("/view/admin/message.jsp");
		rd.forward(request, response);
	}
   
	protected void activeMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
		int idMovie = Integer.parseInt(request.getParameter("id"));	
		int rows=0;
		RequestDispatcher rd;
		
		try {			
			rows = MovieDao.active(idMovie);
		} catch (Exception e) {
			System.out.println("Error: MovieAdminController.java");
		} 
		String msg ="";
		if (rows==1){
			msg="The movie was actived.";
		}
		else
			msg="There was an error. The movie was not actived.";
		
		String url="view/admin/movie?action=view";
		request.setAttribute("message", msg);	
		request.setAttribute("urlBack", url);
		rd = request.getRequestDispatcher("/view/admin/message.jsp");
		rd.forward(request, response);
	}

}
