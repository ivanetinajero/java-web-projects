package net.itinajero.dao;

import java.sql.*;

public class DbConnection {

   static String bd = "email_listdb";
   static String login = "root";
   static String password = "admin";
   static String url = "jdbc:mysql://localhost/" + bd;
   // Esta variable va a guardar la conexion
   Connection conn = null;

   public DbConnection() {
      try {
         //obtenemos el driver para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexion
         conn = DriverManager.getConnection(url, login, password);
         // Si conn no es nulo, significa que si se pudo conectar
         if (conn != null) {
            System.out.println("Connecting database [" + conn + "] OK");
         }
      } catch (SQLException e) // Excepcion ocurrida por la conexion 
      {
         System.out.println("Excepcion conexion: " + e.getMessage());         
      } catch (ClassNotFoundException e) // Excepcion ocurrida por no encontrar el driver
      {
         System.out.println("Excepcion driver: " + e.getMessage());         
      }
   }

   public Connection getConnection() {      
      return conn;
   }

   // Quitamos de memoria la conexion
   public void disconnect() {
      System.out.println("Closing database: [" + conn + "] OK");
      if (conn != null) {
         try {
            // System.out.println("Desconectado de " + bd + " OK");
            conn.close();
         } catch (SQLException e) {
            System.out.println(e);
         }
      }
   }
}
