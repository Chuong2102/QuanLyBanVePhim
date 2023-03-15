package Bean;

import java.util.Date;

public class NgayChieuBean {
	public int getShowTimeID() {
		return ShowTimeID;
	}
	public void setShowTimeID(int showTimeID) {
		ShowTimeID = showTimeID;
	}
	public Date getWatchDate() {
		return WatchDate;
	}
	public void setWatchDate(Date watchDate) {
		WatchDate = watchDate;
	}
	int ShowTimeID;
	Date WatchDate;
	
	public NgayChieuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgayChieuBean(int showTimeID, Date watchDate) {
		super();
		ShowTimeID = showTimeID;
		WatchDate = watchDate;
	}
	
	
}
