<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>General management</title>
<jsp:include page="/common/library.jsp"></jsp:include>
<link rel="stylesheet" href="./resources/css/tabledata.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
.title_input {
	font-weight: 700;
}
</style>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<s:form method="POST" commandName="excelFile" action="ImportCSVAssetGenneral" style="width:60%; margin:auto; margin-top:20px;" enctype="multipart/form-data">
		<div class="col-sm-12">
			<label class="title_input">Chọn file excel:</label>

			<div class="custom-file">
				<input type="file"  type="file" name="file"
					class="custom-file-input" id="customFile"> <label
					class="custom-file-label" for="customFile"></label>
			</div>
			<div class="text-center">
			<button type="submit" style="margin:auto;border-radius: 0;margin-top:10px;" 
				class="btn btn-primary" name="upload">
				<i style='font-size: 24px' class='far'>&#xf044;</i> UPLOAD
			</button>
			<button type="submit" style="margin:auto;border-radius: 0;margin-top:10px;" 
				class="btn btn-primary" name="back">
				<i style='font-size: 24px' class='far'>&#xf044;</i>QUAY LẠI
			</button>
			</div>
			
		</div>
	</s:form>
</body>
<script type="text/javascript">
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>
</html>