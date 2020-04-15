<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% HttpSession te = request.getSession(); %>${CurrentYear}
<h1>ID USER: <%=te.getAttribute("id") %></h1>
<select id="cars">
<%
int current = Integer.parseInt(request.getAttribute("CurrentYear")+"");
int i=0;
while(i<100)
{
	%>
	 <option value="volvo"><%=current-i%></option>
	<%
	i++;
}
%>
</select>
<form action="register" method="POST">
  <label for="fname">NAME:</label><br>
  <input type="text" id="fname" name="usn" value="John"><p style="color:red">(*) ${message_name}</p>
  <label for="lname">PASSS:</label><br>
  <input type="text" id="lname" name="pass" value="Doe"><br><br>
   <label for="lname">OLD:</label><br>
  <input type="text" id="lname" name="old" value="Doe"><br><br>
  <input type="submit" value="DANG KY">
</form> 
</body>
</html>