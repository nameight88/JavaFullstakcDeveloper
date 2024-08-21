<%@ page language="java" contentType="text/html; charset=utf-8" %>
 <%@ page import="java.util.*" %>
 <%@ page import="mybatis.guest.model.Comment" %>    
 <%@ page import="mybatis.guest.service.CommentService" %>  
  
  <!-- 서비스의 메소드 호출  -->
  <%
  // 파라메터 값 받기
  String selectKey = request.getParameter("selectKey");
  String searchWord = request.getParameter("searchWord");
  //System.out.println(searchWord+"/"+selectKey);
  
     HashMap condition = new HashMap();
     condition.put("selectKey",selectKey);
     condition.put("searchWord",searchWord);
     List<Comment> mList = 
    		 CommentService.getInstance().selectComment(condition);
     //[2]서비스에 있는 selectComment가 없으므로 새로 만들어 줘야한다. -> CommentService
     
     
     //update
 %>
  
<!DOCTYPE HTML>
<html> 
<head>+
	<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>

<a href="insertCommentForm.jsp">방명록 남기기 </a><br/><br/>
<!-- 검색창 추가 -->
<form action='listComment.jsp'>
	<select name='selectKey'>
		<option value='user_id'>작성자</option>
		<option value='comment_content'>글내용</option>
	</select>
	<input type='text' name='searchWord'>
	<input type='submit' value='검색'>
</form>
<hr/>
<table border="1">
	<tr><td>글번호</td><td>작성자</td><td>등록일</td></tr>
	<% for( Comment comment : mList ) { %>
		<tr>
			<td><%= comment.getCommentNo() %></td>
			<td><a href="viewComment.jsp?cId=<%=comment.getCommentNo()%>"><%= comment.getUserId()%> 님이 쓴 글</a></td>
			<td><%= comment.getRegDate()%></td>
		</tr>
	<% } %>
</table>
</body>
</html>