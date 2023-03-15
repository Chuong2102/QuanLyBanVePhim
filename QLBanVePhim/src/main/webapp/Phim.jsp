<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Bean.MovieBean"%>
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

    <title>Phim</title>
</head>
<body>
    <jsp:include page="nav.jsp" />
    
    <%
    	MovieBean movie = (MovieBean)request.getAttribute("movie");
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    %>

    <div class="phim-container container">
        <div class="row">
            <!--Phim-->
            <div class="col-12 phim-item">
                <div class="phim-info-container">
                    <div class="phim-pic">
                        <img src="<%=movie.getPoster() %>" alt="Stranger World">
                    </div>
        
                    <div class="phim-txt">
                        <h3 style="color:grey;"><%=movie.getName() %></h3>
                        <p>Khởi chiếu: <b>Từ <%=formatter.format(movie.getReleaseDate())  %></b></p>
                        <p>Thể loại: <b><%=movie.getGenre() %></b></p>
                        <p>Đạo diễn: <b><%=movie.getDirector() %></b></p>
                        <p>
                          <%=movie.getSummary() %>
                        </p>
                        <a href="Ticket" class="btn btn-info">Mua vé</a>
                    </div>
                </div>
                
                
    
            </div>
        </div>
    </div>



</body>
</html>