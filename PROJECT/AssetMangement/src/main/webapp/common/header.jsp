<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="height: 60px; background-color: #005BB5; padding-left: 30px">
	<div style="width: 98%">
		<div class="row" style="height: 60px; background-color: #005BB5">
			<div class="SystemName col-sm-9" style="padding: 0px">
				<h1 style="color: white; line-height: 60px">
					<a style="text-decoration: none;" class="link-header"
						href="/AssetMangement/">ASSET MANAGEMENT</a>
				</h1>
			</div>
			<div class="UserName col-sm-3">
				<%
					HttpSession session_en = request.getSession();
					if (session.getAttribute("NAME") != null && session.getAttribute("NAME").toString().trim().length() > 0) {
				%>
				<a class="nameuser dropdown-toggle" type="button"
					data-toggle="dropdown"> <i class="far iconuser">&#xf007;</i> <%=session.getAttribute("NAME").toString()%>(<%=session.getAttribute("ID").toString()%>)
				</a>
				<ul class="dropdown-menu drop-menu">
					<li><a href="login">Đăng xuất</a></li>
					<li><a href="#">Tải lại trang</a></li>
				</ul>
				<%
					}
				%>

			</div>

		</div>
	</div>
</div>





