package Bean;

import java.sql.Date;
import java.sql.Time;

public class TicketBean {
	public int getTicketID() {
		return TicketID;
	}
	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}
	public int getMovieID() {
		return MovieID;
	}
	public void setMovieID(int movieID) {
		MovieID = movieID;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public Date getWatchDate() {
		return WatchDate;
	}
	public void setWatchDate(Date watchDate) {
		WatchDate = watchDate;
	}
	public Time getEndTime() {
		return EndTime;
	}
	public void setEndTime(Time endTime) {
		EndTime = endTime;
	}
	public int getShowTimeID() {
		return ShowTimeID;
	}
	public void setShowTimeID(int showTimeID) {
		ShowTimeID = showTimeID;
	}
	int TicketID;
	int MovieID;
	long Price;
	Time time;
	int RoomID;
	Date WatchDate;
	Time EndTime;
	int ShowTimeID;
	public TicketBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketBean(int ticketID, int movieID, long price, Time time, int roomID, Date watchDate, Time endTime,
			int showTimeID) {
		super();
		TicketID = ticketID;
		MovieID = movieID;
		Price = price;
		this.time = time;
		RoomID = roomID;
		WatchDate = watchDate;
		EndTime = endTime;
		ShowTimeID = showTimeID;
	}
	
	
}
