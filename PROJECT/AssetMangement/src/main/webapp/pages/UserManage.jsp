<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>General management</title>
<jsp:include page="//common/library.jsp"></jsp:include>
<style>
.title-feature button i {
	margin-right: 10px;
}

.title-feature button {
	height: 100%;
	margin-top: 0px;
}

.title-feature {
	background-color: #bdc6e2;
	padding-left: 10px;
	font-size: 22px;
	height: 40px;
}

.table-data {
	border: 2px solid black;
}

.table-data tbody tr {
	line-height: 22px;
}

.table-data thead th {
	padding: 1px 1px 1px 1px;
}

.table-data td {
	border-right: 2px solid black;
	border-bottom-style: dashed;
	height: 18px;
	padding: 1px 4px 1px 4px;
}

.table-data th {
	border: 1px solid black;
}

.table-data thead th {
	border: 2px solid black;
	text-align: center;
	background-color: #bdc6e2;
}

.table-search tr {
	height: 22px;
}

.table-search tr td input {
	width: 100%;
	height: 30px;
	border: 1px solid black;
}

.table-search tr td select {
	width: 100%;
	height: 30px;
}

.table-search tr td {
	padding: 2px 2px 2px 2px;
	border: 2px solid black;
}

.table-search tr .title {
	font-weight: 700;
	padding: 5px 4px 0px 4px;
	background-color: #0089FF;
	color: white;
}

.selectList {
	cursor: pointer;
}

.selectList-item option {
	cursor: pointer;
}
textarea:focus, input:focus{
    outline: none;
}
</style>
</head>
<body>
	<jsp:include page="//common/header.jsp"></jsp:include>
	<jsp:include page="//common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
				<form action="AssetGeneralSearchInit" method="POST">
					<table class="table table-bordered table-search">
						<thead>
							<tr>
								<td class="title">Mã RFID</td>
								<td><input class="selectList"
									value="${formSearch.getRFID()}" list="text_rfid"
									name="text_rfid"> <datalist class="selectList-item"
										id="text_rfid">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.RFID}">
										</c:forEach>
									</datalist></td>
								<td class="title">Tên Tài Sản</td>
								<td><input class="selectList"
									value="${formSearch.getName()}" list="text_asset_name"
									name="text_asset_name"> <datalist
										class="selectList-item" id="text_asset_name">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.getName()}">
										</c:forEach>
									</datalist></td>
								<td class="title">Model</td>
								<td><input value="${formSearch.getModel()}"
									class="selectList" list="text_model" name="text_model">
									<datalist class="selectList-item" id="text_model">
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
								<td class="title">Đơn Vị</td>
								<td><input value="${formSearch.getDepartment()}"
									class="selectList" list="select_department"
									name="select_department"> <datalist
										class="selectList-item" id="select_department">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.getDepartment()}">
										</c:forEach>
									</datalist></td>
								<td class="title">Mã Kế Toán</td>
								<td><input value="${formSearch.getAccountant_CD()}"
									list="text_accountant" class="selectList"
									name="text_accountant"> <datalist id="text_accountant"
										class="selectList-item">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.getAccountant_CD()}">
										</c:forEach>
									</datalist></td>
								<td class="title">Ngày Đầu Tư</td>
								<td colspan="3"><input value="${formSearch.getDateStart()}"
									style="width: 45%" type="date" data-date-format="DD/MM/YYYY"
									name="text_start_date"> ~ <input
									value="${formSearch.getDateEnd()}" style="width: 45%"
									type="date" name="text_end_date"></td>
							</tr>
							<tr>
								<td class="title">Đơn Giá</td>
								<td colspan="3"><input
									value="${formSearch.getPriceStart()}" style="width: 45%"
									type="text" name="text_start_price"> ~ <input
									value="${formSearch.getPriceEnd()}" style="width: 45%"
									type="text" name="text_end_price"></td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<div class="title-feature">
						<div class="text-right">
							<button type="submit" style="border-radius: 0"
								class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf067;</i>TÌM KIẾM
							</button>
							<button type="submit" style="border-radius: 0"
								class="btn btn-primary" data-toggle="modal"
								data-target="#myModal">
								<i style="font-size: 24px" class="fa">&#xf067;</i>THÊM MỚI
							</button>
							<button type="submit" style="border-radius: 0" onclick="alert();"
								class="btn btn-primary">
								<i style='font-size: 24px' class='far'>&#xf044;</i> CHỈNH SỬA
							</button>
							<button type="submit" style="border-radius: 0"
								class="btn btn-primary">
								<i style='font-size: 24px' class='fas'>&#xf2ed;</i>XÓA
							</button>							
							<button type="button" style="border-radius: 0"
								data-toggle="modal" data-target="#myModal"
								class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>NHẬP EXCEL
							</button>
							<button type="submit" style="border-radius: 0"
								onclick="GetSelected()" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT EXCEL
							</button>
						</div>
					</div>
				</form>
				<p style="width:100%; text-align: center; color: red; font-weight: 700; margin-top:10px">${message}</p>
				<table id="table.data" class="table table-bordered table-data"
					style="margin-top: 10px">
					<thead>
						<tr>
							<th style="width:2%"></th>
							<th style="width: 5%">STT</th>
							<th style="width: 13%;">MÃ NHÂN VIÊN</th>
							<th style="width: 15%;">HỌ TÊN</th>
							<th style="width: 14%;">PHÒNG BAN</th>
							<th style="width: 14%;">CHỨC VỤ</th>
							<th style="width: 8%;">QUYỀN</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
</body>
</html>