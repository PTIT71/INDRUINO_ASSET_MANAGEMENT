<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>

	<h1>${ten}</h1>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Price</td>
			<th>Quantity</th>
			<th>Status</th>
			<th>Creation Date</th>
		</tr>
		<c:forEach var="p" items="${listProducts}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.quanity}</td>
				<td>${p.status}</td>
				<td>${p.creationDate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>