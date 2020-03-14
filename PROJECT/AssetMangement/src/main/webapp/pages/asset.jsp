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
	line-height: 9px;
}

.table-data thead th {
	padding: 4px 5px 4px 5px;
}

.table-data td {
	border-right: 2px solid black;
	border-bottom-style: dashed;
	height: 18px;
	padding: 8px 4px 8px 4px;
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
</style>

<body>


	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>

	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
			<form action="assetinit" method="GET">
				<table class="table table-bordered table-search">
					<thead>
						<tr>
							<td class="title">Mã RFID</td>
							<td><input type="text" name="text_rfid"></td>
							<td class="title">Tên Tài Sản</td>
							<td><input type="text" name="text_asset_name"></td>
							<td class="title">Model</td>
							<td><input type="text" name="text_model"></td>
							<td class="title">Số Series</td>
							<td><input type="text" name="text_series"></td>
						</tr>
						<tr>
							<td class="title">Đơn Vị</td>
							<td><select id="cars" name="select_department">
									<option value="volvo">Volvo</option>
									<option value="saab">Saab</option>
									<option value="mercedes">Mercedes</option>
									<option value="audi">Audi</option>
							</select></td>
							<td class="title">Mã Kế Toán</td>
							<td><input type="text" name="text_accountant"></td>
							<td class="title">Ngày Đầu Tư</td>
							<td colspan="3"><input style="width: 45%" type="date"
								name="text_start_date"> ~ <input style="width: 45%" type="date"
								name="text_end_date"></td>

						</tr>
						<tr>
							<td class="title">Đơn Giá</td>
							<td colspan="3"><input style="width: 45%" type="text"
								name="text_start_price"> ~ <input style="width: 45%" type="text"
								name="text_end_price"></td>
						</tr>

					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="title-feature">
					<div class="text-right">
						<button type="submit" style="border-radius: 0"
							class="btn btn-primary" data-toggle="modal"
							data-target="#myModal">
							<i class="fa fa-search" aria-hidden="true"></i>TÌM KIẾM
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
						<button type="submit" style="border-radius: 0"
							class="btn btn-primary">
							<i style='font-size: 24px' class='fas'>&#xf021;</i>REFESH
						</button>
						<button type="submit" style="border-radius: 0"
							class="btn btn-primary">
							<i style='font-size: 24px' class='fas'>&#xf02f;</i>IN
						</button>
						<button type="submit" style="border-radius: 0" data-toggle="modal"
							data-target="#myModal" class="btn btn-primary">
							<i style="font-size: 24px" class="fa">&#xf1c3;</i>NHẬP DỮ LIỆU
						</button>
						<button type="submit" style="border-radius: 0" onclick="GetSelected()"
							class="btn btn-primary">
							<i style="font-size: 24px" class="fa">&#xf1c3;</i>XUẤT DỮ LIỆU
						</button>
					</div>
				</div>
				</form>
				<table id="table.data" class="table table-bordered table-data"
					style="margin-top: 10px">
					<thead>
						<tr>
							<th></th>
							<th style="width: 8px">STT</th>
							<th>RFID</th>
							<th>TÊN MÁY</th>
							<th>MODEL</th>
							<th>SỐ SERI</th>
							<th>ĐƠN VỊ</th>
							<th>MÃ KẾ TOÁN</th>
							<th>NGÀY ĐẦU TƯ</th>
							<th>ĐƠN GIÁ</th>
						</tr>
					</thead>
					<tbody>
						<%
							int stt = 1;
						%>
						<c:forEach var="p" items="${listAssets}">
							<tr>
								<td><input name="checkboxrow" onclick="return GetSelected()" onchange="GetSelected()" type="checkbox" class="form-check-input"
									style="margin: 0px; padding: 0px" value=""></td>
								<td style="text-align: center;"><%=stt%></td>
								<td>${p.RFID}</td>
								<td>${p.getName()}</td>
								<td>${p.getModel()}</td>
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
					<a class="btn btn-default" style="padding:0px; line-height:30px; background-color:#bdc6e2; border-radius: 0; width: 30px; height:30px">1</a>
				<a class="btn btn-default" style="padding:0px; line-height:30px; background-color:#bdc6e2; border-radius: 0; width: 30px; height:30px">2</a>
				</div>
			</div>

		</div>

	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<s:form method="POST" commandName="excelFile" action="importexcel"
						enctype="multipart/form-data">
						<br />
Please select:  <input type="file" name="file">
						<br>
						<input type="submit" value="Upload">
					</s:form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
function GetSelected() {
    //Reference the Table.
    var grid = document.getElementById("table.data");

    //Reference the CheckBoxes in Table.
    var checkBoxes = document.getElementsByName("checkboxrow");
   

    //Loop through the CheckBoxes.
    for (var i = 0; i < checkBoxes.length; i++) {
    	var color ="white";
        if (checkBoxes[i].checked) {
        	color = "red";
        }
        
        var row = checkBoxes[i].parentNode.parentNode;
        for (var j=0; j<row.cells.length; j++) {
        	row.cells[j].style.backgroundColor = color;
        }
    }

    
}
	$(document).ready(function() {
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