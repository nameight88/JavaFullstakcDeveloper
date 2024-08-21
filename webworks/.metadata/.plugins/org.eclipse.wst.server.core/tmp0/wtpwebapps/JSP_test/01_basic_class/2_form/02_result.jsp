<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String user = request.getParameter("name");
    String gender = request.getParameter("gender");
    String occupation = request.getParameter("occupation");
   	String[] hobbys = request.getParameterValues("hobby");
 	String hobby ="";
   	for(String v :hobbys){
 		hobby += v+"/";
 	}
   	
   	for(int i =0; i<hobbys.length ;i+=1){
   		//hobby += v+'/';
   	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_result</title>
</head>
<body>
<h2>폼의 입력값 넘겨받아 처리</h2>
	성함 : <%=user%>님 <br/>
	성별 : <%=gender%> <br/>
	직업 : <%=occupation%> <br/>
	취미 : <%=hobby%> <br/>
</body>
</html>