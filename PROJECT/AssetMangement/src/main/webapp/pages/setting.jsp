<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Setting</title>
<jsp:include page="/common/library.jsp"></jsp:include>
</head>
<style>
.block-feature {
	margin-top: 20px;
}

.title-feature {
	background-color: #bdc6e2;
	padding-left: 10px;
	font-size: 22px;
	padding-top: 1px;
	padding-bottom: 1px;
	height: 34px;
}

.title-feature h2 {
	font-size: 22px;
	light-height: 34px;
}

.feauture .level1 {
	font-size: 18px;
	margin-top: 10px;
}

.feauture .level2 {
	font-size: 16px;
	font-weight: 0;
}

.feauture a {
	text-decoration: none;
	font-weight: 700;
}

.feauture a i {
	font-weight: 700;
	margin-right: 10px;
}

.option-feature {
	padding-left: 5px;
	padding-right: 5px;
}
</style>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<div class="" style="margin-top: 10px; padding: 0px;">
		<div class="row">
			<div class="col-sm-2">
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="#">General
							Setting</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Asset
							Setting</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Document</a>
					</li>
				</ul>
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-10 general-setting shadow-sm p-3 mb-5 bg-gray">
				<div class="block-feature" style="margin-top: 0px;">
					<div class="title-feature">
						<h2>Users</h2>
					</div>
					<div>
						<div class="option-feature">
							<div class="row">
								<div class="col-sm-6">
									<div class="feauture">
										<h4 class="level1">2 Active User</h4>
										<a href="user-manage"><i class="fa fa-arrow-right"></i>Manage Users</a>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="feauture">
										<h4 class="level1">Invite New User</h4>
										<form class="form-inline" action="/action_page.php">
											<input type="email" style="border-radius: 0; width: 70%"
												class="form-control" id="email"
												placeholder="Enter inviter email" name="email">
											<button type="submit" style="border-radius: 0"
												class="btn btn-primary">INVITE</button>
										</form>

									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="block-feature">
						<div class="title-feature">
							<h2>Companies</h2>
						</div>
					</div>
					<div class="option-feature">
						<div class="row">
							<div class="col-sm-6">
								<div class="feauture">
									<h4 class="level1">Indruino Technology Solutions</h4>
									<h4 class="level2">Số 01, Võ Văn Ngân, phường Linh Chiểu,
										quận Thủ Đức, TP.HCM</h4>
									<a href="#"><i class="fa fa-arrow-right"></i>Update
										Information</a>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="feauture">
									<h4 class="level1">2 Companies</h4>
									<a href="company-mangement"><i class="fa fa-arrow-right"></i>Manage
										Companies</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="block-feature">
					<div class="title-feature">
						<h2>Languages</h2>
					</div>
				</div>
				<div class="option-feature">
					<div class="row">
						<div class="col-sm-6">
							<div class="feauture">
								<h4 class="level1">1 Language</h4>
								<a href="#"><i class="fa fa-arrow-right"></i>Manage
									languages</a>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="feauture"></div>
						</div>
					</div>
				</div>

				<div class="block-feature">
					<div class="title-feature">
						<h2>Business Documents</h2>
					</div>
				</div>
				<div class="option-feature">
					<div class="row">
						<div class="col-sm-6">
							<div class="feauture">
								<h4 class="level1">Format</h4>
								<h4 class="level2">Set the paper format of printed
									documents</h4>
								<a href="#"><i class="fa fa-arrow-right"></i>Update Right</a>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="feauture">
								<h4 class="level1">Document Layout</h4>
								<h4 class="level2">Choose the layout of your documents</h4>
								<a href="#"><i class="fa fa-arrow-right"></i>Manage Rights</a>
							</div>
						</div>
					</div>
				</div>


				<div class="block-feature">
					<div class="title-feature">
						<h2>Users Rights</h2>
					</div>
				</div>
				<div class="option-feature">
					<div class="row">
						<div class="col-sm-6">
							<div class="feauture">
								<h4 class="level1">Default Acess Rights</h4>
								<h4 class="level2">Set custom access rights for new users</h4>
								<a href="#"><i class="fa fa-arrow-right"></i>Update Right</a>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="feauture">
								<h4 class="level1">User Rights</h4>
								<a href="#"><i class="fa fa-arrow-right"></i>Manage Rights</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer style="bottom: 0; overflow: hidden;">
	<div style="height: 120px; background-color: #005BB5; padding-left:40px">
		<div class="row">
			<div class="row"
				style="height: 60px; background-color: #005BB5; padding-top: 20px">
				<h2 style="color: white; width: 100%;">INDRUINO TECHNOLOGY
					SOLUTIONS</h2>
				<h3 style="color: white; font-size: 20px">ASSET MANAGEMENT SYSTEM FOR COMPANY</h3>

			</div>
		</div>
	</div>
</footer>
	</div>

</body>

</html>