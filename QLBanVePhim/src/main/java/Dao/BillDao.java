package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.BillBean;
import Bean.MovieBean;


public class BillDao {
	public ArrayList<BillBean> GetBill(){
		try {
			ArrayList<BillBean> listMovies = new ArrayList<BillBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Bill";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int BillID = rs.getInt("BillID");
				int TicketID = rs.getInt("TicketID");
				int SeatID = rs.getInt("SeatID");
				
				listMovies.add(new BillBean(BillID, TicketID, SeatID));
				
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
	
	public ArrayList<BillBean> IBill(){
		try {
			ArrayList<BillBean> listMovies = new ArrayList<BillBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from Bill";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int BillID = rs.getInt("BillID");
				int TicketID = rs.getInt("TicketID");
				int SeatID = rs.getInt("SeatID");
				
				listMovies.add(new BillBean(BillID, TicketID, SeatID));
				
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
}
