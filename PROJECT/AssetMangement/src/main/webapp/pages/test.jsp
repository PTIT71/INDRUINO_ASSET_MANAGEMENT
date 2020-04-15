<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>General management</title>
<jsp:include page="/common/library.jsp"></jsp:include>
</head>
<style>
.btn-feature {
	background-color: green;
	width: 80%;
	color: white;
	font-weight: 700;
	height: 55px;
	margin:auto;
	margin-top: 10px;
	line-height: 41px;
}
.btn-feature:hover
{
	 color: #0090DD;
}
</style>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<form action="savefile" method="post" enctype="multipart/form-data">  
Select File: <input type="file" name="file"/>  
<input type="submit" value="Upload File"/>  
</form>  
	<div class="container" style="margin-top: 10px">
		<div class="row">
			<div class="col-sm-4 text-center">
				<a href="#" class="btn btn-feature">QUẢN LÝ TÀI
					SẢN</a>
				<a href="#" class="btn btn-feature">KIỂM KÊ TÀI
					SẢN</a>
			</div>
			<div class="col-sm-4 text-center">
				<a href="#" class="btn btn-feature">ĐĂNG KÝ MƯỢN</a>
				<a href="#" class="btn btn-feature">ĐĂNG KÝ TRẢ</a>
				<a href="#" class="btn btn-feature">BÁO CÁO SỰ CỐ</a>
			</div>
			<div class="col-sm-4 text-center">
				<a href="#" class="btn btn-feature">THANH LÝ TÀI
					SẢN</a>
					<a href="setting" class="btn btn-feature" style="background-color: orange;">CÀI ĐẶT CHUNG</a>
			</div>
		</div>



	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>