package util.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggingFilter implements Filter {

   private ObjectMapper mapper;

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      System.out.println("Creando el ObjectMapper");
      mapper = new ObjectMapper();
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      try {
         HttpServletRequest req = (HttpServletRequest) request;
         HttpSession session = req.getSession(false); // No creamos session         
         if (session != null && session.getAttribute("usuario") != null) {
            int idAcceso = (Integer) session.getAttribute("id_acceso");
            Movimiento mov = new Movimiento();
            mov.setIdAcceso(idAcceso);
            mov.setIp(req.getRemoteAddr());
            String uri = req.getRequestURI(); // Requested Resource    
            //System.out.println("Procesando URI: " + uri);
            switch (uri) {               
               /**
                * Movimientos de Muebles y Vehiculos
                */
               case "/vista/atributosMueble.jsp":                  
                  mov.setTabla("muebles");
                  mov.setComentarios("Se crean los datos generales del mueble");
                  guardarMovimiento(req, mov);
                  break;
               case "/vista/saveMueble.jsp":                  
                  mov.setTabla("muebles");
                  mov.setComentarios("Se crean los atributos del mueble.");
                  guardarMovimiento(req, mov);
                  break;
               case "/modificarmuebles.jsp":                  
                  mov.setTabla("muebles");
                  mov.setComentarios("Se modifican los datos generales del mueble.");
                  guardarMovimiento(req, mov);
                  break;
               case "/mod_atrib_adicionales.jsp":                  
                  mov.setTabla("muebles");
                  mov.setComentarios("Se modifican los atributos del mueble.");
                  guardarMovimiento(req, mov);
                  break;
               /**
                * Movimientos de los resguardos
                */  
               case "/quitaractivresguardo.jsp":                  
                  mov.setTabla("detalles_resguardos");
                  mov.setComentarios("Se elimina un activo de un resguardo en solicitud.");
                  guardarMovimiento(req, mov);
                  break;   
               case "/quitaractivosderesguardo.jsp":                  
                  mov.setTabla("detalles_resguardos");
                  mov.setComentarios("Se eliminan varios activos de un resguardo en solicitud.");
                  guardarMovimiento(req, mov);
                  break;   
               case "/terminar_resguardo.jsp":                  
                  mov.setTabla("detalles_resguardos");
                  mov.setComentarios("Se termina un resguardo activo.");
                  guardarMovimiento(req, mov);
                  break;   
               case "/agregaractivosaresguardo.jsp":                  
                  mov.setTabla("detalles_resguardos");
                  mov.setComentarios("Se agregan activos a un resguardo en solicitud.");
                  guardarMovimiento(req, mov);
                  break;   
               case "/reasignar_resguardo.jsp":                  
                  mov.setTabla("detalles_resguardos");
                  mov.setComentarios("Se reasigna un resguardo activo. El campo txtids_detalles_resguardos son el id_activo(s) reasignados.");
                  guardarMovimiento(req, mov);
                  break;   
               /**
                * Movimientos de Solicitudes de Baja
                */    
               case "/guardardetalles_solicitudbaja.jsp":                  
                  mov.setTabla("detalles_solicitudes");
                  mov.setComentarios("Se crea una solicitud de baja. El campo txtids son el id_mueble(s) que se agregan a la solicitud de baja.");
                  guardarMovimiento(req, mov);
                  break;      
                  
                  
               default: // No hacemos nada para cualquier otra URI.
            }            
         }
      } catch (Exception e) {
         System.out.println("Error LoggingFilter.doFilter: " + e.getMessage());
      }
      chain.doFilter(request, response);
   }

   @Override
   public void destroy() {
   }

   private void guardarMovimiento(HttpServletRequest req, Movimiento movimiento) {
      try {
         Map<String, String> requestParam = new HashMap<>();
         Enumeration<String> enumeration = req.getParameterNames();
         while (enumeration.hasMoreElements()) {
            String parametername = enumeration.nextElement();
            requestParam.put(parametername, req.getParameter(parametername));
         }
         String json = mapper.writeValueAsString(requestParam);
         movimiento.setRequest(json);
         // Guardamos en la BD el movimiento
         MovimientosDAO.insert(movimiento);
      } catch (JsonProcessingException ex) {
         System.out.println("Error LoggingFilter.guardarMovimiento: " + ex.getMessage());
      }
   }
}
