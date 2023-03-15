package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MovieBean;
import Bean.NgayChieuBean;
import Bean.RoomBean;
import Bean.SeatBean;
import Bean.TicketBean;
import Bo.MovieBo;
import Bo.NgayChieuBo;
import Bo.RoomBo;
import Bo.SeatBo;
import Bo.TicketBo;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lay tham so
		String sTicketID = request.getParameter("ticketID");
		int ticketID = Integer.parseInt(sTicketID);
		
		// Lay ticket
		TicketBo tBo = new TicketBo();
		TicketBean ticket = tBo.getTicketByID(ticketID);
		
		// Lay movie
		MovieBo mBo = new MovieBo();
		MovieBean movie = mBo.GetMovie(ticket.getMovieID());
		
		// Layt ngay chieu
		NgayChieuBo nBo = new NgayChieuBo();
		NgayChieuBean ngayChieu = nBo.GetNgayChieuTheoID(ticket.getShowTimeID());
		
		//Lay phong chieu
		RoomBo rBo = new RoomBo();
		RoomBean room = rBo.GetPhongTheoID(ticket.getRoomID());
		
		// Lay ds ghe
		SeatBo seatBo = new SeatBo();
		ArrayList<SeatBean> ghe = seatBo.GetDanhGhe();
		
		// Truyen tham so
		request.setAttribute("ticket", ticket);
		request.setAttribute("movie", movie);
		request.setAttribute("ngayChieu", ngayChieu);
		request.setAttribute("room", room);
		request.setAttribute("ghe", ghe);
		
		// Chuyen trang
		RequestDispatcher rd = request.getRequestDispatcher("thanhtoan.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
