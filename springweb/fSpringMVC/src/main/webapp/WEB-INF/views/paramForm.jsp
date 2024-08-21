<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paramForm</title>
</head>
<body>
<h2>파람 데이터 확인</h2>
아이디:${memberVO.id}<hr/>
이름:${memberVO.name}<hr/>
나이:${memberVO.age}<hr/>
${sessionScope.login}님 로그인 중입니다.
</body>
</html>