package Bo;

import java.util.ArrayList;

import Bean.SeatBean;
import Dao.SeatDao;

public class SeatBo {
	ArrayList<SeatBean> listSeat;
	SeatBean gheBean = new SeatBean();
	SeatDao sDao = new SeatDao();
	
	public ArrayList<SeatBean> GetDanhGhe(){
		listSeat = sDao.GetDanhGhe();
		
		return listSeat;
	}
	public SeatBean GetGhe(int ID) {
		gheBean = sDao.GetGhe(ID);
		return gheBean;
	}
}
