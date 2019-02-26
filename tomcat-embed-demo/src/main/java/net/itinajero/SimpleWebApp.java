package net.itinajero;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import net.itinajero.controller.SumaController;

public class SimpleWebApp {
	
	public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();        
        tomcat.setSilent(false);
        tomcat.setBaseDir("temp");
        tomcat.setPort(8080);
        // Trigger the creation of the default connector (Apache Tomcat 9)
        tomcat.getConnector(); 
         
        String contextPath = "/";
        String docBase = new File(".").getAbsolutePath();
         
        Context context = tomcat.addContext(contextPath, docBase);
         
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                 
                writer.println("<!doctype html><html><title>Welcome</title><body>");
                writer.println("<h1>Have a Great Day!</h1>");
                writer.println("</body></html>");
            }
        };
         
        String servletName = "Servlet1";
        String urlPattern = "/go";
         
        tomcat.addServlet(contextPath, servletName, servlet);      
        context.addServletMappingDecoded(urlPattern, servletName);
         
        // Agregamos un Servlet desde una clase separada
        SumaController sumaController = new SumaController();
        servletName = "AddServlet";
        urlPattern = "/add";
        tomcat.addServlet(contextPath, servletName, sumaController);
        context.addServletMappingDecoded(urlPattern, servletName);        
        
        tomcat.start();
        tomcat.getServer().await();
    }

}
