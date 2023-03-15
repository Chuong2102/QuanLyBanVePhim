package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import Bean.SeatBean;
import Bean.TicketBean;

public class SeatDao {
	public ArrayList<SeatBean> GetDanhGhe(){
		try {
			ArrayList<SeatBean> listSeat = new ArrayList<SeatBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Seat";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int SeatID = rs.getInt("SeatID");
				String Row = rs.getString("Row");
				int TicketID = rs.getInt("TicketID");
				boolean CoupleSeat = rs.getBoolean("CoupleSeat");
				String Name = rs.getString("Name");
				boolean Sold = rs.getBoolean("Sold");
				
				// THem
				listSeat.add(new SeatBean(SeatID, Row, TicketID, CoupleSeat, Name, Sold));
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return listSeat;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public SeatBean GetGhe(int ID){
		try {
			SeatBean ghe = new SeatBean();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Seat where SeatID=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, ID);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int SeatID = rs.getInt("SeatID");
				String Row = rs.getString("Row");
				int TicketID = rs.getInt("TicketID");
				boolean CoupleSeat = rs.getBoolean("CoupleSeat");
				String Name = rs.getString("Name");
				boolean Sold = rs.getBoolean("Sold");
				
				// THem
				ghe = new SeatBean(SeatID, Row, TicketID, CoupleSeat, Name, Sold);
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return ghe;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
