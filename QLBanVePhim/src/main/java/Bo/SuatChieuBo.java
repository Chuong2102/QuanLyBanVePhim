package Bo;

import java.util.ArrayList;

import Bean.SuatChieuBean;
import Dao.SuatChieuDao;

public class SuatChieuBo {
	SuatChieuDao sDao = new SuatChieuDao();
	ArrayList<SuatChieuBean> listSuatChieu;
	
	public ArrayList<SuatChieuBean> GetDanhSachSuatChieu(){
		listSuatChieu = sDao.GetDanhSachSuatChieu();
		return listSuatChieu;
	}
}
