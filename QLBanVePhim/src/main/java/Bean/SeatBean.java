package Bean;

public class SeatBean {
	public int getSeatID() {
		return SeatID;
	}

	public void setSeatID(int seatID) {
		SeatID = seatID;
	}

	public String getRow() {
		return Row;
	}

	public void setRow(String row) {
		Row = row;
	}

	public int getTicketID() {
		return TicketID;
	}

	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}

	public boolean isCoupleSeat() {
		return CoupleSeat;
	}

	public void setCoupleSeat(boolean coupleSeat) {
		CoupleSeat = coupleSeat;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public boolean isSold() {
		return Sold;
	}

	public void setSold(boolean sold) {
		Sold = sold;
	}

	int SeatID;
	String Row;
	int TicketID;
	boolean CoupleSeat;
	String Name;
	boolean Sold;
	
	public SeatBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeatBean(int seatID, String row, int ticketID, boolean coupleSeat, String name, boolean sold) {
		super();
		SeatID = seatID;
		Row = row;
		TicketID = ticketID;
		CoupleSeat = coupleSeat;
		Name = name;
		Sold = sold;
	}
	
	
}
