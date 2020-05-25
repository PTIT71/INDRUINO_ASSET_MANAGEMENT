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
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<form action="InsertInventorySession" method="POST">
	<div style="margin: 10px">
		<div class="title-feature">
			<div class="text-right">
				<button type="submit" style="border-radius: 0"
					onclick="window.location.href='company-insert-init'"
					class="btn btn-primary">
					<i style="font-size: 24px" class="fa">&#xf067;</i>LƯU PHIÊN
				</button>
				<button type="submit" style="border-radius: 0"
					class="btn btn-primary" name="back">
					<i style="font-size: 24px" class="fa">&#xf067;</i>QUAY TRỞ LẠI
				</button>
			</div>
		</div>
	</div>
	<div style="margin-left: 10px; margin-right: 10px">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="text">TÊN KIỂM KÊ:</label> <input type="text"
							class="form-control" name="name">
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="text">NGÀY BẮT ĐẦU: </label> <input type="date"
							class="form-control" name="startdate">
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="text">NGÀY KẾT THÚC:</label> <input type="date"
							value="" class="form-control" name="enddate">
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="text">MÃ QUẢN LÝ:</label> <input type="text" value=""
							class="form-control" name="code">
					</div>
				</div>
				<p style="width:100%; text-align: center; color: red; font-weight: 700;">${message}</p>
				<div class="col-sm-12">
					<div class="form-group">
						<label for="text">PHÂN QUYỀN:</label>
						<hr style="margin-top: 0px;">
						<div class="row" style="width: 60%; margin: auto;">
							<div class="col-sm-5">
								<div class="form-group">
									<label for="text">MÃ NHÂN VIÊN: </label> <input type="text"
										value="" class="form-control" id="employee_code"
										name="employee_code">
								</div>
							</div>
							<div class="col-sm-5">
								<div class="form-group">
									<label for="text">TÊN NHÂN VIÊN: </label> <input type="text"
										value="" class="form-control" id="employee_name"
										name="employee_name">
								</div>
							</div>
							<div class="col-sm-2">
								<div class="form-group">
									<label for="text"></label> <br> <input type="button"
										style="margin-top: 8px;" id="btnSearchPermission"
										onclick="return hello()" class="btn" value="TÌM KIẾM">
								</div>
							</div>
						</div>
						<p class="message_error" id="error"></p>
						<div class="row">
							<table id="table.data" class="table table-bordered table-data"
								style="margin-top: 10px">
								<thead>
									<tr>
										<th style="width: 30%">MÃ NHÂN VIÊN</th>
										<th style="width: 30%;">TÊN NHÂN VIÊN</th>
										<th style="width: 35%;">BỘ PHẬN</th>
										<th style="width: 5%;">XÓA</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#btnSearchPermission')
								.click(
										function() {
											var employee_code = document
													.getElementById('employee_code').value;
											var employee_name = document
													.getElementById('employee_name').value;
											var urlDerection = 'http://'
													+ window.location.hostname
													+ ':8080/AssetMangement/GetUserPermission';
											var pagrameter = '?employee_code='
													+ employee_code
													+ '&employee_name='
													+ employee_name;
											$
													.ajax({
														type : 'GET',
														url : urlDerection
																+ pagrameter,
														contentType : "application/x-www-form-urlencoded;charset=utf-8",
														success : function(
																result) {
															var res = result
																	.split("_");
															if (res[0] == 'message') {
																document
																		.getElementById("error").innerHTML = res[1];
															} else {
																var table = document
																		.getElementById("table.data");
																var count = table.rows.length;
																var row = table
																		.insertRow(count);
																var cell1 = row
																		.insertCell(0);
																var cell2 = row
																		.insertCell(1);
																var cell3 = row
																		.insertCell(2);
																var cell4 = row
																		.insertCell(3);
																var idCount = count-1;
																  var x = document.createElement("INPUT");
																  x.setAttribute("type", "text");
																  x.setAttribute("style", "border:0px;");
																  x.setAttribute("value", res[0]);
																  x.setAttribute("name", "item.emloyee[" + idCount + "]");
																cell1.appendChild(x);
																cell2.innerHTML = res[1];
																cell3.innerHTML ="";
																cell4.innerHTML = "";

																document
																		.getElementById("error").innerHTML = "";
															}

														}

													});
										});

					});
</script>
</html>