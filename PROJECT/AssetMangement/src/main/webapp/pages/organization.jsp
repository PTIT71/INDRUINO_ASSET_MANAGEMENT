<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>General management</title>
<jsp:include page="/common/library.jsp"></jsp:include>
</head>
<style>
.menu-general-manager-item {
	float: left;
	width: 180px;
	margin-left: 20px;
	cursor: pointer;
	transition: transform .2s;
}

.menu-general-manager-item p {
	margin-top: 8px
}

.menu-general-manager-item  a {
	text-decoration: none;
}

img {
	display: block;
	margin-left: auto;
	margin-right: auto;
}

.menu-general-manager {
	width: fit-content;
	height: 100px;
	margin: auto;
	margin-top: 60px
}

.zoom {
	transition: transform .2s;
}

.zoom:hover {
	-ms-transform: scale(1.5); /* IE 9 */
	-webkit-transform: scale(1.5); /* Safari 3-8 */
	transform: scale(1.5);
}
.btn-feature
{
	width:100%;
	height:50px;
	margin: auto;
	background-color: green;
	line-height: 36px;
	color: white;
	font-weight: 700;
	
    
}
.btn-feature:hover
{
	background-color: #007bff;
	color:white;
}
.btn-admin
{
	background-color: orange;
}
</style>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div class="container">
		<div class="menu-general-manager">
		<p style="width:100%; text-align: center; color: red; font-weight: 700; margin-top:10px">${message}</p>
			<c:if test="${lstCompany.size() > 0}">
			<c:forEach var="p" items="${lstCompany}">
			<div
				class="menu-general-manager-item  zoom shadow-sm p-3 mb-5 bg-white rounded">
				<a href="feature?cmpn=${p.getCompany_cd()}"> <img alt="discuss" style="width: 100%"
					src="./resources/images/ic_viettien.png">
					<p style="font-size: 18px; text-align: center; font-weight: 700">${p.getCompany_shortname()}</p>
				</a>
			</div>
			</c:forEach>
			</c:if>
			<td><a class="btn  btn-feature btn-admin" href="admin-manager">QUẢN TRỊ HỆ THỐNG</a></td>

		</div>

	</div>





	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>