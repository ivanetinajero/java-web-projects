package net.itinajero.zapateria.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itinajero.zapateria.modelo.dao.*;
import net.itinajero.zapateria.modelo.dto.*;
/**
 *
 * @author itinajero
 * Equivalente web.xml
 * <servlet>
        <servlet-name>ServletDemo</servlet-name>
        <servlet-class>com.itinajero.ServletDemo</servlet-class>
    </servlet>
   <servlet-mapping>
        <servlet-name>ServletDemo</servlet-name>
        <url-pattern>/ServletDemoUrl</url-pattern>
    </servlet-mapping>
 */
@WebServlet(name = "ServletDemo", urlPatterns = {"/venta"})
public class VentaServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {        	
        	HttpSession sesion=request.getSession();
        	Usuario user = (Usuario) sesion.getAttribute("usuario");
        	DbConnection cn = new DbConnection();
        	IVentaDao ventaDao = new VentaDao(cn); 
        	List<Venta> listaVentas =null;
        	// Es un administrador. Le mostramos todas las ventas
        	if (user.getTipo().equals("admin")){
        	   	listaVentas = ventaDao.getByFecha(0);
        	// Es un vendedor. Mostramos todas las ventas de su sucursal solamente
        	}
        	else{
        		listaVentas = ventaDao.getByFecha(user.getSucursal().getIdSucursal());
        	}
        	request.setAttribute("listaVentas", listaVentas);
        	RequestDispatcher rd = request.getRequestDispatcher("Vista/rptSucursal.jsp");
        	rd.forward(request, response);
        } 
        catch (SQLException e){
        	
        }
        finally {            
            out.close();
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
