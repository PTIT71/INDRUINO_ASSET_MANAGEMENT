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
</style>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div class="container">
		 <table class="table  table-feature">
    <tbody>
      <tr>
        <td><a class="btn  btn-feature" href="organization">QUẢN LÝ TÀI SẢN</a></td>
        <td><a class="btn  btn-feature" href="#">ĐĂNG KÝ MƯỢN</a></td>
        <td></td>
        <td><a class="btn  btn-feature btn-admin" href="admin-manager">QUẢN TRỊ HỆ THỐNG</a></td>
      </tr>
      <tr>
        <td><a class="btn  btn-feature" href="inventory-management-init">QUẢN LÝ KIỂM KÊ TÀI SẢN</a></td>
        <td><a class="btn  btn-feature" href="#">ĐĂNG KÝ TRẢ</a></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td><a class="btn  btn-feature" href="inventory">KIỂM KÊ TÀI SẢN</a></td>
        <td><a class="btn  btn-feature" href="#">BÁO CÁO SỰ CỐ</a></td>
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