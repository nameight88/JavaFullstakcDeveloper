<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>


<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="info" class="info.beans.InfoBean">
  <jsp:setProperty name="info" property="name" />
  <jsp:setProperty name="info" property="id" />
</jsp:useBean>

<!DOCTYPE html>
<HTML>
<HEAD><TITLE> 자료 출력 </TITLE></HEAD>
<BODY>
	<H2>  당신의 신상명세서 확인 </H2>
	이   름  : ${info.name}<br/>
	주민번호 : ${info.id}<br/>
	성  별   : ${info.gender}<br/> <!-- getGender() 자동으로 이런식으로 호출 -->  
	맞습니까????
</BODY>
</HTML>