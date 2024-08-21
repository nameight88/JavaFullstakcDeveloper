<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%  //--------------------------- 값 지정
	pageContext.setAttribute("name", "KIM");
	request.setAttribute("name", "SEUNGMIN");
	session.setAttribute("name", "DOKDO");
	application.setAttribute("name", "KOREA");
	//application.log("FirstPage.jsp : " + pageContext.getAttribute("name") + "님 접속");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 첫번째 페이지 </title>
</head>
<body>

하나의 페이지 속성 : <%= pageContext.getAttribute("name") %> <br>
하나의 요청 속성 :	 <%= request.getAttribute("name") %> <br>
하나의 세션 속성 :	 <%= session.getAttribute("name") %> <br>
하나의 어플리케이션 속성 : <%= application.getAttribute("name") %> <br>
<!-- 세션과 어플리케이션은 값을 끝까지 가져간다 -->
<!-- #############  -->
<a href='SecondPage.jsp'>다음</a>
<!-- 페이지 forward 이동된다면  -->
<!-- <jsp:forward page="SecondPage.jsp"></jsp:forward> -->
<!--	<% response.sendRedirect("SecondPage.jsp"); %> -->
<!-- secondpage로 넘어갔지만 first에서의 request값을 가져왔다. 
 클라이언트(사용자)가 request를 보낸 값을 그대로 가져간다.-->

</body>
</html>