<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width: 150px;
	margin-left: 20px;
	cursor: pointer;
	transition: transform .2s;
}
.menu-general-manager-item p
{
	margin-top: 8px
}
.menu-general-manager-item  a
{
	text-decoration: none;
}

img {
	display: block;
	margin-left: auto;
	margin-right: auto;
}

.menu-general-manager {
	width: 700px;
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
</style>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<jsp:include page="/common/subHeaderEmpty.jsp"></jsp:include>
	<div class="container">
		<div class="menu-general-manager">
			<div
				class="menu-general-manager-item  zoom shadow-sm p-3 mb-5 bg-white rounded">
				<a href="discuss">
				<img alt="discuss" style="width: 80px"
					src="./resources/images/ic_discuss.png">
				<p style="font-size: 18px; text-align: center; font-weight: 700">Description</p>
					</a>
			</div>
			<div
				class="menu-general-manager-item  zoom shadow-sm p-3 mb-5 bg-white rounded">
				<a href="document">
				<img alt="discuss" style="width: 80px"
					src="./resources/images/ic_document.png">
				<p style="font-size: 18px; text-align: center; font-weight: 700">Documents</p>
					</a>
			</div>
			<div
				class="menu-general-manager-item zoom shadow-sm p-3 mb-5 bg-white rounded ">
				<a href="asset">
				<img alt="discuss" style="width: 80px"
					src="./resources/images/ic_asset.png">
				<p style="font-size: 18px; text-align: center; font-weight: 700">Asset</p>
					</a>
			</div>
			<div
				class="menu-general-manager-item zoom shadow-sm p-3 mb-5 bg-white rounded ">
				<a href="setting">
					<img alt="discuss" style="width: 80px"
					src="./resources/images/ic_setting.png">
				<p style="font-size: 18px; text-align: center; font-weight: 700">Setting</p>
				</a>
			
			</div>

		</div>

	</div>





	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>