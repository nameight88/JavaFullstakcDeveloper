<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String prjName="/JSP_test"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>

<a href="./simpleView.jsp">기존방식(상대경로)</a>
<a href="<%=prjName%>/07_mvc_class/1_mvcSimple/simpleView.jsp">기존방식(절대경로)</a>

<hr/>


</body>
</html>