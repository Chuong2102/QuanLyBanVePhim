package Bean;

import java.util.Date;

public class SuatChieuBean {
	public int getMovieID() {
		return MovieID;
	}

	public void setMovieID(int movieID) {
		MovieID = movieID;
	}

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

	int MovieID;
	int ShowTimeID;
	Date WatchDate;
	
	public SuatChieuBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuatChieuBean(int movieID, int showTimeID, Date watchDate) {
		super();
		MovieID = movieID;
		ShowTimeID = showTimeID;
		WatchDate = watchDate;
	}
	
	
}
