<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kiểm kê</title>
<jsp:include page="/common/library.jsp"></jsp:include>
</head>
<body>
	<div class="row"
		style="height: 60px; background-color: #005BB5; padding-left: 30px">
		<div style="width: 98%">
			<div class="row" style="height: 60px; background-color: #005BB5">
				<p
					style="width: 100%; line-height: 60px; font-size: 20px; color: white; text-align: center;">MÀN
					HÌNH KIỂM KÊ</p>
				

			</div>

		</div>
	</div>
	<form action="checkInventory" style="width:90%; margin:auto" method="POST">
					<div class="form-group">
						<label for="usr">RFID:</label> <input type="text"
							class="form-control" id="usr" name="rfid">
					</div>
					<button type="submit" class="btn btn-primary">Kiểm kê</button>
				</form>
				<p style="width:100%; text-align: center; color: red; font-weight: 700; margin-top:10px">${message}</p>
				<c:if test="${Asset != null}">
				<table class="table table-bordered" style="width:90%; margin:auto; margin-top:12px;">
    <tbody>
      <tr>
        <td style="width:35%; font-weight: 700">Tên tài sản</td>
        <td style="color: red; font-weight: 700">${Asset.getName()}</td>
      </tr>
      <tr>
        <td style="font-weight: 700">Series</td>
        <td>${Asset.getSeries()}</td>
      </tr>
      <tr>
        <td style="font-weight: 700">Model</td>
        <td>${Asset.getModel()}</td>
      </tr>
       <tr>
        <td style="font-weight: 700">Đơn vị</td>
        <td>${Asset.getDepartment()}</td>
      </tr>
       <tr>
        <td style="font-weight: 700">Ngày đầu tư</td>
        <td>${Asset.getDateStart()}</td>
      </tr>
      <tr>
        <td style="font-weight: 700">Trạng thái</td>
        <td style="color:green;font-weight: 700">Kiểm kê thành công</td>
      </tr>
      
    </tbody>
  </table>
   </c:if>
</body>
</html>