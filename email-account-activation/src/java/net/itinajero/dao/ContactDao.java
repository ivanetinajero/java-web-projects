package net.itinajero.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.itinajero.dto.Contact;

public class ContactDao {
   private DbConnection conn;

   public ContactDao(DbConnection conn) {
      this.conn = conn;
   }
   
   public String insert(Contact contacto) {
      String response="";
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Date now = new Date();
      try {
         String sql = "insert into Contact values (?,?,?,?,?,?,?,?,?)";
         PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
         preparedStatement.setInt(1, contacto.getId());
         preparedStatement.setString(2, contacto.getName());
         preparedStatement.setString(3, contacto.getEmail());
         preparedStatement.setString(4, contacto.getSource());
         preparedStatement.setString(5, contacto.getCode());
         preparedStatement.setString(6, contacto.getCodeMD5());
         preparedStatement.setInt(7, contacto.getActive()); 
         preparedStatement.setString(8, format.format(now)); // la fecha del servidor       
         preparedStatement.setString(9, null);
         int rows = preparedStatement.executeUpdate();
         if (rows==1)
            response = "ok";
         return response;
      } catch (SQLException e) {        
         System.out.println("Error ContactDao.insert: " + e.getMessage());
         return e.getMessage();
      }
   }
   
   public String activate(String email) {
      String response="";
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Date now = new Date();
      try {
         String sql = "update Contact set active=1, dateAct = ? where email = ? limit 1";
         PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
         preparedStatement.setString(1, format.format(now));
         preparedStatement.setString(2, email);                 
         int rows = preparedStatement.executeUpdate();
         if (rows==1)
            response = "ok";
         return response;
      } catch (SQLException e) {        
         System.out.println("Error ContactDao.activate: " + e.getMessage());
         return e.getMessage();
      }
   }
   
   public boolean getByEmailHash(String email, String hash) {
      boolean exist = false;
      try {         
         String sql = "select * from Contact where email=? and codeMD5= ? and active = 0 limit 1";
         PreparedStatement pst = conn.getConnection().prepareStatement(sql);
         pst.setString(1, email);
         pst.setString(2, hash); // sha-256
         ResultSet rs = pst.executeQuery();     
         if (rs.next()) {
            exist = true;
         }
         rs.close();
         pst.close();
         return exist;
      } catch (SQLException ex) {
         System.out.println("Error ContactDao.getByEmailHash: " + ex.getMessage());
         return false;
      }
   }
}
