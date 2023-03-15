package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.MovieBean;

public class MovieDao {
	public ArrayList<MovieBean> GetMovies(){
		try {
			ArrayList<MovieBean> listMovies = new ArrayList<MovieBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Movie";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int movieID = rs.getInt("MovieID");
				String poster = rs.getString("Poster");
				String summary = rs.getString("Summary");
				String name = rs.getString("Name");
				String starring = rs.getString("Starring");
				String genre = rs.getString("Genre");
				int ticketID = rs.getInt("TicketID");
				String director = rs.getString("Director");
				java.sql.Date releaseDate = rs.getDate("ReleaseDate");
				
				System.out.print("cc: "+ rs.getDate("ReleaseDate"));
				
				boolean isRelease = rs.getBoolean("isRelease");
				
				listMovies.add(new MovieBean(movieID, poster, summary, name, starring, genre, ticketID, director, releaseDate, isRelease));
				
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
						
			return listMovies;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public MovieBean GetMovie(int _movieID) {
		MovieBean movie = new MovieBean();
		try {
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Movie where MovieID = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setInt(1, _movieID);
			
			ResultSet rs = cmd.executeQuery();
			
			// b3
			if(rs.next()) {
				int movieID = rs.getInt("MovieID");
				String poster = rs.getString("Poster");
				String summary = rs.getString("Summary");
				String name = rs.getString("Name");
				String starring = rs.getString("Starring");
				String genre = rs.getString("Genre");
				int ticketID = rs.getInt("TicketID");
				String director = rs.getString("Director");
				java.sql.Date releaseDate = rs.getDate("ReleaseDate");
				boolean isRelease = rs.getBoolean("isRelease");
				
				movie = new MovieBean(movieID, poster, summary, name, starring, 
						genre, ticketID, director, releaseDate, isRelease);
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
						
			return movie;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public void SetMovie(String poster, String summary, 
			String name, String starring, String genre, String director, 
			boolean isRelease) {
		try {
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Insert du lieu
			String sql = "INSERT INTO Movie (Poster, Summary, Name, Starring, Genre, Director, ReleaseDate, isRelease)"
					+ " VALUES(?,?,?,?,?,?,getdate(),?) ";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1, poster);
			cmd.setString(2, summary);
			cmd.setString(3, name);
			cmd.setString(4, starring);
			cmd.setString(5, genre);
			cmd.setString(6, director);
			cmd.setBoolean(7, isRelease);
			
			ResultSet rs = cmd.executeQuery();
			
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
						
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void DeleteMovie(int movieID) {
		try {
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Insert du lieu
			String sql = "delete from Movie where MovieID=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setInt(1, movieID);
			
			ResultSet rs = cmd.executeQuery();
			
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
						
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
