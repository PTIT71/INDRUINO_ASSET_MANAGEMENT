<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>General management</title>
<jsp:include page="/common/library.jsp"></jsp:include>
<link rel="stylesheet" href="./resources/css/tabledata.css">
<style type="text/css">
.title_input {
	font-weight: 700;
}
</style>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<form action="UserRegister" method="POST">
	<div style="margin: 10px">
		<div class="title-feature">
			<div class="title-feature-sub">
				<button type="submit" class="btn btn-primary" name="save">
					<i class="fas fa-save"></i> LƯU TRẠNG THÁI
				</button>

			</div>
			<div class="text-right">
				<button type="submit" class="btn btn-primary text-right" name="back">
					<i class="fas fa-undo"></i> QUAY TRỞ LẠI
				</button>
			</div>

		</div>
	</div>
	<div style="margin-left: 10px; margin-right: 10px">
		<div>
			<c:if test="${message != null}">
				<div class="alert alert-danger message">
					<strong>${message}</strong>
				</div>
			</c:if>
		</div>
		<div>
			<c:if test="${NOTIFICATION != null}">
				<div class="alert alert-success message">
					<strong>${NOTIFICATION}</strong>
				</div>
			</c:if>
		</div>
	</div>
	<div style="margin-left: 10px; margin-right: 10px">

	
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label class="title_input">TÊN NGƯỜI DÙNG:</label> <input name="employee_name"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-sm-3" style="padding-left: 0px;">
					<div class="form-group">
						<label class="title_input">MÃ NHÂN VIÊN</label> <input type="text" name="employee_code"
							class="form-control">
					</div>
				</div>
				<div class="col-sm-3" style="padding-right: 0px;">
					<div class="form-group">
						<label class="title_input">SỐ ĐIỆN THOẠI</label> <input name="employee_phone"
							type="text" class="form-control">
					</div>
				</div>

				<div class="col-sm-3" style="padding-right: 0px;">
					<div class="form-group">
						<label class="title_input">MẬT KHẨU</label> <input type="password" name="employee_pass"
							class="form-control">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="manage-area">
						<label class="title_input" style="margin-top: 10px">BẢNG
							PHÂN QUYỀN</label>
						<table id="table.data" class="table table-bordered table-data">
							<thead>
								<tr>
									<th style="width: 20%">NGHIỆP VỤ</th>
									<th style="width: 15%;">THÊM</th>
									<th style="width: 15%;">SỬA</th>
									<th style="width: 15%;">XÓA</th>
									<th style="width: 15%;">IN</th>
									<th style="width: 15%;">XUẤT</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>sdfsdf</td>
									<td><input name="checkboxrow"
										onclick="return GetSelected()" onchange="GetSelected()"
										type="checkbox" class="form-check-input"
										style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
									<td><input name="checkboxrow"
										onclick="return GetSelected()" onchange="GetSelected()"
										type="checkbox" class="form-check-input"
										style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
									<td><input name="checkboxrow"
										onclick="return GetSelected()" onchange="GetSelected()"
										type="checkbox" class="form-check-input"
										style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
									<td><input name="checkboxrow"
										onclick="return GetSelected()" onchange="GetSelected()"
										type="checkbox" class="form-check-input"
										style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
									<td><input name="checkboxrow"
										onclick="return GetSelected()" onchange="GetSelected()"
										type="checkbox" class="form-check-input"
										style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	</div>
	</form>
</body>
<script type="text/javascript">
	//hàm chọn dữ liệu
	function GetSelected() {
		//Reference the Table.
		var grid = document.getElementById("table.data");

		//Reference the CheckBoxes in Table.
		var checkBoxes = document.getElementsByName("checkboxrow");

		//Loop through the CheckBoxes.
		for (var i = 0; i < checkBoxes.length; i++) {
			var color = "white";
			if (checkBoxes[i].checked) {
				color = "yellow";
			}

			var row = checkBoxes[i].parentNode.parentNode;
			for (var j = 0; j < row.cells.length; j++) {
				row.cells[j].style.backgroundColor = color;
			}
		}

	}
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>
</html>