<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="board_ex.service.*, board_ex.model.*"%>
<%
	// 게시글번호 넘겨받아
	String seq = request.getParameter("seq");//대소문자 구별
	// 서비스의 함수를 호출하여 해당 BoardVO를 넘겨받는다.
	ViewArticleService service = ViewArticleService.getInstance();
	BoardVO vo = service.getArticleById(seq);
	//return 되는 타입 board vo

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 보기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	
	$('#replyBtn').click(function () {
	 var seq = $('#seq').val();
	 var user = $('#user').val();
	 var reply = $('#reply').val();
	 var param={
			 seq:$('#seq').val()
	 		,user: $('#user').val()
	 		,reply:$('#reply').val()
	 }
	 
	 $.ajax({
		 type: 'get'
		 ,url: 'ReplySave.jsp'
		 ,data: param
		 ,success:function(){
			 //추후에 댓글 목록 보여주기
				$('#user').val(' ');
			 	$('#reply').val(' ');
		 }
	 	 ,error:function(){
	 		 alert('댓글입력실패');
	 	 }
	 	});
	 
		// alert(param);
		//console.log(param);
	});
	
})

</script>
</head>

<body>

	<h4>게시판 글 보기</h4>
	<br />
	<table border="1" bordercolor="red">
		<tr>
			<td>제 목 :</td>
			<td><%= vo.getTitle() %></td>
		</tr>
		<tr>
			<td>작성자 :</td>
			<td><%= vo.getWriter() %></td>
		</tr>
		<tr>
			<td>작성일자 :</td>
			<td><%= vo.getRegdate() %></td>
		</tr>
		<tr>
			<td>내 용 :</td>
			<td><%= vo.getContent() %></td>
		</tr>
		<tr>
			<td>조회수 :</td>
			<td><%= vo.getCnt() %></td>
		</tr>
		<tr>
			<td colspan="2"><a href="BoardList.jsp"> 목록보기 </a> <a
				href="BoardModifyForm.jsp?seq=<%=vo.getSeq()%>"> 수정하기 </a> <a
				href="BoardDeleteForm.jsp?seq=<%=vo.getSeq()%>"> 삭제하기 </a></td>
		</tr>

	</table>
	<form id='replyFrm' name='replyFrm'>
		<input type="hidden" name='seq' id='seq' value='<%=seq%>'> <input
			type='text' id='user'> <input type='text' id='reply'
			name='reply'> <input type="button" id='replyBtn' value='댓글추가'>
	</form>
	<table id='replyList'></table>

</body>
</html>