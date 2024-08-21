<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<!------ Include the above in your HEAD tag ---------->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link href="<%=request.getContextPath() %>/resources/login/css/login.css" rel="stylesheet">
	<title>Find Account</title>
</head>
<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>

<body>
	<div class="container">
		<p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
		<hr><br>
		<div class="card bg-light" style=" width: 75%; margin-left: 180px; margin-top: 100px;">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center"><b>아이디 찾기</b></h4>
				<br>
				<!-- 아이디 찾기 ########################################### -->
				<form action="findId" class="findAccount-Id" method="post" enctype="multipart/form-data" >
					<table>
						<tr>
							<td><b>이메일</b></td>
							<td><input type="text" id="findId_email" class="findId_email" name="findId_email"></td>
						</tr>
					</table><br>
				<div class="d-grid">
					<button type="button" class="btn btn-primary" id="findIdButton" name="findIdButton" style="width:280px; justify-content: center; text-align: center;"> 아이디 검색 </button>
				</div>
				</form><br><hr><br>
				
				
				<!-- 비밀번호 찾기 ########################################### -->
	    		<h4 class="card-title mt-3 text-center"><b>비밀번호 찾기</b></h4><br>
				<form action="findPass" class="findPass" method="post" enctype="multipart/form-data" >
					<table>
						<tr>
							<td><b>아이디</b></td>
							<td><input type="text" id="findPass" class="findPass" name="findPass_id"></td>
						</tr>
						<tr>
							<td><b>이메일</b></td>
							<td><input type="text" id="findPass" class="findPass" name="findPass_email"></td>
						</tr>
					</table><br>
				<div class="d-grid ">
					<button type="button" class="btn btn-primary" id="findPassButton" name="findPassButton" style="width:280px; justify-content: center; text-align: center;"> 비밀번호 검색 </button>
				</div>
				</form><br>
				<dl style="color: gray;">
					<dd><p class="text-center"><small>계정이 존재하나요?</small><a href="/middleTest/login">&nbsp;Login&nbsp;&nbsp;</a></p></dd>
					<dd><p class="text-center"><small>계정이 없으신가요?</small><a href="signUp1">&nbsp;Create</a></p></dd>
				</dl>
			</article>
			<!-- article:card-body mx-auto -->
		</div> 
		<!-- div:card bg-light -->
	</div> 
	<!--div:container-->
	<br>
	
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="../resources/signUp/js/findAccount.js"></script>
</body>
<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
</html>