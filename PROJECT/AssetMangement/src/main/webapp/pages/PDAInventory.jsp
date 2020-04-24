<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kiểm kê</title>
<jsp:include page="/common/library.jsp"></jsp:include>
<style type="text/css">
.titileScreen {
	width: 100%;
	line-height: 60px;
	font-size: 20px;
	color: white;
	text-align: center;
	font-weight: 600;
}

.headerPDA {
	height: 60px;
	background-color: #005BB5;
}

.headerPDA p {
	font-size: 3vw;
}

.logo {
	width: 70px;
	line-height: 40px;
	font-size: 20px;
	color: white;
	text-align: center;
	font-weight: 600;
	position: fixed;
	border: 2px solid white;
	height: 45px;
	margin-top: 7px;
	margin-left: 7px;
}

.logo p {
	width: 100%;
	text-align: center;
	font-weight: 600;
}

.title {
	display: inline-block;
	margin-bottom: 5px;
	margin-top: 5px;
	font-size: 16px;
	font-weight: 700;
}

.iset3d {
	border-radius: 0px;
	border: 1px solid #e0e0e0;
	border-top: 3px solid #696969;
	border-left: 3px solid #696969;
}

input[type="text"] {
	border-radius: 0px;
	border: 1px solid #e0e0e0;
	border-top: 3px solid #696969;
	border-left: 3px solid #696969;
}

option {
	font-size: 16px;
}

button[type="submit"] {
	border-radius: 0px;
	border: 1px solid #e0e0e0;
}

button[type="button"] {
	border-radius: 0px;
	border: 1px solid #e0e0e0;
}

.message {
	width: 90%;
	margin: auto;
	margin-top: 60px;
	border: 1px solid;
	border-radius: 0px;
}

.modal>.row {
	flex: 1;
}

.modal-header {
	height: 20px;
	background-color: #005BB5;
	border-radius: 0px;
	color: white;
	font-weight: 700;
}

.modal-dialog {
	width: 80%;
	margin: auto;
}
</style>
</head>
<body>
	<div class="row">
		<div style="width: 100%">
			<div class="row logo" style="float: left">
				<p>AMS</p>
			</div>
			<div class="row headerPDA">
				<p class="titileScreen">MÀN HÌNH NHẬP MÃ KIỂM KÊ</p>
			</div>

		</div>
	</div>
	<form action="PDACheckInventory" style="width: 90%; margin: auto"
		method="POST">
		<div class="form-group">
			<label class="title" for="usr">NHẬP MÃ QUẢN LÝ KIỂM KÊ:</label> <select onchange="selectIDSession()"
				class="form-control iset3d" name="" id="select_session_id">
			<c:forEach var="p" items="${lstInventory}">
				<option>${p.getInventory_session_id()}</option>
			</c:forEach>
			</select>
		</div>
		<button type="button" class="btn btn-primary " data-toggle="modal"
			data-target="#exampleModalCenter" style="float: right; width: 120px;">KIỂM
			TRA</button>
	</form>
	<div>
		<c:if test="${message != null}">
			<div class="alert alert-danger message">
				<strong>${message}</strong>
			</div>
		</c:if>
	</div>

	<c:if test="${Asset != null}">
		<table class="table table-bordered"
			style="width: 90%; margin: auto; margin-top: 12px;">
			<tbody>
				<tr>
					<td style="width: 35%; font-weight: 700">Tên tài sản</td>
					<td style="color: red; font-weight: 700">${Asset.getName()}</td>
				</tr>
				<tr>
					<td style="font-weight: 700">Series</td>
					<td>${Asset.getSeries()}</td>
				</tr>
				<tr>
					<td style="font-weight: 700">Model</td>
					<td>${Asset.getModel()}</td>
				</tr>
				<tr>
					<td style="font-weight: 700">Đơn vị</td>
					<td>${Asset.getDepartment()}</td>
				</tr>
				<tr>
					<td style="font-weight: 700">Ngày đầu tư</td>
					<td>${Asset.getDateStart()}</td>
				</tr>
				<tr>
					<td style="font-weight: 700">Trạng thái</td>
					<td style="color: green; font-weight: 700">Kiểm kê thành công</td>
				</tr>

			</tbody>
		</table>
	</c:if>




	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content iset3d"
				style="border-radius: 0px; border: 1px solid gray">

				<!-- Modal Header -->
				<div class="modal-header"
					style="height: 40px; background-color: #005BB5;">
					<p class="modal-title" style="height: 30px; margin-top: -9px;">Đăng
						nhập</p>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="checkout">
						<div class="form-group" style="margin-bottom: 0px;">
							<label for="email" style="font-weight: 700;">Mã nhân
								viên:</label> <input type="text" class="form-control iset3d" name="username"
								placeholder="Enter email" id="email">
						</div>
						<input type="text" style="display: none;" id="id_session" name="id_session"  value="${lstInventory.get(0).getInventory_session_id()}" />
						<div class="form-group" style="margin-bottom: 0px;">
							<label for="pwd" style="font-weight: 700;">Mật khẩu:</label> <input
								type="password" class="form-control iset3d" name="password"
								placeholder="Enter password" id="pwd">
						</div>
						<button type="submit" style="margin-top: 10px;" onclick="ToLink('authentication")"
							class="btn btn-danger" >XÁC THỰC</button>
					</form>
				</div>



			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
function selectIDSession()
{
	var id_session = document.getElementById("select_session_id").value;
	document.getElementById("id_session").value=id_session;
}
</script>
</html>