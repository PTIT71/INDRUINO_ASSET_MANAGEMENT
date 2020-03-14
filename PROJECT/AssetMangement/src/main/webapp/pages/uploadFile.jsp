<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Setting</title>
<jsp:include page="/common/library.jsp"></jsp:include>
</head>
<body>
<s:form method="POST" commandName="excelFile" action="importexcel.html" enctype="multipart/form-data">
<br/>
Please select:  <input type="file" name ="file">
<br>
<input type="submit" value="Upload">
</s:form>
</body>