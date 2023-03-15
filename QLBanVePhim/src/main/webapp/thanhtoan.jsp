<%@page import="java.util.ArrayList"%>
<%@page import="Bean.SeatBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Bean.RoomBean"%>
<%@page import="Bean.NgayChieuBean"%>
<%@page import="Bean.MovieBean"%>
<%@page import="Bean.TicketBean"%>
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

    <link rel="stylesheet" type="text/css" href="index.css?version=51">

    <title>Thanh toán</title>
</head>
<body>
    <jsp:include page="nav.jsp" />
    
    <%
    	TicketBean ticket = (TicketBean)request.getAttribute("ticket");
    	MovieBean movie = (MovieBean)request.getAttribute("movie");
    	NgayChieuBean ngayChieu = (NgayChieuBean)request.getAttribute("ngayChieu");
    	RoomBean room = (RoomBean)request.getAttribute("room");
    	ArrayList<SeatBean> listGhe = (ArrayList<SeatBean>)request.getAttribute("ghe");
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    %>

      <div class="content-page container">
        <div class="row">
            <div class="col-8 list-ghe">
                <div class="man-hinh"> <h5> Màn hình </h5> </div>
                <!--Ghe-->
                <div class="ghe-container row col-12">
                    <!-- Danh sach hang ghe (theo bang chu cai) -->
                    <ul class="list-group">
                        <li class="hang-ghe list-group-item">A</li>
                        <li class="hang-ghe list-group-item">B</li>
                        <li class="hang-ghe list-group-item">C</li>
                    </ul>
                    <!--Danh sach ghe-->
                    <ul class="ghe list-group list-group-horizontal">
                    	<%
                    		for(SeatBean ghe : listGhe){
                    			if(ghe.getRow().contains("A")){
                    	%>
                        	<a href="XuatHoaDon?seatID=<%= ghe.getSeatID() %>&ticketID=<%=ticket.getTicketID()%>">
                        		<li class="list-group-item g"><%=ghe.getName() %></li>
                        	</a>
                        
                        <%} 
                        	}
                        %>
                    </ul>
                </div>
            </div>
            <div class="col-4">
              <div class="bill-container">

                <div class="info">
                  <div class="name">  
                    <h4><%=movie.getName() %></h4>
                  </div>
                  <div>
                    <p>Suất <b><%=ticket.getTime().getHours() %>h:<%=ticket.getTime().getMinutes() %>
                    </b> - Ngày <b><%=formatter.format(ngayChieu.getWatchDate()) %></b> </p>
                  </div>
                  <div>
                    Phòng chiếu: <b> <%=room.getRoomNumber() %></b>
                  </div>
                </div>

                <div class="bill">
                  <div>
                    Tổng đơn hàng: <b id="tongDon"><%=ticket.getPrice() %> vnđ</b>
                  </div>
                </div>
                

              </div>
            </div>
        </div>
      </div>

</body>
</html>