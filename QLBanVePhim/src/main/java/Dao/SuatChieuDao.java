package Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.SuatChieuBean;

public class SuatChieuDao {
	public ArrayList<SuatChieuBean> GetDanhSachSuatChieu(){
		try {
			ArrayList<SuatChieuBean> listSuatChieu = new ArrayList<SuatChieuBean>();
			
			// b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: Lay du lieu ve
			String sql = "select * from dbo.SuatChieu";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			// b3
			while(rs.next()) {
				int MovieID = rs.getInt("MovieID");
				int ShowTimeID = rs.getInt("ShowTimeID");
				Date WatchDate = rs.getDate("Date");
				
				// THem
				listSuatChieu.add(new SuatChieuBean(MovieID, ShowTimeID, WatchDate));
			}
			
			//b4: dong ket noi
			rs.close();
			kn.cn.close();
			
			return listSuatChieu;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	
	
}
