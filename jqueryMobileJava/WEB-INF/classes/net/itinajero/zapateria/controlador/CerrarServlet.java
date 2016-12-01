package net.itinajero.zapateria.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itinajero.zapateria.modelo.dto.Usuario;

@WebServlet(name = "CerrarServlet", urlPatterns = {"/logout"})
public class CerrarServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	 // Creamos una objeto de tipo sesion
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario) sesion.getAttribute("usuario");
            /*Verificamos si la sesion existe*/           
            if ((usuario.getIdUsuario() == 0)){
            	request.setAttribute("msg","Su sesión ha cadudado.");              
            }
            else{
            	request.setAttribute("msg","Gracias por utilizar Zapateria POS.");  
	            // Destruimos la sesion
	            sesion.invalidate();	           
            }
        	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        	rd.forward(request, response);
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
