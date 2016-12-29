package net.itinajero.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.itinajero.dao.ContactDao;
import net.itinajero.dao.DbConnection;
import net.itinajero.dto.Contact;
import org.apache.commons.codec.digest.DigestUtils;
import util.EmailThread;
import util.Utility;

public class RegistrationServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      // Recibimos los datos del FORM
      String email = request.getParameter("paramEmail");
      String name = request.getParameter("paramName");
      String source = request.getParameter("paramSource");

      // Generamos una cadena aleatoria
      String code = Utility.randomAlphaNumeric(10);
      String codeMD5 = DigestUtils.md5Hex(code);

      Contact contact = new Contact(0);
      contact.setName(name);
      contact.setEmail(email);
      contact.setSource(source);
      contact.setCode(code);
      contact.setCodeMD5(codeMD5);

      DbConnection conn = new DbConnection();
      ContactDao dao = new ContactDao(conn);
      String result = dao.insert(contact);
      conn.disconnect();
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      if (result.equals("ok")) { // se inserto, podemos mandar el email
         sendEmail(contact); // Enviamos el email con la URL de Activacion
         out.println(result);
      } else {
         out.println("error: " + result);
      }
   }

   private void sendEmail(Contact contact) {
      String publicUrl = getServletContext().getInitParameter("publicUrl");      
      String paramsUrl="email="+contact.getEmail()+"&hash="+contact.getCodeMD5();
      String urlActivation = publicUrl+paramsUrl;
      String msgEmail = "<p><b>Hola "+contact.getName()+". ¡Gracias por registrate!</b></p>";
      msgEmail += "<p>Tu usuario es: "+contact.getEmail()+"</p>";
      msgEmail += "<p>Tu password es: "+contact.getCode()+"</p>";
      msgEmail += "<p>Para confirmar tu dirección de email haz clic en la siguiente URL:</p>";
      msgEmail += urlActivation;
      //System.out.println("URL Completa: " + msgEmail);
      List<String> recipients = new LinkedList();
      recipients.add(contact.getEmail());
      EmailThread email1 = new EmailThread(recipients, "Confirmación de Email", msgEmail, "");
      email1.start();
   }
}
