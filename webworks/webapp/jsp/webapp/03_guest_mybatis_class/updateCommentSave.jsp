<%@page import="mybatis.guest.service.CommentService"%>
<%@ page import="mybatis.guest.model.Comment" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% 
 	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="comment" class="mybatis.guest.model.Comment">
 	<jsp:setProperty name="comment" property="*"/>
 </jsp:useBean>   
    
<% 

	CommentService service = CommentService.getInstance();
	service.updateComment(comment);
	
	response.sendRedirect("listComment.jsp");
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title>입력</title>
</head>
<body>

입력되었는지 확인해보세요. <br/>
<a href="listComment.jsp">목록보기</a>

</body>
</html>