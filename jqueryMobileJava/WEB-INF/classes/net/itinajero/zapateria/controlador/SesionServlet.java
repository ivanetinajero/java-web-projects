package net.itinajero.zapateria.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itinajero.zapateria.modelo.dao.*;
import net.itinajero.zapateria.modelo.dto.*;

@WebServlet(name = "SesionServlet", urlPatterns = {"/login"})
public class SesionServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	 HttpSession sesion=request.getSession();
        	   //Usuario usuario=new Usuario();	
        	   String tmpuser=request.getParameter("txtName");
        	   String tmppassword =request.getParameter("txtPass");  
        	   
        	   DbConnection cn = new DbConnection();
        	   IUsuarioDao usuarioDao = new UsuarioDao(cn);
        	   Usuario usuarioForm = new Usuario(0);
        	   Usuario usuario = new Usuario(0);
        	   usuarioForm.setUsuario(tmpuser);
        	   usuarioForm.setPassword(tmppassword);
        	   //Revisamos si es un usuario valido
        	   usuario=usuarioDao.getLogin(usuarioForm);
        	   cn.desconectar();
        	   // Usuario valido
        	   String archivoVista="";
        	   if (usuario.getIdUsuario()>0){
        		   // Creamos las variables de sesion del usuario	   
        		   sesion.setAttribute("usuario",usuario);	   
        		   archivoVista="Vista/frmMenu.jsp";
        	   }
        	   // Usuario no valido
        	   else{
        		   sesion.setAttribute("msg","¡¡ Usuario /Password incorrecto !!");
        		   archivoVista="index.jsp";
        	   }           	
        	RequestDispatcher rd = request.getRequestDispatcher(archivoVista);
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
