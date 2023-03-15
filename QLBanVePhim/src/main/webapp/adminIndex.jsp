<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Bean.MovieBean"%>
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
    
    <title>CineStar - Hệ thống Rạp chiếu phim bậc nhất</title>
    
      
</head>
<body>
    <jsp:include page="nav.jsp" />
    
	<%
		// Lay danh sach phim
		ArrayList<MovieBean> listMovies = (ArrayList<MovieBean>)request.getAttribute("listMovies");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	%>
    <!-- Page body-->
    <div class="content-page container">
      <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Phim đang chiếu</a>
          <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Phim sắp chiếu</a>
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
      
      	<a href="adminThemPhim.jsp">
                <button style="margin-top:10px;" class="btn btn-dark">Thêm phim</button>
       	</a>
            
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
          <div class="tab-movie">
            <div class="movie-col row">
              <!--Phim-->
              <%for(MovieBean movie : listMovies)
              	if(movie.isRelease()){ 
              %>
              <div class="col-6">
                <div class="film-item">
                	<a href="Movie?movieID=<%= movie.getMovieID() %>">
    
	                  <div class="film-pic">
	                    <img src="<%=movie.getPoster() %>" alt="<%=movie.getName()%>">
	                  </div>
	    
	                  <div class="film-txt">
	                    <h3><%=movie.getName() %></h3>
	                    <p>
	                      <%=movie.getSummary() %>
	                    </p>
	                    <p>Khởi chiếu: Từ <%=formatter.format(movie.getReleaseDate())  %></p>
	                  </div>
	    
	                  
	                </a>
	                
	                <div class="film-btn">
                    	<a href="AdminXoaPhim?movieID=<%= movie.getMovieID() %>" class="btn btn-danger">Xóa</a>
                  	</div>
	                 
	                  
                </div>
    
              </div>
    			<%} %>
              
            </div>
    
          </div>
        </div>
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
        	<div class="tab-movie">
            <div class="movie-col row">
              <!--Phim-->
              <%for(MovieBean movie : listMovies)
              	if(!movie.isRelease()){ 
              %>
              <div class="col-6">
                <div class="film-item">
                	<a href="Movie/movieID=<%= movie.getMovieID() %>">
    
	                  <div class="film-pic">
	                    <img src="<%=movie.getPoster() %>" alt="<%=movie.getName()%>">
	                  </div>
	    
	                  <div class="film-txt">
	                    <h3><%=movie.getName() %></h3>
	                    <p>
	                      <%=movie.getSummary() %>
	                    </p>
	                    <p>Khởi chiếu: Từ <%=formatter.format(movie.getReleaseDate()) %></p>
	                  </div>
	    
	                  
	                </a>
	                
	                <div class="film-btn">
                    	<a href="AdminXoaPhim?movieID=<%= movie.getMovieID() %>" class="btn btn-danger">Xóa</a>
                  	</div>
                </div>
    
              </div>
    			<%} %>
              
            </div>
    
          </div>
        </div>
        
      </div>

      

    </div>
</body>
</html>