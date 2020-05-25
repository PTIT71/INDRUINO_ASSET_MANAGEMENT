<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.asset.management.util.Common"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asset management</title>
<jsp:include page="/common/library.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
<script src="./resources/javascript/message/bootbox.all.js"></script>
<script src="./resources/javascript/message/bootbox.all.min.js"></script>
<script src="./resources/javascript/message/bootbox.js"></script>
<script src="./resources/javascript/message/bootbox.locales.js"></script>
<script src="./resources/javascript/message/bootbox.locales.min.js"></script>
<script src="./resources/javascript/message/bootbox.min.js"></script>
</head>

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

textarea:focus, input:focus {
	outline: none;
}
</style>
<body onload="Pagination()">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
				<form action="BorrowAssetManagement" method="POST">
					<table class="table table-bordered table-search">
						<thead>
							<tr>
								<td class="title">Đơn Vị Mượn</td>
								<td><input value="${formSearch.getDepartment()}"
									class="selectList" list="select_department"
									name="select_department"> <datalist
										class="selectList-item" id="select_department">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.getDepartment()}">
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
							<td class="title">Đơn Vị Chọn Mượn</td>
								<td><input value="${formSearch.getDepartment()}"
									class="selectList" list="select_department"
									name="select_department"> <datalist
										class="selectList-item" id="select_department">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.getDepartment()}">
										</c:forEach>
									</datalist></td>
								<td class="title">Mã RFID</td>
								<td><input class="selectList"
									value="${formSearch.getRFID()}" list="text_rfid"
									name="text_rfid"> <datalist class="selectList-item"
										id="text_rfid">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.RFID}">
										</c:forEach>
									</datalist></td>

								<td class="title">Ngày Đầu Tư</td>
								<td colspan="3"><input value="${formSearch.getDateStart()}"
									style="width: 45%" type="date" data-date-format="DD/MM/YYYY"
									name="text_start_date"> ~ <input
									value="${formSearch.getDateEnd()}" style="width: 45%"
									type="date" name="text_end_date"></td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<div class="title-feature">
						<div class="text-right">
							<button type="submit" style="border-radius: 0"
								class="btn btn-primary" name="search">
								<i style="font-size: 24px" class="fa">&#xf067;</i>TÌM KIẾM
							</button>
							<button type="submit" style="border-radius: 0"
								class="btn btn-primary" name="create">
								<i style="font-size: 24px" class="fa">&#xf067;</i>THÊM MỚI
							</button>
							<button type="submit" style="border-radius: 0" name="reportExcel"
								class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT EXCEL
							</button>
							<button type="submit" style="border-radius: 0" name="reportPDF"
								class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT PDF
							</button>
							<button type="submit" class="btn btn-primary" name="back">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>QUAY LẠI
							</button>
						</div>
					</div>
				</form>
				<p
					style="width: 100%; text-align: center; color: red; font-weight: 700; margin-top: 10px">${message}</p>
				<div class="alert alert-success message"
					style="margin-top: 20px !important">
					<strong>${NOTIFICATION}</strong>
				</div>
				<p
					style="width: 100%; text-align: right; font-weight: 700; margin: 0px">Đơn
					vị: VNĐ</p>
				<c:if test="${lst.size() > 0}">
					<table id="table.data" style="margin-top: 0px"
						onload="alrt(${lst.size()});"
						class="table table-bordered table-data" style="margin-top: 10px">
						<thead>
							<tr>
								<th colspan="1"></th>
								<th colspan="3">DOANH NGHIỆP CHO MƯỢN</th>
								<th colspan="4">THÔNG TIN TÀI SẢN</th>
								<th colspan="4">DOANH NGHIỆP MƯỢN</th>

							</tr>
							<tr>
								<th style="width: 25px;">STT</th>
								<th>DOANH NGHIỆP</th>
								<th>ĐƠN VỊ</th>
								<th>NGÀY CHO MƯỢN</th>
								<th>TÊN TÀI SẢN</th>
								<th>RFID</th>
								<th>SERI</th>
								<th>MODEL</th>
								<th>ĐƠN VỊ MƯỢN</th>
								<th>NGÀY TRẢ</th>
								<th>TRẠNG THÁI</th>
								<th>XEM</th>
							</tr>
						</thead>
						<tbody>
							<%
								int stt = 1;
							%>
							<c:forEach var="p" items="${lst}">
								<tr>
									<td style="text-align: center;"><%=stt%></td>
									<td>${p.getLoan_cmpn_name()}</a></td>
									<td>${p.getLoan_dept()}</td>
									<td>${p.getLoad_Date()}</td>
									<td>${p.getAsset_name()}</td>
									<td>${p.getAsset_rfid()}</td>
									<td>${p.getAsset_series()}</td>
									<td>${p.getAsset_model()}</td>
									<td>${p.getBorrow_dept()}</td>
									<td>${p.getPay_date()}</td>
									<td>${p.getStatus()}</td>
									<td><a href="BorrowAssetView?id=${p.getId()}"><i
											class="fas fa-eye"></i></a></td>
								</tr>
								<%
									stt++;
								%>
							</c:forEach>
						</tbody>
					</table>

					<div class="text-right">
						<%
							if (stt > 10) {
									double countPage = stt / 10;
									if (stt % 10 > 0) {
										countPage += 1;
									}
									int j = 1;
									while (j <= countPage) {
										int startIndex = j * 10 - 9;
										int endIndex = startIndex + 9;
						%>
						<a class="btn btn-default btn-paging" id='pagging.btn<%=j%>'
							onclick="movePage('<%=startIndex%>','<%=endIndex%>', '<%=j%>', '<%=countPage%>')"><%=j%></a>
						<%
							j++;
									}
								}
						%>
					
				</c:if>
			</div>

		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
	function abc() {
		bootbox
				.confirm({
					title : "Destroy planet?",
					message : "Do you want to activate the Deathstar now? This cannot be undone.",
					buttons : {
						cancel : {
							label : '<i class="fa fa-times"></i> Cancel'
						},
						confirm : {
							label : '<i class="fa fa-check"></i> Confirm'
						}
					},
					callback : function(result) {
						Example.show('This was logged in the callback: '
								+ result);
					}
				});
	}
	//Hàm click button chuyển trang
	function movePage(start, end, indexCurrent, countPage) {
		var x = document.getElementById("table.data").rows.length;
		for (var i = 1; i < x; i++) {
			var index = i + 1;
			if (i >= start && i <= end) {
				document.getElementById("table.data").rows[i].style.display = '';
			} else {
				document.getElementById("table.data").rows[i].style.display = 'none';
			}

		}
		for (var i = 1; i <= countPage; i++) {
			x = document.getElementById("pagging.btn" + i);
			x.style.backgroundColor = "";
			x.style.color = "black";
		}
		x = document.getElementById("pagging.btn" + indexCurrent);
		x.style.backgroundColor = "red";
		x.style.color = "white";

	}
	//Hàm phân trang cho dữ liệu
	function Pagination() {
		var x = document.getElementById("pagging.btn1");
		x.style.backgroundColor = "red";
		x.style.color = "white";
		x = document.getElementById("table.data").rows.length;
		if (x > 10) {
			for (var i = 10; i < x; i++) {
				document.getElementById("table.data").rows[i + 1].style.display = 'none';
			}

		}
	}

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
				color = "#bdc6e2";
			}

			var row = checkBoxes[i].parentNode.parentNode;
			for (var j = 0; j < row.cells.length; j++) {
				row.cells[j].style.backgroundColor = color;
			}
		}

	}
	$(document).ready(function() {
		Pagination();
		$('#example').DataTable({
			columnDefs : [ {
				orderable : false,
				className : 'select-checkbox',
				targets : 0
			} ],
			select : {
				style : 'os',
				selector : 'td:first-child'
			},
			order : [ [ 1, 'asc' ] ]
		});
	});

	$(function() {
		$('#datetimepicker1').datetimepicker();
	});
</script>
</html>