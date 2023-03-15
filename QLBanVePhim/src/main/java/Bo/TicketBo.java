package Bo;

import java.util.ArrayList;

import Bean.TicketBean;
import Dao.TicketDao;

public class TicketBo {
	ArrayList<TicketBean> listTicket;
	ArrayList<TicketBean> listTicketSuat;
	
	TicketDao tDao = new TicketDao();
	
	public ArrayList<TicketBean> GetDanhSachVe(){
		listTicket = tDao.GetDanhSachVe();
		
		return listTicket;
	}
	
	public ArrayList<TicketBean> GetVeTheoSuat(int movieID, int showTimeID){
		listTicketSuat = tDao.GetVeTheoSuat(movieID, showTimeID);
		
		return listTicketSuat;
	}
	
	public TicketBean getTicketByID(int ticketID) {
		TicketBean ticket = tDao.getTicketByID(ticketID);
		
		return ticket;
	}
}
