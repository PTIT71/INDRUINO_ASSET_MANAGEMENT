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
.title_input {
	font-weight: 700;
}

textarea {
	resize: none;
	border-radius: 0px !important;
	height: 100px !important;
	border: 1px solid #0E0E0E !important;
}
</style>
<body onload="Pagination()">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
				<form action="CreateAssetGeneral" method="POST">
					<div class="title-feature">
						<div class="text-right">
							<button type="submit" name="save" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf067;</i>LƯU DỮ LIỆU
							</button>
							<button type="submit" name="back" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf067;</i>QUAY LẠI
							</button>
						</div>
					</div>
					<p
						style="width: 100%; text-align: center; color: red; font-weight: 700; margin-top: 10px">${message}</p>
					<p
						style="width: 100%; text-align: center; color: blue; font-weight: 700; margin-top: 10px">${notification}</p>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">TÊN TÀI SẢN:</label> <input
									type="text" class="form-control" name="asset_name">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">MÃ RFID:</label> <input type="text"
									class="form-control" name="asset_rfid">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">MODEL:</label> <input type="text"
									class="form-control" name="asset_model">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">SỐ SERIES:</label> <input type="text"
									class="form-control" name="asset_series">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">ĐƠN VỊ:</label> <input type="text"
									class="form-control" name="asset_department">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">MÃ KẾ TOÁN:</label> <input
									type="text" class="form-control" name="asset_accountant">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">NGÀY ĐẦU TƯ:</label> <input
									type="date" class="form-control" name="asset_date">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">ĐƠN GIÁ:</label> <input type="text"
									class="form-control" name="asset_price">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">GHI CHÚ:</label>
								<textarea class="form-control" name="asset_note"> </textarea>
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>