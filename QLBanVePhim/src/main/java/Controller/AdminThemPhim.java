package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Bo.MovieBo;



/**
 * Servlet implementation class AdminThemPhim
 */
@WebServlet("/AdminThemPhim")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

public class AdminThemPhim extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String SAVE_DIRECTORY = "Picture";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminThemPhim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Receive file uploaded to the Servlet from the HTML5 form */
	    Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("C:\\Users\\chuon\\eclipse-workspace\\QLBanVePhim\\src\\main\\webapp\\Picture\\" + fileName);
	    }
	    
	    // Get tham so
	    String Name = request.getParameter("movieName");
	    boolean isRelease = Boolean.parseBoolean(request.getParameter("isRelease"));
	    String Summary = request.getParameter("summary");
	    String Starring = request.getParameter("starring");
	    String Director = request.getParameter("director");
	    String Genre = request.getParameter("genre");
		String Poster = fileName;
	    
	    
	    MovieBo mBo = new MovieBo();
	    mBo.SetMovie(Poster, Summary, Name, Starring, Genre, Director, isRelease);
	    
	    
	    response.sendRedirect("AdminHomeController");
		
	}
	
	private String extractFileName(javax.servlet.http.Part part) {
       // form-data; name="file"; filename="C:\file1.zip"
       // form-data; name="file"; filename="C:\Note\file2.zip"
			
	   System.out.println("Extra");
		
       String contentDisp = part.getHeader("content-disposition");
       String[] items = contentDisp.split(";");
	       for (String s : items) {
	           if (s.trim().startsWith("filename")) {
	               // C:\file1.zip
	               // C:\Note\file2.zip
	               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
	               clientFileName = clientFileName.replace("\\", "/");
	               int i = clientFileName.lastIndexOf('/');
	               // file1.zip
	               // file2.zip
	               return clientFileName.substring(i + 1);
	           }
	       }
	       return null;
	   }
}
