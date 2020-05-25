<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.awt.Dimension" %>
	<%@ page import="java.awt.Toolkit" %>
	

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
      <% 
      		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      		double height = screenSize.getHeight();
      		double width = screenSize.getWidth();
      		System.out.print("kich thuoc: " + width + " " + height);
      		
      %>
      <% if(width > 600 && height >600) { %>
        <td><a class="btn  btn-feature" href="AssetManagementGeneral">QUẢN LÝ TÀI SẢN</a></td>
        <td><a class="btn  btn-feature" href="BorrowAssetManagement">ĐĂNG KÝ MƯỢN</a></td>
        <td></td>
        <td><a class="btn  btn-feature btn-admin" href="CompanySettingManagement">QUẢN TRỊ DOANH NGHIỆP</a></td>
      </tr>
      <%} %>
      <tr>
       <% if(width > 600 && height >600) { %>
        <td><a class="btn  btn-feature" href="InventorySessionInit">QUẢN LÝ KIỂM KÊ TÀI SẢN</a></td>
        <td><a class="btn  btn-feature" href="LoanAssetManagement">ĐĂNG KÝ CHO MƯỢN</a></td>
        <td></td>
        <td><a class="btn  btn-feature btn-logout" href="/AssetMangement/">ĐĂNG XUẤT</a></td>
      </tr>
       <%} %>
      <tr>
        <td><a class="btn  btn-feature" href="inventory">KIỂM KÊ TÀI SẢN</a></td>
          <% if(width > 600 && height >600) { %>
        <td><a class="btn  btn-feature" href="RentAssetManagement">ĐĂNG KÝ THUÊ TÀI SẢN</a></td>
        <td></td>
        <td></td>
         <%} %>
      </tr>
      <tr>
        <td><a class="btn  btn-feature" href="AssetLiquidation/">THANH LÝ TÀI SẢN</a></td>
         <% if(width > 600 && height >600) { %>
        <td><a class="btn  btn-feature" href="/AssetMangement/">BÁO CÁO SỰ CỐ</a></td>
         <%} %>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>

	</div>





	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>