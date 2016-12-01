package net.itinajero.zapateria.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.itinajero.zapateria.modelo.dao.*;
import net.itinajero.zapateria.modelo.dto.*;

@WebServlet(name = "GuardarProductoServlet", urlPatterns = {"/saveProducto"})
public class GuardarProductoServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {      
        	   DbConnection cn = new DbConnection();
        	   HttpSession sesion=request.getSession();
        	   Usuario user = (Usuario) sesion.getAttribute("usuario");
        	   //Usuario usuario=new Usuario();	
        	   int txtIdCliente=Integer.parseInt(request.getParameter("txtIdCliente"));
        	   int txtIdProducto =Integer.parseInt(request.getParameter("txtIdProducto"));
        	   int txtCantidad =Integer.parseInt(request.getParameter("txtCantidad"));
        	   double txtPrecio=Double.parseDouble(request.getParameter("txtPrecio"));
        	   int idSucursal = user.getSucursal().getIdSucursal();
        	   
        	   SimpleDateFormat formatoMysql = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        	   Date date = new Date();
        	   
        	   Venta venta= new Venta(0);
        	   venta.setFecha(formatoMysql.format(date));
        	   venta.setCantidad(txtCantidad);
        	   venta.setPrecio(txtPrecio);	
        	   venta.setSucursal(new Sucursal(idSucursal));
        	   venta.setCliente(new Cliente(txtIdCliente));
        	   venta.setProducto(new Producto(txtIdProducto));
    		   cn.getConnection().setAutoCommit(false);
        	   IVentaDao ventaDao = new VentaDao(cn);
        	   ventaDao.insert(venta);
       		   cn.getConnection().commit();
       		   cn.desconectar();
       		   request.setAttribute("msg", "La venta fue guardada");
        	   RequestDispatcher rd = request.getRequestDispatcher("Vista/frmVenta.jsp");
        	   rd.forward(request, response);
        } 
        catch (SQLException e){
        	System.out.println(e);
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
