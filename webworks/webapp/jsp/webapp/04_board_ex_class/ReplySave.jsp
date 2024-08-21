<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@ page import='reply_ex.model.*' %>
 <%@ page import='reply_ex.service.*' %>
 
 <%
	// 0. 넘겨받는 데이타의 한글 처리
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class='reply_ex.model.ReplyVO'>
	<jsp:setProperty name="vo" property="*"/>
</jsp:useBean>
<!--  서비스단()에 함수로 VO객체 넘기기 -->

ReplyInsertService service = ReplyInertSerice.getIntance();
service.

<%//확인 
	System.out.println(vo.toString());
%>
