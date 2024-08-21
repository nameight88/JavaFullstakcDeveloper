<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_basic.jsp</title>
</head>
<body>
	<c:set var='gender' value='male' />
	<c:if test="${gender=='male'}">
	당신은 남자입니다.<br />
	</c:if>
	<c:if test="${gender eq 'female'} }">
	당신은 여자입니다.<br />
	</c:if>

	<c:set var='age' value='26' />
	<c:choose>
		<c:when test="${age ge 10 and age lt 20}">청소년입니다.</c:when>
		<c:otherwise>어른입니다.</c:otherwise>
	</c:choose>

	<c:set var='sum' value='0' />
	<c:forEach var='i' begin='1' end='100'>
		<c:set var='sum' value='${ sum+i }' />
	</c:forEach>
	<hr />
	1~100까지의 합 : ${sum}
	<hr />
	<!--  1부터 100까지의 홀수의 합과 짝수의 합 -->

	<c:set var='evenSum' value='0' />
	<c:set var='oddSum' value='0' />
	<c:forEach var='i' begin='1' end='100'>
		<c:if test="${i%2==0}">
			<c:set var='evenSum' value='${ evenSum+i }'/>
		</c:if>
		<c:if test="${i%2!=0}">
			<c:set var='oddSum' value='${ oddSum+i }' />
		</c:if>

	</c:forEach>
	<hr />
	1~100까지짝수의 합 : ${evenSum}
	<hr />
	<hr />
	1~100까지홀수의 합 : ${oddSum}
	<hr />

	<%
	// int age = 26;
	%>
</body>
</html>