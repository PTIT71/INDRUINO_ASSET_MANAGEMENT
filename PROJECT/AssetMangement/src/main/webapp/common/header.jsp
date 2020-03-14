<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<div style="height: 60px; background-color: #005BB5; padding-left:30px">
			<div style="width: 98%">
				<div class="row" style="height: 60px; background-color: #005BB5">
					<div class="SystemName col-sm-9" style="padding: 0px">
						<h1 style="color: white; line-height: 60px">ASSET MANAGEMENT</h1>
					</div>
					<div class="UserName col-sm-3">
					<%
					 		HttpSession session_en=request.getSession();  
							if(session.getAttribute("NAME")!=null && session.getAttribute("NAME").toString().trim().length()>0)
							{
								%>
								  <i style='font-size: 24px; color: white; line-height: 60px; float: left' class='far'>&#xf007;</i>
                     			  <p style="padding-left: 30px; font-size: 16px; color: white; line-height: 60px"><%=session.getAttribute("NAME").toString()%>(<%=session.getAttribute("ID").toString() %>)</p>
								<%
							}
				      		
					%>
						
					</div>

				</div>
			</div>
		</div>

		
	


