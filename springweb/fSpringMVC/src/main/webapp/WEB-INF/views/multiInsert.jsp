<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- ************************* -->
 <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- ************************* -->
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>맴버리스트</h2>
<table border='2'>
	<tr>
		<td>이름</td><td>아이디</td><td>이름</td>
	</tr>
	<c:forEach var='vo' items='${memberVOList.list }'>
		<c:if test="${vo.state}">
			<tr>
				<td>${vo.name }</td>
				<td>${vo.id }</td>
				<td>${vo.age }</td>
			</tr>
		</c:if>
	</c:forEach>
</table>
</body>
</html>