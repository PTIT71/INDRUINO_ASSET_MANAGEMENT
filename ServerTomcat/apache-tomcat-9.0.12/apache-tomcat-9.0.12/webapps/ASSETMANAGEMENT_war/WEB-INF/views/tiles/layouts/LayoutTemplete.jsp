<%--
  Created by IntelliJ IDEA.
  User: phanv
  Date: 17-Feb-20
  Time: 01:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true" /> </title>
</head>
<body>
    <tiles:insertAttribute name="body"/>
</body>
</html>
