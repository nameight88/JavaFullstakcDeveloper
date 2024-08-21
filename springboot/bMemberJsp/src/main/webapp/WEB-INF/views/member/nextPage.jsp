<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>다른 페이지 이동</title>
</head>
<body>
		<h1>다른 페이지 이동</h1>
		<hr/>
		${mem.name}님 로그인 후 작업<br/>
		${sessionScope.sess.name}님, 로그인 성공하셨습니다.
		<hr/>
		
</body>
</html>