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
	<link rel="stylesheet prefetch" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css"><script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
    <link rel="stylesheet" href="index.css">

    <title>Thêm phim mới</title>
</head>
<body>

    <div class="content-page container">
        <h3 >Thêm phim mới</h3>
        <form enctype="multipart/form-data" action="AdminThemPhim" method="post" class="phim-container" style="margin-bottom: 50px;">
            <div class="form-group">
              <label for="exampleFormControlInput1"><b>Tên phim</b></label>
              <input name="movieName" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Thêm tên phim">
            </div>
            
            

            <div class="form-group">
                <label for="exampleFormControlFile1"><b>Thêm ảnh bìa</b></label>
                <input name="file" type="file" class="form-control-file" id="exampleFormControlFile1">
            </div>

            <div class="form-group">
              <label for="exampleFormControlSelect1"><b>Công chiếu</b></label>
              <select name="isRelease" class="form-control" id="exampleFormControlSelect1">
                <option value="0">Sắp chiếu</option>
                <option value="1">Đang chiếu</option>
              </select>
            </div>
            

            <div class="form-group">
              <label for="exampleFormControlTextarea1"><b>Tóm tắt</b></label>
              <textarea name="summary" class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput2"><b>Tên các diễn viên</b></label>
                <input name="starring" type="text" class="form-control" id="exampleFormControlInput2" placeholder="Thêm tên diễn viên">
              </div>

              <div class="form-group">
                <label for="exampleFormControlInput3"><b>Tên các đạo diễn</b></label>
                <input name="director" type="text" class="form-control" id="exampleFormControlInput3" placeholder="Thêm tên đạo diễn">
              </div>

              <div class="form-group">
                <label for="exampleFormControlInput3"><b>Tên các thể loại</b></label>
                <input name="genre" type="text" class="form-control" id="exampleFormControlInput3" placeholder="Thêm tên thể loại">
              </div>

            <input style="float: right;" type="submit" value="Them" class="btn btn-info">
          </form>
    </div>
    
    <script type="text/javascript">
		$(function () {  
		$("#datepicker").datepicker({         
		autoclose: true,         
		todayHighlight: true 
		}).datepicker('update', new Date());
		});
</script>
</body>