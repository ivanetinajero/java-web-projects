package net.itinajero.zapateria.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.itinajero.zapateria.modelo.dao.*;
import net.itinajero.zapateria.modelo.dto.*;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/getProducto"})
public class ProductoServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	HttpSession sesion=request.getSession();
        	   String codigoBarras=request.getParameter("codigo");
        	   DbConnection cn = new DbConnection();
        	   IProductoDao productoDao = new ProductoDao(cn);
        	   Producto producto = productoDao.getByCodigo(codigoBarras);
        	   cn.desconectar(); 
        	   response.setHeader("Content-Type", "text/xml;charset=utf-8");
        	   if (producto.getIdProducto()>0) {
        		   //Comenzamos a formar los registros en formato XML para enviarlos al JavaScript
        		   out.println("<Registros>");
        		   out.println("<producto idProducto='"+producto.getIdProducto()+"' ");
        		   out.println("descripcion='"+producto.getDescripcion()+"' ");
        		   out.println("precioVenta='"+producto.getPrecioVenta()+"' ");
        		   out.println("categoria='"+producto.getCategoria().getDescripcion()+"' ");
        		   out.println("></producto>");
        		   out.println("</Registros>");  
        	   }
        	   else{
        		   out.println("<Registros>");
        		   out.println("</Registros>");  
        	   }   
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
