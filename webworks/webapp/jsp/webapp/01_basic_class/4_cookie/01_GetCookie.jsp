<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%	
	// 1. 클라이언트로부터 Cookie를 얻어옴 배열로 가져온다
	Cookie[] ck = request.getCookies();
	String yourid = "";
	// 2. 쿠키 이름 중에 "yourid"가 있다면 그 쿠키의 값을 출력
	for(int i = 0; i<ck.length ; i+=1){
		String ckname = ck[i].getName();
		if( ckname.equals("yourid")){
			yourid = ck[i].getValue();
		}
	}
%>

<html>
<head><title>쿠키</title></head>
<body>	

<h1>Cookie 정보 알아내기</h1>

<h4>다음은 클라이언트 브라우저의 쿠키에서 얻어온 값 :<%= yourid %>> </h4><br><br>


<br><a href="01_ChangeCookie.jsp"> 쿠키값 변경 </a><br/>
<br><a href="01_RemoveCookie.jsp"> 쿠키제거 </a>

</body></html>
