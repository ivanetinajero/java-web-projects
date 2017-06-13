package net.mycompany.mobile.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import net.mycompany.mobile.dto.Schedule;
import net.mycompany.mobile.dto.Movie;

public class ScheduleDao{

	public ScheduleDao() {
	
	}

	public static List<Schedule> getToday() throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from Schedule s "+
						" inner join Movie m on m.id=s.idMovie "+
						" where s.date = DATE_FORMAT(NOW(),'%Y-%m-%d') and m.status='active' " +
						" group by s.idMovie order by s.idMovie desc";

			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			//preparedStatement.setString(1, param1); // Set param1
			ResultSet rs = preparedStatement.executeQuery();
			List<Schedule> list = new ArrayList<Schedule>();
			Schedule schedule;
			
			while (rs.next()) {
				// Create an object for the movie
				Movie movie = MovieDao.getById(rs.getInt("idMovie"));
				// Create an object for the schedule 
				schedule = new Schedule(rs.getInt("id"));					
				// Insert reference to the movie object created above
				schedule.setMovie(movie);
				schedule.setDate(rs.getDate("date"));
				schedule.setTime(rs.getString("time"));
				schedule.setCost(rs.getDouble("cost"));
				schedule.setScreen(rs.getString("screen"));
				// Add Schedule object to the list
				list.add(schedule);
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

	public static List<Schedule> getByDate(String date) throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from Schedule s "+
						" inner join Movie m on m.id=s.idMovie "+
						" where s.date = ? and m.status='active' "+
						" group by s.idMovie order by s.idMovie desc";

			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, date); // Set date parameter
			ResultSet rs = preparedStatement.executeQuery();
			List<Schedule> list = new ArrayList<Schedule>();
			Schedule schedule;
						
			while (rs.next()) {
				// Create an object for the movie
				Movie movie = MovieDao.getById(rs.getInt("idMovie"));
				
				// Create an object for the schedule 
				schedule = new Schedule(rs.getInt("id"));					
				// Insert reference to the movie object created above
				schedule.setMovie(movie);
				schedule.setDate(rs.getDate("date"));
				schedule.setTime(rs.getString("time"));
				schedule.setCost(rs.getDouble("cost"));
				schedule.setScreen(rs.getString("screen"));
				// Add Schedule object to the list
				list.add(schedule);
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
	
	public static List<Schedule> getByMovieAndDate(int idMovie, String date) throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from Schedule s where s.date = ? and s.idMovie=? order by time";						
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, date); // Set date parameter
			preparedStatement.setInt(2, idMovie); // Set idMovie parameter
			ResultSet rs = preparedStatement.executeQuery();
			List<Schedule> list = new ArrayList<Schedule>();
			Schedule schedule;
					
			while (rs.next()) {				
				// Create an object for the schedule 
				schedule = new Schedule(rs.getInt("id"));					
				schedule.setDate(rs.getDate("date"));
				schedule.setTime(rs.getString("time"));
				schedule.setCost(rs.getDouble("cost"));
				schedule.setScreen(rs.getString("screen"));
				// Add Schedule object to the list
				list.add(schedule);
				
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

	public static List<Schedule> getByMovie(int idMovie) throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "select * from Schedule s where s.idMovie=? order by date,time";						
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);			
			preparedStatement.setInt(1, idMovie); // Set idMovie parameter
			ResultSet rs = preparedStatement.executeQuery();
			List<Schedule> list = new ArrayList<Schedule>();
			Schedule schedule;
					
			while (rs.next()) {				
				// Create an object for the schedule 
				schedule = new Schedule(rs.getInt("id"));					
				schedule.setDate(rs.getDate("date"));
				schedule.setTime(rs.getString("time"));
				schedule.setCost(rs.getDouble("cost"));
				schedule.setScreen(rs.getString("screen"));
				// Add Schedule object to the list
				list.add(schedule);
				
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

	public static int delete(int idSchedule) throws Exception {
		DbConnection conn = new DbConnection();
		try {

			String sql = "delete from Schedule where id=?";
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, idSchedule);
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

	public static int insert(Schedule schedule) throws Exception {
		DbConnection conn = new DbConnection();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String sql = "insert into Schedule values (?,?,?,?,?,?)";
			System.out.println("insert schedule" + schedule);
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, schedule.getId());
			preparedStatement.setInt(2, schedule.getMovie().getId());
			preparedStatement.setString(3, format.format(schedule.getDate()));
			preparedStatement.setString(4, schedule.getTime());
			preparedStatement.setString(5, schedule.getScreen());
			preparedStatement.setDouble(6, schedule.getCost());			
			preparedStatement.executeUpdate();
		    ResultSet rs = preparedStatement.getGeneratedKeys();
		    int idSchedule=0;
		    if (rs.next()){
		    	idSchedule=rs.getInt(1);
		    }            
		    return idSchedule;  

		} catch (SQLException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			conn.disconnect();
		}
	}
}
