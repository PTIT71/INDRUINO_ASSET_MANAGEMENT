<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div style="margin-top: 10px; padding: 0px; width: 100%; margin: auto">
	<div style="margin: 10px">
	<form action="UserManagement" method="POST">
		<div class="title-feature">
			<div class="title-feature-sub">
				<button type="submit" name="create"
					class="btn btn-primary">
					<i style="font-size: 24px" class="fa">&#xf067;</i>THÊM MỚI
				</button>
			</div>
			<div class="text-right">
				<button type="submit" class="btn btn-primary text-right" name="back">
					<i class="fas fa-undo"></i> QUAY TRỞ LẠI
				</button>
			</div>
		</div>
		</form>
	</div>
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
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