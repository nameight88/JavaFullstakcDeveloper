<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 데이타 받는 페이지 </title>
</head>
<body>

파라메터 값(전 페이지에서 넘어오는 값) : ${param.data } <br/> 

세션의 값 :  ${sessionScope.login }<br/>

쿠키의 값 :	${cookie.isFlag.value } <br/>


<hr>


</body>
</html>