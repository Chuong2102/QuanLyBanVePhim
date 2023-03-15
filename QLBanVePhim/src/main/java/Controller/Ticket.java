package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.NgayChieuBean;
import Bean.SuatChieuBean;
import Bo.NgayChieuBo;
import Bo.SuatChieuBo;

/**
 * Servlet implementation class Ticket
 */
@WebServlet("/Ticket")
public class Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Lay danh sach suat chieu
		SuatChieuBo sBo = new SuatChieuBo();
		ArrayList<SuatChieuBean> listSuatChieu = sBo.GetDanhSachSuatChieu();
		
		// Lay danh sach ngay chieu
		NgayChieuBo nBo = new NgayChieuBo();
		ArrayList<NgayChieuBean> listNgayChieu = nBo.GetDanhSachNgayChieu();
		
		// Truyen tham so
		request.setAttribute("listSuatChieu", listSuatChieu);
		request.setAttribute("listNgayChieu", listNgayChieu);
		
		// Chuyen trang
		RequestDispatcher rd = request.getRequestDispatcher("ticket.jsp");
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
