package Bo;

import java.util.ArrayList;

import Bean.NgayChieuBean;
import Dao.NgayChieuDao;

public class NgayChieuBo {
	ArrayList<NgayChieuBean> listNgayChieu;
	NgayChieuDao nDao = new NgayChieuDao();
	
	public ArrayList<NgayChieuBean> GetDanhSachNgayChieu(){
		listNgayChieu = nDao.GetDanhSachNgayChieu();
		
		return listNgayChieu;
	}
	
	public NgayChieuBean GetNgayChieuTheoID(int showTimeID) {
		NgayChieuBean ngayChieu = nDao.GetNgayChieuTheoID(showTimeID);
		
		return ngayChieu;
	}
}
