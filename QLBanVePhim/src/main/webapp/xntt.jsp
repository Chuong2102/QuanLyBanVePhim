<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Bean.SeatBean"%>
<%@page import="java.util.ArrayList"%>
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

    <link rel="stylesheet" href="index.css">

    <title>Xác nhận thanh toán</title>
</head>
<body>
    <!-- Nav bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">
          <img src="https://cinestar.com.vn/pictures/moi/9Logo/white-2018.png" alt="Logo" width="150px">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="phim.html">Phim</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="muave.html">Mua vé</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
            
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="search btn btn-outline-success my-2 my-sm-0" type="submit">
              <img src="https://cinestar.com.vn/catalog/view/theme/default/images/icon-search.png" alt="search-icon">
            </button>
          </form>
        </div>
      </nav>


    <div class="content-page container">
        <div class="thongbao col-12">
            <h4> Cảm ơn quý khách đã đến với <b>CineStar</b></h4>
            <h4>Xin vui lòng kiểm tra lại thông tin đặt vé</h4>
        </div>

		<%
			TicketBean ticket = (TicketBean)request.getAttribute("ticket");
	    	MovieBean movie = (MovieBean)request.getAttribute("movie");
	    	NgayChieuBean ngayChieu = (NgayChieuBean)request.getAttribute("ngayChieu");
	    	RoomBean room = (RoomBean)request.getAttribute("room");
	    	SeatBean ghe = (SeatBean)request.getAttribute("ghe");
	    	
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		%>
        <!--Phim-->
        <div class="phim-container container">
            <div class="row">
                <!--Phim-->
                <div class="col-12 phim-item">
                    <div class="phim-info-container">
                        <div class="phim-pic col-3">
                            <img src="<%=movie.getPoster() %>" alt="Stranger World">
                        </div>
            
                        <div class="phim-txt col-9">
                            <h3 style="color: lightslategray;"><%=movie.getName() %></h3>
                            <br>
                            <p>Ngày chiếu: <b><%=formatter.format(ngayChieu.getWatchDate()) %></b></p>
                            <p>Thể loại: <b><%=movie.getGenre() %></b></p>
                            <p>Đạo diễn: <b><%=movie.getDirector() %></b></p>
                            <p>Phòng chiếu: <b><%=room.getRoomNumber() %></b></p>
                        </div>
                    </div>
                </div>
                <!--Ghế-->
                <div class="bill-ghe col-12">
                    <table class="tbl-ghe table col-12">
                        <tbody>
                            <tr>
                                <td rowspan="0"><b>Ghế</b></td>
                                <td>
                                    <p style="float:left"><%=ghe.getName() %></p>
                                    <p style="float: right;"><b><%=ticket.getPrice() %> vnđ</b></p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="col-12">
                    <h3 style="float: left;"><b>Tổng tiền:</b> </h3>
                    <h4 style="float:right"><b><%=ticket.getPrice() %> VNĐ</b></h4>
                </div>
                <div class="col-12 text-center">
                    <a href="HomeController">
                    <button class="btn btn-info btn-thanhtoan"> Thanh toán</button>
                    </a>
                </div>
            </div>
        </div>

    </div>
    
</body>
</html>