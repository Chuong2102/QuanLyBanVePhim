package Bo;

import java.util.ArrayList;

import Bean.BillBean;
import Dao.BillDao;

public class BillBo {
	BillDao bDao = new BillDao();
	 ArrayList<BillBean> list;
	public ArrayList<BillBean> GetBill(){
		list = bDao.GetBill();
		
		return list;
	}
}
