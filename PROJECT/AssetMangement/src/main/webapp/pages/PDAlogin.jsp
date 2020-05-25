<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<jsp:include page="/common/library.jsp"></jsp:include>


<body style="overflow: hidden;">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>

	<div class="container">
		<h2 style="text-align: center; margin-top: 30px">ĐĂNG NHẬP HỆ THỐNG</h2>
		<hr style="width:100px; height: 5px;">
		<form action="login-user" method="post" style="width: 400px; margin: auto; margin-top: 15px">
			<div class="form-group">
				<label for="id" style="font-weight: 700; font-size: 16px">Mã nhân viên:</label>
				<input type="text" class="form-control" id="usn"
					placeholder="Enter email" name="usn">
			</div>
			<div class="form-group">
				<label for="pwd" style="font-weight: 700; font-size: 16px">Mật khẩu: </label> <input type="password" class="form-control" id="pwd"
					placeholder="Enter password" name="pswd">
			</div>
			<p style="width:100%; text-align: center; color: red; font-weight: 700; ">${message}</p>
			<button type="submit" class="btn "
				style="color: white; background-color: #0090DD">Đăng nhập</button>
		</form>
	</div>
</body>
</html>