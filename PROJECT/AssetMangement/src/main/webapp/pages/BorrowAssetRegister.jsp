<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.asset.management.util.Common" %>
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

button.btn_select {
	height: 38px;
	width: 60px;
}

button.btn_clear {
	height: 38px;
	width: 50px;
}
</style>
<body onload="Pagination()">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
				<form action="BorrowAssetRegister" method="POST">
					<div class="title-feature">
						<div class="text-right">
							<button type="submit" name="save" class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf067;</i>XÁC NHẬN
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
					<div class="title-section">PHÍA DOANH NGHIỆP CHO MƯỢN TÀI SẢN</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">CÔNG TY:</label> <br> <input
									style="width: 35%; display: inline-block;" type="text" id="loan_cmpn_cd" list="loan_cmpn_cd_item"
									class="form-control" name="loan_cmpn_cd"> 
									<datalist class="selectList-item"
										id="loan_cmpn_cd_item">
										<c:forEach var="cpm" items="${lstcmpn}">
											<option value="${cpm.company_cd}">
										</c:forEach>
									</datalist>
									
									
									<input
									type="text" style="width: 60%; display: inline-block;"
									class="form-control" id="loan_cmpn_na" name="loan_cmpn_na" list="loan_cmpn_na_item">
									<datalist class="selectList-item"
										id="loan_cmpn_na_item">
										<c:forEach var="cpm" items="${lstcmpn}">
											<option value="${cpm.company_name}">
										</c:forEach>
									</datalist>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">ĐƠN VỊ</label> <br> <input
									type="text" class="form-control" name="loan_cmpn_dept">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">NGÀY CHO MƯỢN</label> <br> <input
									type="date" class="form-control" name="loan_date">
							</div>
						</div>
					</div>
					<div class="title-section">THÔNG TIN TÀI SẢN</div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label class="title_input">TÊN TÀI SẢN</label> <input type="text"
									class="form-control" name="asset_name">
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="title_input">MÃ RFID:</label> <input type="text"
									class="form-control" name="asset_rfid">
							</div>
						</div>


						<div class="col-sm-3">
							<div class="form-group">
								<label class="title_input">MODEL:</label> <input type="text"
									class="form-control" name="asset_model">
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="title_input">SỐ SERIES:</label> <input type="text"
									class="form-control" name="asset_series">
							</div>
						</div>

					</div>				
					<div class="title-section">PHÍA DOANH NGHIỆP MƯỢN TÀI SẢN</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">CÔNG TY:</label> <br> <input
									style="width: 35%; display: inline-block; " readonly="readonly" value="${borrow_cmpn_cd}" type="text"
									class="form-control" name="borrow_cmpn_cd"> <input
									type="text" style="width: 60%; display: inline-block;" value="${borrow_cmpn_na}" readonly="readonly"
									class="form-control" name="borrow_cmpn_na">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">ĐƠN VỊ</label> <br> <input
									type="text" class="form-control" name="borrow_cmpn_dept">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">NGÀY TRẢ</label> <br> <input
									type="date" class="form-control" name="borrow_date">
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="title_input">LÝ DO MƯỢN TÀI SẢN</label> <br> <textarea
									type="date" class="form-control" name="borrow_reason"></textarea>
							</div>
						</div>
					</div>
			</form>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
$('#loan_cmpn_cd').change(function(){
	var id = document.getElementById("loan_cmpn_cd")
	alert('http://localhost:8080/AssetMangement/GetNameCompany?mode=ID&pagram='+id.value);
	$.ajax({
		type:'GET',
		url:'http://localhost:8080/AssetMangement/GetNameCompany?mode=ID&pagram='+id ,
		success: function(result)
		{
			//$('#logoimage').href(result);
			alert(result);
			document.getElementById("loan_cmpn_na").value = result;
		}
	
	});
});

</script>
</html>