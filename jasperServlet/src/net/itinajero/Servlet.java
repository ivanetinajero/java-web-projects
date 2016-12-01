package net.itinajero;

import net.sf.jasperreports.engine.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author itinajero 
 */
@WebServlet(name = "ServletDemo", urlPatterns = {"/reportUsers"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.     
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try {
        	/*Parametros para realizar la conexión*/
        	Connection conexion;
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/saaf", "root", "admin");
        	
        	Map parameters = new HashMap();
        	parameters.put("Nombre_parametro", "Valor_Parametro");
        		
        	ServletOutputStream servletOutputStream = response.getOutputStream();
            File reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/users.jasper"));
            byte[] bytes = null;
            bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);

            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);

            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();
            
        } catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {            
            //out.close();
        }
    }
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
