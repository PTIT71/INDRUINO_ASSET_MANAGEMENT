<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Trang lỗi</title>

<jsp:include page="/common/library.jsp"></jsp:include>


<body style="overflow: hidden;">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>

	<div class="container">
		
		<img src="./resources/images/errors.png"/>
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>