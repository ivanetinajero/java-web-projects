package util.logging;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import saaf.DbConnection;

public class MovimientosDAO {
   /**
    * Metodo para insertar un movimiento en la bd    
    * @param movimiento
    */
   public static void insert(Movimiento movimiento) {
      //System.out.println("Persisting :" + movimiento);
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      try {
         DbConnection conn = new DbConnection();
         String sql = "insert into movimientos values (?,?,?,?,?,?,?)";
         PreparedStatement ps = conn.getConnection().prepareStatement(sql);
         ps.setInt(1, movimiento.getId());        
         ps.setString(2, format.format(movimiento.getFecha()));        
         ps.setString(3,movimiento.getTabla());
         ps.setInt(4,movimiento.getIdAcceso());
         ps.setString(5,movimiento.getRequest());
         ps.setString(6,movimiento.getIp());
         ps.setString(7,movimiento.getComentarios());
         ps.executeUpdate();
         ps.close();
         conn.desconectar();
      } catch (Exception e) {        
         System.out.println("Error MovimientosDAO.insert: " + e.getMessage());       
      }       
   }
}
