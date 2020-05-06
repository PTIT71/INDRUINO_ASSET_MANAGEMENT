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
a.viewitem {
	cursor: pointer;
}
</style>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin: 10px">
		<form action="InventoryManagement" method="POST">
			<table class="table table-bordered table-search">
				<thead>
					<tr>
						<td class="title">Đơn Vị</td>
						<td><input value="${formSearch.getDepartment()}"
							class="selectList" list="select_department"
							name="select_department"> <datalist
								class="selectList-item" id="select_department">
								<c:forEach var="ps" items="${listAssets}">
									<option value="${ps.getDepartment()}">
								</c:forEach>
							</datalist></td>


						<td class="title">Tên Tài Sản</td>
						<td><input class="selectList" value="${formSearch.getName()}"
							list="text_asset_name" name="text_asset_name"> <datalist
								class="selectList-item" id="text_asset_name">
								<c:forEach var="ps" items="${listAssets}">
									<option value="${ps.getName()}">
								</c:forEach>
							</datalist></td>
						<td class="title">Model</td>
						<td><input value="${formSearch.getModel()}"
							class="selectList" list="text_model" name="text_model"> <datalist
								class="selectList-item" id="text_model">
								<c:forEach var="ps" items="${listAssets}">
									<option value="${ps.getModel()}">
								</c:forEach>
							</datalist></td>
						<td class="title">Số Series</td>
						<td><input value="${formSearch.getSeries()}"
							class="selectList" list="text_series" name="text_series">
							<datalist id="text_series" class="selectList-item">
								<c:forEach var="ps" items="${listAssets}">
									<option value="${ps.getSeries()}">
								</c:forEach>
							</datalist></td>
					</tr>
					<tr>
						<td class="title">Mã RFID</td>
						<td><input class="selectList" value="${formSearch.getRFID()}"
							list="text_rfid" name="text_rfid"> <datalist
								class="selectList-item" id="text_rfid">
								<c:forEach var="ps" items="${listAssets}">
									<option value="${ps.RFID}">
								</c:forEach>
							</datalist></td>
						<td class="title">Mã Kế Toán</td>
						<td><input value="${formSearch.getAccountant_CD()}"
							list="text_accountant" class="selectList" name="text_accountant">
							<datalist id="text_accountant" class="selectList-item">
								<c:forEach var="ps" items="${listAssets}">
									<option value="${ps.getAccountant_CD()}">
								</c:forEach>
							</datalist></td>
						<td class="title">Trạng thái</td>
						<td colspan="3"> <div class="form-check-inline">
      <label class="form-check-label" for="radio1">
        <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Tất cả
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label" for="radio2">
        <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Thành công
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" id="radio2" name="optradio" >Báo mới
      </label>
    </div>
     <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" id="radio2" name="optradio" >Không thành công
      </label>
    </div>
    </td>
					</tr>
					<tr>
						<td class="title">Đơn Giá</td>
						<td colspan="3"><input value="${formSearch.getPriceStart()}"
							style="width: 45%" type="text" name="text_start_price"> ~
							<input value="${formSearch.getPriceEnd()}" style="width: 45%"
							type="text" name="text_end_price"></td>
					</tr>
				</thead>
			</table>
			<div class="title-feature">
				<div class="text-right">
					<button type="submit" style="border-radius: 0"
						class="btn btn-primary">
						<i style="font-size: 24px" class="fa">&#xf067;</i>TÌM KIẾM
					</button>
					<button type="button" style="border-radius: 0"
						class="btn btn-primary" onclick="ToLink('CreateAssetGeneral')">
						<i style="font-size: 24px" class="fa">&#xf067;</i>THÊM MỚI
					</button>
					<button type="button" style="border-radius: 0"
						onclick="ToLink('ImportCSVAssetGenneral')" class="btn btn-primary">
						<i style="font-size: 24px" class="fa">&#xf1c3;</i>NHẬP EXCEL
					</button>
					<button type="submit" style="border-radius: 0" name="reportExcel"
						class="btn btn-primary">
						<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT EXCEL
					</button>
					<button type="submit" style="border-radius: 0" name="reportPDF"
						class="btn btn-primary">
						<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT PDF
					</button>
					<button type="button" style="border-radius: 0" data-toggle="modal"
						data-target="#myModal" onclick="GetSelected()"
						class="btn btn-primary">
						<i style="font-size: 24px" class="fa">&#xf1c3;</i>QUAY LẠI
					</button>
				</div>
			</div>
		</form>
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
	<c:if test="${lstChecking.size() > 0}">
		<div style="margin-left: 10px; margin-right: 10px">
			<table id="table.data" class="table table-bordered table-data"
				style="margin-top: 10px">
				<thead>
					<tr>
						<th style="width: 2%"></th>
						<th style="width: 10%">MÃ QUẢN LÝ</th>
						<th style="width: 20%;">TÊN TÀI SẢN</th>
						<th style="width: 10%">KHU VỰC</th>
						<th style="width: 8%;">NGÀY KIỂM KÊ</th>
						<th style="width: 10%">NGƯỜI KIỂM KÊ</th>
						<th style="width: 10%;">TRẠNG THÁI</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="checking" items="${lstChecking}">
						<tr>
							<td><input name="checkboxrow" onclick="return GetSelected()"
								onchange="GetSelected()" type="checkbox"
								class="form-check-input"
								style="margin: 0px; padding: 0px; margin-top: 7px" value=""></td>
							<td style="text-align: left;">${checking.getInventorySessionCD()}</td>
							<td style="text-align: left;">${checking.getAsset_Name()}</td>
							<td style="text-align: left;">${checking.getDepartment()}</td>
							<td style="text-align: left;">${checking.getInventory_Date()}</td>
							<td style="text-align: right;">${checking.getUserName()}(${checking.getUserChecking()})</td>
							<c:if test="${checking.getStatus().trim() == '1'}">
								<td style="text-align: right; color: green; font-weight: 700">${checking.getStatus_name()}</td>
							</c:if>
							<c:if test="${checking.getStatus().trim() == '2'}">
								<td style="text-align: right; color: blue; font-weight: 700">${checking.getStatus_name()}</td>
							</c:if>
							<c:if test="${checking.getStatus().trim() == '3'}">
								<td style="text-align: right; color: red; font-weight: 700">${checking.getStatus_name()}</td>
							</c:if>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</c:if>
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