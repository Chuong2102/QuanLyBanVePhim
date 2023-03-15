package Bo;

import java.util.ArrayList;

import Bean.RoomBean;
import Dao.RoomDao;

public class RoomBo {
	RoomDao rDao = new RoomDao();
	ArrayList<RoomBean> listRoom;
	
	public ArrayList<RoomBean> GetDanhSachPhong(){
		listRoom = rDao.GetDanhSachPhong();
		
		return listRoom;
	}
	
	public RoomBean GetPhongTheoID(int roomID) {
		RoomBean room = rDao.GetPhongID(roomID);
		
		return room;
	}
}
