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
<a href='<%= prjName%>/SimpleControl'>MVC패턴방식</a><br/>
<a href='<%= prjName%>/SimpleControl?type=first'>MVC패턴방식2</a><br/>
<hr/>
<a href='/JSP_test/ictedu.do'>MVC3</a>
</body>
</html>


