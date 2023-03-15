package Bean;

public class RoomBean {
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public int getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}
	
	int RoomID;
	int RoomNumber;
	
	public RoomBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomBean(int roomID, int roomNumber) {
		super();
		RoomID = roomID;
		RoomNumber = roomNumber;
	}
	
	
}
