<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h2 style="text-align: center; margin-top: 30px">USER LOGIN</h2>
		<form action="login-user" method="post" style="width: 400px; margin: auto">
			<div class="form-group">
				<label for="id" style="font-weight: 700; font-size: 16px">ID:</label>
				<input type="text" class="form-control" id="usn"
					placeholder="Enter email" name="usn">
			</div>
			<div class="form-group">
				<label for="pwd" style="font-weight: 700; font-size: 16px">Password: </label> <input type="password" class="form-control" id="pwd"
					placeholder="Enter password" name="pswd">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember for login?
				</label>
			</div>
			<button type="submit" class="btn "
				style="color: white; background-color: #0090DD">Login</button>
		</form>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>