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
	<div style="margin: 10px">
		<div class="title-feature">
			<div class="title-feature-sub">
				<button type="submit" onclick="ToLink('company-insert-init')"
					class="btn btn-primary">
					<i style="font-size: 24px" class="fa">&#xf067;</i>THÊM MỚI
				</button>
				<button type="submit" class="btn btn-primary">
					<i style='font-size: 24px' class='far'>&#xf044;</i> XEM THÔNG TIN
				</button>
				<button type="submit" class="btn btn-primary">
					<i style='font-size: 24px' class='fas'>&#xf2ed;</i>XÓA
				</button>
			</div>
			<div class="text-right">
				<button type="submit" class="btn btn-primary text-right">
					<i class="fas fa-undo"></i> QUAY TRỞ LẠI
				</button>
			</div>
		</div>
	</div>
	<div style="margin-left: 10px; margin-right: 10px">
		<c:if test="${lstCompany.size() > 0}">
			<table id="table.data" class="table table-bordered table-data"
				style="margin-top: 10px">
				<thead>
					<tr>
						<th style="width: 2%"></th>
						<th style="width: 20%">TÊN CÔNG TY</th>
						<th style="width: 78%;">ĐỊA CHỈ</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="company" items="${lstCompany}">
						<tr>
							<td><input name="checkboxrow" onclick="return GetSelected()"
								onchange="GetSelected()" type="checkbox"
								class="form-check-input"
								style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
							<td style="text-align: center;"><a href="company/${company.getCompany_cd()}">${company.getCompany_name()}</a></td>
							<td>${company.getCompany_address()}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>
	</div>
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
</script>
</html>