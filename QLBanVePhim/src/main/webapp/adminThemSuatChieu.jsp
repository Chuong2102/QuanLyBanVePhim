<%@page import="Bo.TicketBo"%>
<%@page import="Bean.TicketBean"%>
<%@page import="Bean.MovieBean"%>
<%@page import="Bo.MovieBo"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Bean.NgayChieuBean"%>
<%@page import="Bean.SuatChieuBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="index.css">

    <title>Thêm suất chiếu</title>
</head>
<body>
    <jsp:include page="nav.jsp" />

	<%
		// Lay danh sach cac suat chieu
		ArrayList<SuatChieuBean> listSuatChieu = 
			(ArrayList<SuatChieuBean>)request.getAttribute("listSuatChieu");
		// Lay danh sach ngay chieu
		ArrayList<NgayChieuBean> listNgayChieu = 
			(ArrayList<NgayChieuBean>)request.getAttribute("listNgayChieu");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	%>
      <!-- Body -->
      <div class="container content-page">
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <!-- Duyet lay ds Ngay chieu -->
            <%
           		ZoneId defaultZoneId = ZoneId.systemDefault();
            	LocalDate localDate = java.time.LocalDate.now();
            	Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
            
            	for(NgayChieuBean ngay : listNgayChieu){
            		int compare = ngay.getWatchDate().compareTo(date);
            			if(compare >= 0){
            			
            %>
            <li class="nav-item">
              <a class="nav-link <% if(compare == 0){ %>active<%} %>" id="pills-<%=ngay.getShowTimeID() %>-tab" data-toggle="pill" href="#pills-<%=ngay.getShowTimeID() %>" role="tab" aria-controls="pills-<%=ngay.getShowTimeID() %>" aria-selected="true">
                <%=formatter.format(ngay.getWatchDate()) %> <br> Thứ ...
              </a>
            </li>
            
            <%}
            	}
            %>
            
            <liv class="nav-item" style="margin:auto">
            	<button class="btn btn-dark">
            		Thêm ngày chiếu
            	</button>
            </liv>
          </ul>
          <!-- danh sach phim -->
          
          
          <div class="tab-content" id="pills-tabContent">
          <%
          	// Duyet ds ngay`
            	for(NgayChieuBean ngay : listNgayChieu){
            		int compare = ngay.getWatchDate().compareTo(date);
            			if(compare >= 0){
          	
          %>
            <div class="tab-pane fade show active" id="pills-<%=ngay.getShowTimeID() %>" role="tabpanel" aria-labelledby="pills-<%=ngay.getShowTimeID() %>-tab">
                <!-- Phim -->
                <div class="tab-movie">
                    <div class="movie-col col-12">
                      <!--Phim-->
                      <%
                      	MovieBo mBo = new MovieBo();
                      	for(SuatChieuBean suat : listSuatChieu){
                      		if(suat.getShowTimeID() == ngay.getShowTimeID()){
                          		MovieBean movie = mBo.GetMovie(suat.getMovieID());
                      %>
                      
                      <div class="col-6 film-item">
                        <a href="#">
            
                          <div class="film-pic">
                            <img src="<%=movie.getPoster() %>.jpg" alt="<%=movie.getName()%>">
                          </div>
            
                          <div class="film-txt">
                            <h4><%=movie.getName() %></h4>
                          </div>
                          
                          <div class="list-bill">
                          	<!-- danh sach ticket -->
                          	<%
                          		ArrayList<TicketBean> listTicket;
                          		TicketBo tBo = new TicketBo();
                          		listTicket = tBo.GetVeTheoSuat(movie.getMovieID(), suat.getShowTimeID());
                          		
                          		for(TicketBean ticket : listTicket){
                          	%>
                            <a href="Pay?ticketID=<%= ticket.getTicketID() %>" class="ticket text-decoration-none">
                                <button class="btn btn-light  outline-dark">
                                    <span class="time"><%=ticket.getTime().getHours() %>h:<%=ticket.getTime().getMinutes() %>p</span>
                                    <span class="amenity price"><%=ticket.getPrice()/1000 %>K</span>
                                </button>
                            </a>
                            <%
                          		}
                            %>
                            
                            <!-- Them ticket -->
                            <a href="AdminAddTicket" class="ticket text-decoration-none">
                            	<button class="btn btn-dark  outline-dark">
                                    <span>Thêm ticket</span>
                                </button>
                            </a>
                            
                        </div>
                          
                        </a>
                        
                    
                      </div>
            
                      <%
                      	}
                      		}
                      %>
                      
                    </div>
                </div>
            </div>
            	<%}
            	}
            	%>
            
          </div>
      </div>

</body>
</html>