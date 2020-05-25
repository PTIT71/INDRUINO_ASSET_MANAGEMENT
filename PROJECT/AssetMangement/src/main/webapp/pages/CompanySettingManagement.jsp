<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>General management</title>
<jsp:include page="/common/library.jsp"></jsp:include>
<style type="text/css">
.table-feature
{
	margin-top: 10px;
	
}
.table-feature tbody tr td
{
	width: 150px;
	height: 50px;
	border: 0px !important;
	padding-top: 5px;
	padding-bottom: 5px;
	
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
.btn-logout
{
	background-color: darkred;
}
</style>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div class="container">
		 <table class="table  table-feature">
    <tbody>
      <tr>
        <td><a class="btn  btn-feature" href="AssetManagementGeneral">THÔNG TIN DOANH NGHIỆP</a></td>
        <td><a class="btn  btn-feature" href="DepartmentManagement">QUẢN LÝ ĐƠN VỊ</a></td>
        <td><a class="btn  btn-feature" href="UserManagement">QUẢN NGƯỜI DÙNG</a></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td><a class="btn  btn-feature btn-logout" href="feature?cmpn=<%= session.getAttribute("SUB_SYSTEM_CD") %>">TRỞ LẠI</a></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>

	</div>





	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>