<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
<h3>mvc에 의한 view page</h3>
${dbValue}가 전달되었습니다.<hr/>
${login}를 받았습니다.<hr/>
<!-- 여기서 실행을 할 경우 사용자가 WEB-INF로 접근하게 되므로 이경우에는
404로 경로를 찾지 못하게 된다. -->
</body>
</html>