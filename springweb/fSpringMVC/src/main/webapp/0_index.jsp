<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // [1]클라이언트가 요청을 전송 webapp 밑에는 프론트%>
<h2><a href="start.do">시작</h2></a>
<% //눌렀을때의 Dispatch서블릿을 거쳐간다. %>

<%/*
index.jsp에서 링크를 눌러서 갔을때
http://localhost:8080/basic/start.do
	
hello.jsp에서 실행을 했을때의 url	
http://localhost:8080/basic/WEB-INF/views/hello.jsp

*/%>
</body>
</html>