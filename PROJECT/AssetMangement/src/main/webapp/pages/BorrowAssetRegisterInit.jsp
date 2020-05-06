<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
textarea:focus, input:focus{
    outline: none;
}
</style>
<body onload="Pagination()">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
				<form action="AssetGeneralSearchInit" method="POST">
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
								<td class="title">Mã RFID</td>
								<td><input class="selectList"
									value="${formSearch.getRFID()}" list="text_rfid"
									name="text_rfid"> <datalist class="selectList-item"
										id="text_rfid">
										<c:forEach var="ps" items="${listAssets}">
											<option value="${ps.RFID}">
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
							<button type="button" style="border-radius: 0"
								class="btn btn-primary" onclick="ToLink('CreateAssetGeneral')">
								<i style="font-size: 24px" class="fa">&#xf067;</i>THÊM MỚI
							</button>
							<button type="button" style="border-radius: 0"
								onclick="ToLink('ImportCSVAssetGenneral')"
								class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>NHẬP EXCEL
							</button>
							<button type="submit" style="border-radius: 0" 
								name="reportExcel" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT EXCEL
							</button>
							<button type="submit" style="border-radius: 0" 
								name="reportPDF" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT PDF
							</button>
							<button type="button" style="border-radius: 0" data-toggle="modal" data-target="#myModal"
								onclick="GetSelected()" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>QUAY LẠI
							</button>
						</div>
					</div>
				</form>
				<p style="width:100%; text-align: center; color: red; font-weight: 700; margin-top:10px">${message}</p>
				<c:if test="${listAssetSearch.size() > 0}">
				<p style="width:100%; text-align: right;  font-weight: 700; margin:0px" >Đơn vị: VNĐ</p>
				<table id="table.data" style="margin-top:0px" class="table table-bordered table-data"
					style="margin-top: 10px">
					<thead>
						<tr>
							<th style="width:2%"></th>
							<th style="width: 5%">STT</th>
							<th style="width: 8%;">RFID</th>
							<th style="width: 15%;">TÊN MÁY</th>
							<th style="width: 14%;">MODEL</th>
							<th style="width: 14%;">SỐ SERI</th>
							<th style="width: 13%;">ĐƠN VỊ</th>
							<th style="width: 10%;">MÃ KẾ TOÁN</th>
							<th style="width: 10%;">NGÀY ĐẦU TƯ</th>
							<th style="width: 9%;">ĐƠN GIÁ</th>
						</tr>
					</thead>
					<tbody>
						<%
							int stt = 1;
						%>
						<c:forEach var="p" items="${listAssetSearch}">
							<tr>
								<td><input name="checkboxrow"
									onclick="return GetSelected()" onchange="GetSelected()"
									type="checkbox" class="form-check-input"
									style="margin: 0px; padding: 0px; margin-top:7px" value=""></td>
								<td style="text-align: center;"><%=stt%></td>
								<td><a style="text-decoration: none; font-weight: 700" href="AssetGeneralView?rfid_code=${p.RFID}">${p.RFID}</a></td>
								<td>${p.getName()}</td>
								<td><input type="text" style="display:inline-block; width:inherit; border:0px;background-color:transparent; " readonly value="${p.getModel()}"></td>
								<td>${p.getSeries()}</td>
								<td>${p.getDepartment()}</td>
								<td style="width: 150px">${p.getAccountant_CD()}</td>
								<td style="text-align: right; width: 150px">${p.getDateStart()}</td>
								<td style="text-align: right;">${p.getPrice()}</td>
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


				</div>
			   </c:if>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function abc()
{
	bootbox.confirm({
        title: "Destroy planet?",
        message: "Do you want to activate the Deathstar now? This cannot be undone.",
        buttons: {
          cancel: {
            label: '<i class="fa fa-times"></i> Cancel'
          },
          confirm: {
            label: '<i class="fa fa-check"></i> Confirm'
          }
        },
        callback: function (result) {
          Example.show('This was logged in the callback: ' + result);
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
			x = document.getElementById("pagging.btn"+i);
			x.style.backgroundColor = "";
			x.style.color="black";
		}
		x = document.getElementById("pagging.btn"+indexCurrent);
		x.style.backgroundColor = "red";
		x.style.color="white";

	}
	//Hàm phân trang cho dữ liệu
	function Pagination() {
		var x = document.getElementById("pagging.btn1");
		x.style.backgroundColor = "red";
		x.style.color="white";
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