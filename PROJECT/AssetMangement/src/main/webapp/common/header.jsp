<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
	div.fixed {
	position: fixed;
    bottom: 0;
    right: 0;
    border: 3px solid white;
    z-index: 999999;
    background-color: #005BB5;
    padding:5px;
    padding-left: 20px;
    padding-right: 50px;
    color: white;
    font-size: 25px;
    border-right: 0px;
    border-bottom: 0px;
    border-top-left-radius: 25px !important;
}
}
	</style>
<div style="height: 60px; background-color: #005BB5; padding-left: 30px">
	<div style="width: 98%">
		<div class="row" style="height: 60px; background-color: #005BB5">
			<div class="SystemName col-sm-9" style="padding: 0px">
				<h1 style="color: white; line-height: 60px; font-size: 30px;">
					<a style="text-decoration: none;" class="link-header"
						href="/AssetMangement/">
						<%
						HttpSession session_ens = request.getSession();
						if (session.getAttribute("SYSTEM_NAME") != null && session.getAttribute("SYSTEM_NAME").toString().trim().length() > 0) {
						%>
						<%=session.getAttribute("SYSTEM_NAME").toString()%>
						<%
						}
						else
						{
							%>
							ASSET MANAGEMENT
							<%
						}
						%>
						</a>
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
<%
if (session.getAttribute("SUB_SYSTEM_NAME") != null && session.getAttribute("SUB_SYSTEM_NAME").toString().trim().length() > 0) {
%>
<div class="fixed">
<%=session.getAttribute("SUB_SYSTEM_NAME").toString()%>
</div>
<%
}
%>





