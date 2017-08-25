package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

   private DbConnection conn;
   private int noOfRecords;

   public EmployeeDAO(DbConnection conn) {
      this.conn = conn;
   }

   public List<Employee> viewAllEmployees(int offset, int noOfRecords) {
      System.out.println("offset " + offset);
      System.out.println("noOfRecords " + noOfRecords);
      try {
         String query = "select SQL_CALC_FOUND_ROWS * from employee limit ?, ? ";
                  
         PreparedStatement stm = conn.getConnection().prepareStatement(query);
         stm.setInt(1, offset);
         stm.setInt(2, noOfRecords);
         ResultSet rs = stm.executeQuery();
         List<Employee> list = new ArrayList<>();
         Employee employee;
         while (rs.next()) {
            employee = new Employee();
            employee.setEmployeeId(rs.getInt(1));
            employee.setEmployeeName(rs.getString(2));
            employee.setSalary(rs.getInt(3));
            employee.setDeptName(rs.getString(4));
            list.add(employee);
         }
         rs = stm.executeQuery("SELECT FOUND_ROWS()");
         if (rs.next()) {
            this.noOfRecords = rs.getInt(1);
         }         
         return list;
      } catch (SQLException ex) {
         System.out.println("Error: " + ex.getMessage());
         return null;
      }
}

public int getNoOfRecords() {
      return noOfRecords;
   }
}
