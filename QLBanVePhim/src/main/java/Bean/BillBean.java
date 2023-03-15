package Bean;

public class BillBean {
	public int getBillID() {
		return BillID;
	}
	public void setBillID(int billID) {
		BillID = billID;
	}
	public int getTicketID() {
		return TicketID;
	}
	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}
	public int getSeatID() {
		return SeatID;
	}
	public void setSeatID(int seatID) {
		SeatID = seatID;
	}
	int BillID;
	int TicketID;
	int SeatID;
	public BillBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillBean(int billID, int ticketID, int seatID) {
		super();
		BillID = billID;
		TicketID = ticketID;
		SeatID = seatID;
	}
	
	
}
