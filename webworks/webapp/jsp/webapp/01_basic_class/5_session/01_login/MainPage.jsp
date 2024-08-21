<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//# 1."id"로 저장된 세션값을 얻어온다.
	Object obj = session.getAttribute("id");
	//유저가 보낸 값이 session이 도중에 끊겨서 못가져오게 되면 null일수도
	//있기때문에 object값으로 그대로 가져오고 null값인지부터 확인을 하고 형변환
	//null인경우 로그인을 하지 않음
	//# 2. 값이 null이라면 LoginForm.jsp로 페이지 이동
	if(obj == null){
		response.sendRedirect("LoginForm.jsp");
		return;
	}
	//return 으로 함수를 벗어나게 해주어야한다.
	//# 3. null이 아니라면 String 형변환하여 변수에 지정
	String user = (String)obj;
	
%>
    
<!DOCTYPE html>
<html>
<head>
<title> 우리 페이지 </title>
</head>
<body>

	<h2> 이 페이지는 로그인을 하셔야만 볼 수 있는 페이지 입니다 </h2><br/><br/><br/>
	<%= user%>님, 로그인 중입니다.

</body>
</html>