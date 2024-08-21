<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest.service.WriteMessageService"%>    

<!-- 
	0. 넘겨받는 데이타의 한글처리
	
	1. 화면의 입력값을 Message 클래스로 전달
	2. Service 클래스의 함수 호출
 -->     
<%
//[0]한글처리 
request.setCharacterEncoding("utf-8");
%>

 <% //[1] 화면의 입력값을 Message 클래스로 전달 %>
<jsp:useBean id="rec" class="guest.model.Message">
	<jsp:setProperty name="rec" property="*"/>
</jsp:useBean>

<%//[2]Service 클래스의 함수 호출 %>
<%	//싱글톤패턴
	WriteMessageService service = 
		WriteMessageService.getInstance();
	service.write(rec);
%>

<%	//개발자들이 확인용으로 쓰인다.
	//System.out.println(rec.toString());
%>
<!--  입력후 목록보기로 페이지를 전환 -->
<!-- 요즘은 아래처럼 입력후 페이지를 보여주는 것이 추세 -->
<!-- (1) forward 지금 같은 상황에서는 forward를 쓰면 안된다.-->
<%//<jsp:forward page="listMessage.jsp"/> %>
<!-- 주소는 saveMessage 지만 화면은 listMessage로 되어있다 새로고침을 하면
	중복된 값이 계속 불러온다. -->
<!-- (2)redirect-->
<% response.sendRedirect("listMessage.jsp"); %>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 남김 </title>
</head>
<body>
	<font size="3" color="#bb44cc">
		방명록에 메세지를 남겼습니다. 
	</font><br/><br/><br/>
	 [ 목록보기 ] 
</body>
</html>
 -->