<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="temp.*" %>
<%@ page import="java.util.*" %>

<%
EmpDao dao = EmpDao.getInstance();
	//List<EmpVO> list = dao.selectEmp();
	List<EmpVO> list = dao.selectEmp();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09_empSelect.jsp</title>
</head>
<body>

	<%
	for(EmpVO vo : list){
	%>
	<%= vo.getEmpno() %>
	<%= vo.getEname() %>
	<%= vo.getDeptno() %>
	<%= vo.getJob() %>
		<br/>
	<%} //end of for %>
</body>
</html>