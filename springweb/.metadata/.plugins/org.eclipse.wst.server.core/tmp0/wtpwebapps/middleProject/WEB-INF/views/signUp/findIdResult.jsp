<%@page import="com.javaclass.vo.UserVO"%>
<%@page import="com.javaclass.dao.UserDaoImpl"%>
<%@page import="com.javaclass.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8");

	
	UserDaoImpl udao = new UserDaoImpl();
	UserVO vo = new UserVO();
	//String user_idinfo = udao.findIdUser(vo);
	
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>