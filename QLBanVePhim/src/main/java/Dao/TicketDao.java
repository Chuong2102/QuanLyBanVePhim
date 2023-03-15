package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Bean.SuatChieuBean;
import Bean.TicketBean;

public class TicketDao {
	public ArrayList<TicketBean> GetDanhSachVe(){
		try {
			ArrayList<TicketBean> listTicket = new ArrayList<TicketBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Ticket";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int TicketID = rs.getInt("TicketID");
				int MovieID = rs.getInt("MovieID");
				long Price = rs.getLong("Price");
				Time time = rs.getTime("Time");
				int RoomID = rs.getInt("RoomID");
				java.sql.Date WatchDate = rs.getDate("WatchDate");
				Time EndTime = rs.getTime("EndTime");
				int ShowTimeID = rs.getInt("ShowTimeID");
				
				// THem
				listTicket.add(new TicketBean(TicketID, MovieID, Price, time, RoomID, WatchDate, EndTime, ShowTimeID));
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return listTicket;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public ArrayList<TicketBean> GetVeTheoSuat(int movieID, int showTimeID){
		try {
			ArrayList<TicketBean> listTicket = new ArrayList<TicketBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Ticket where MovieID=? and ShowTimeID=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setInt(1, movieID);
			cmd.setInt(2, showTimeID);
			
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int TicketID = rs.getInt("TicketID");
				int MovieID = rs.getInt("MovieID");
				long Price = rs.getLong("Price");
				Time time = rs.getTime("Time");
				int RoomID = rs.getInt("RoomID");
				java.sql.Date WatchDate = rs.getDate("WatchDate");
				Time EndTime = rs.getTime("EndTime");
				int ShowTimeID = rs.getInt("ShowTimeID");
				
				// THem
				listTicket.add(new TicketBean(TicketID, MovieID, Price, time, RoomID, WatchDate, EndTime, ShowTimeID));
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return listTicket;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public TicketBean getTicketByID(int ticketID) {
		try {
			TicketBean ticket = new TicketBean();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Ticket where TicketID=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setInt(1, ticketID);
			
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int TicketID = rs.getInt("TicketID");
				int MovieID = rs.getInt("MovieID");
				long Price = rs.getLong("Price");
				Time time = rs.getTime("Time");
				int RoomID = rs.getInt("RoomID");
				java.sql.Date WatchDate = rs.getDate("WatchDate");
				Time EndTime = rs.getTime("EndTime");
				int ShowTimeID = rs.getInt("ShowTimeID");
				
				// THem
				ticket = new TicketBean(TicketID, MovieID, Price, time, RoomID, WatchDate, EndTime, ShowTimeID);
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return ticket;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
}
