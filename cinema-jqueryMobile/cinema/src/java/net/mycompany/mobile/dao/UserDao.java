package net.mycompany.mobile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.mycompany.mobile.dto.User;

public class UserDao{

	public UserDao() {
		
	}

	public static User getById(int idUser) throws Exception {
		DbConnection conn = new DbConnection();
		try {
			//DbConnection conn = new DbConnection();
			String sql = "select * from User where id=?";
			PreparedStatement preparedStatement = conn.getConnection()
					.prepareStatement(sql);
			preparedStatement.setInt(1, idUser); // Set idUser
			ResultSet rs = preparedStatement.executeQuery();
			User user = new User(0);
			while (rs.next()) {
				// Create an object for the user
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
            user.setPassword(""); // The password we don't need it            				
			}
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			conn.disconnect();
		}
	}

	public static List<User> getAll() throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from User order by id desc";
			PreparedStatement preparedStatement = conn.getConnection()
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<User> list = new ArrayList<User>();
			User user = new User(0);
			while (rs.next()) {
				user = new User(rs.getInt("id"));				
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
            //user.setPassword(""); // The password we don't need it   
				list.add(user);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			conn.disconnect();
		}
	}
	
	public static int delete(int idUser) throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "delete from User where id=?";
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, idUser);
			int rows = preparedStatement.executeUpdate();			
			return rows;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally{
			conn.disconnect();
		}
	}

	public static int insert(User user) throws Exception {
		DbConnection conn = new DbConnection();
		try {
			String sql = "insert into User values (?,?,?, md5(?) )";

			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getUsername());			
			preparedStatement.setString(4, user.getPassword());			
			preparedStatement.executeUpdate();
		   ResultSet rs = preparedStatement.getGeneratedKeys();
		   int idUser=0;
		   if (rs.next()){
		    	idUser=rs.getInt(1);
           
            // Insert the role
            sql = "insert into Role values (0,?,?)";
            preparedStatement = conn.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);	
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, "administrator");			
            preparedStatement.executeUpdate();
		   }            
		   return idUser;  

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally{
			conn.disconnect();
		}
	}	
   
}
