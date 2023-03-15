package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.NgayChieuBean;
import Bean.SuatChieuBean;

public class NgayChieuDao {
	public ArrayList<NgayChieuBean> GetDanhSachNgayChieu(){
		try {
			ArrayList<NgayChieuBean> listNgayChieu = new ArrayList<NgayChieuBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from dbo.ShowTime";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int ShowTimeID = rs.getInt("ShowTimeID");
				Date WatchDate = rs.getDate("Date");
				
				// THem
				listNgayChieu.add(new NgayChieuBean(ShowTimeID, WatchDate));
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return listNgayChieu;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public NgayChieuBean GetNgayChieuTheoID(int showTimeID) {
		try {
			NgayChieuBean ngayChieu = new NgayChieuBean();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from dbo.ShowTime where ShowTimeID=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setInt(1, showTimeID);
			
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int ShowTimeID = rs.getInt("ShowTimeID");
				Date WatchDate = rs.getDate("Date");
				
				// THem
				ngayChieu = new NgayChieuBean(ShowTimeID, WatchDate);
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return ngayChieu;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	
	
}
