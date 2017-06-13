package net.mycompany.mobile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.mycompany.mobile.dto.Movie;

public class MovieDao{

	public MovieDao() {
		
	}

	public static Movie getById(int idMovie) throws Exception {
		DbConnection conn = new DbConnection();
		try {
			//DbConnection conn = new DbConnection();
			String sql = "select * from Movie where id=?";
			PreparedStatement preparedStatement = conn.getConnection()
					.prepareStatement(sql);
			preparedStatement.setInt(1, idMovie); // Set idMovie
			ResultSet rs = preparedStatement.executeQuery();
			Movie movie = new Movie(0);
			while (rs.next()) {
				// Create an object for the movie
				movie.setId(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				movie.setCast(rs.getString("cast"));
				movie.setDirector(rs.getString("director"));
				movie.setYear(rs.getInt("year"));
				movie.setDuration(rs.getInt("duration"));
				movie.setGenre(rs.getString("genre"));
				movie.setSynopsis(rs.getString("synopsis"));
				movie.setStatus(rs.getString("status"));
				movie.setImage(rs.getString("image"));
			}
			return movie;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			conn.disconnect();
		}
	}

	public static List<Movie> getComingSoon() throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from Movie where status='coming' order by id";
			PreparedStatement preparedStatement = conn.getConnection()
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<Movie> list = new ArrayList<Movie>();
			Movie movie = new Movie(0);
			while (rs.next()) {
				movie = new Movie(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				movie.setCast(rs.getString("cast"));
				movie.setDirector(rs.getString("director"));
				movie.setYear(rs.getInt("year"));
				movie.setDuration(rs.getInt("duration"));
				movie.setGenre(rs.getString("genre"));
				movie.setSynopsis(rs.getString("synopsis"));
				movie.setStatus(rs.getString("status"));
				movie.setImage(rs.getString("image"));
				list.add(movie);
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

	public static List<Movie> getAll() throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from Movie";
			PreparedStatement preparedStatement = conn.getConnection()
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<Movie> list = new ArrayList<Movie>();
			Movie movie = new Movie(0);
			while (rs.next()) {
				movie = new Movie(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				movie.setCast(rs.getString("cast"));
				movie.setDirector(rs.getString("director"));
				movie.setYear(rs.getInt("year"));
				movie.setDuration(rs.getInt("duration"));
				movie.setGenre(rs.getString("genre"));
				movie.setSynopsis(rs.getString("synopsis"));
				movie.setStatus(rs.getString("status"));
				movie.setImage(rs.getString("image"));
				list.add(movie);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			conn.disconnect();
		}
	}

	public static int delete(int id) throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "delete from Movie where id=?";
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
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

	public static int insert(Movie movie) throws Exception {
		DbConnection conn = new DbConnection();
		try {
			String sql = "insert into Movie values (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, movie.getId());
			preparedStatement.setString(2, movie.getTitle());
			preparedStatement.setString(3, movie.getCast());
			preparedStatement.setString(4, movie.getDirector());
			preparedStatement.setInt(5, movie.getYear());
			preparedStatement.setInt(6, movie.getDuration());
			preparedStatement.setString(7, movie.getGenre());
			preparedStatement.setString(8, movie.getSynopsis());
			preparedStatement.setString(9, movie.getStatus());
			preparedStatement.setString(10, movie.getImage());
			preparedStatement.executeUpdate();
		    ResultSet rs = preparedStatement.getGeneratedKeys();
		    int idMovie=0;
		    if (rs.next()){
		    	idMovie=rs.getInt(1);
		    }            
		    return idMovie;  

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally{
			conn.disconnect();
		}
	}	
   
   public static int active(int id) throws Exception {
		DbConnection conn = new DbConnection();
		try {
         
			String sql = "update Movie set status = 'active' where id=?";
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();	
         System.out.println("afectadas:"+rows);
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
}
