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
.title_input
{
	font-weight: 700;
	float:left;
}
.content_input
{
	float: left;
	margin-left:10px;
}


</style>
<body onload="Pagination()">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div style="margin-top: 10px; padding: 0px; width: 95%; margin: auto">
		<div class="row">
			<div class="col-sm-12 general-setting shadow-sm p-3 mb-5 bg-gray">
				<form action="BorrowAssetView" method="POST">
					<div class="title-feature">
						<div class="text-right">
							<input type="text" value="${asset.getId()}" style="display: none;" name="rfid_code">
							<button type="submit" style="border-radius: 0" 
								class="btn btn-primary" name="update">
								<i style='font-size: 24px' class='far'>&#xf044;</i> CHỈNH SỬA
							</button>
							<button type="submit" style="border-radius: 0" 
								class="btn btn-primary" name="delete">
								<i style='font-size: 24px' class='fas'>&#xf2ed;</i>XÓA
							</button>							
							<button type="submit" style="border-radius: 0" name="back"
								class="btn btn-primary">
								<i style="font-size: 24px" class="fa">&#xf1c3;</i>QUAY LẠI
							</button>
						</div>
					</div>
				</form>
				<p class="message_error">${message}</p>
			    <c:if test="${asset!=null}">
			    	<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">TÊN TÀI SẢN:</label>
								<p class="content_input">${asset.getAsset_name()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">MÃ RFID:</label> 
								<p class="content_input">${asset.getAsset_rfid()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">MODEL:</label> 
								<p class="content_input">${asset.getAsset_model()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">SỐ SERIES:</label>
								<p class="content_input">${asset.getAsset_series()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">DOANH NGHIỆP CHO MƯỢN:</label>
								<p class="content_input">${asset.getLoan_cmpn_name()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">ĐƠN VỊ CHO MƯỢN:</label> 
								<p class="content_input">${asset.getLoan_dept()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">ĐƠN VỊ  MƯỢN:</label> 
								<p class="content_input">${asset.getBorrow_dept()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">NGÀY CHO MƯỢN:</label> 
								<p class="content_input">${asset.getLoad_Date()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">NGÀY TRẢ:</label> 
								<p class="content_input">${asset.getPay_date()}</p>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="title_input">LÝ DO:</label>
								<p class="content_input">${asset.getBorrow_reason()}</p>
							</div>
						</div>
						
					</div>
			    </c:if>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

</script>

</html>