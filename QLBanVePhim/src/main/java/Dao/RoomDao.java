package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import Bean.RoomBean;
import Bean.TicketBean;

public class RoomDao {
	public ArrayList<RoomBean> GetDanhSachPhong(){
		try {
			ArrayList<RoomBean> listRoom = new ArrayList<RoomBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Room";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int RoomID = rs.getInt("RoomID");
				int RoomNumber = rs.getInt("RoomNumber");
				
				// THem
				listRoom.add(new RoomBean(RoomID, RoomNumber));
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return listRoom;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public RoomBean GetPhongID(int roomID){
		try {
			RoomBean room = new RoomBean();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Room where RoomID=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, roomID);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int RoomID = rs.getInt("RoomID");
				int RoomNumber = rs.getInt("RoomNumber");
				
				// THem
				room = new RoomBean(RoomID, RoomNumber);
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return room;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
