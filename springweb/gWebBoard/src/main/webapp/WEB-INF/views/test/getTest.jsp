<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String pjName ="/gWebBoard"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>여기는 getTest페이지</h2>
<!-- 상대 경로로 줄 경우 요청을 보낼 때의 주소가 달라서 찾질 못한다 -->
<!-- 상대경로로 할 경우 부모로 올라가서 다시 경로를 잡아줘야한다. -->
<a href='../board/getBoardList.do'>게시판 글 목록보기(상대경로)</a><hr/>
<!-- 절대경로 방법 -->
<a href='/gWebBoard/board/getBoardList.do'>게시판 글 목록보기(절대경로1)</a><hr/>
<a href='<%=pjName %>/board/getBoardList.do'>게시판 글 목록보기(절대경로1)</a><hr/>
<a href=''>게시판 글 목록보기</a><hr/>
<a href=''>게시판 글 목록보기</a><hr/>


</body>
</html>