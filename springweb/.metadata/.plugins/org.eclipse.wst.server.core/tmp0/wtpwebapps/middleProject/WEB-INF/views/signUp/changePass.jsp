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
	<title>Change Account Password</title>
</head>

<body>
	<div class="container">
		
		<br>
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				
				
				<!-- 비밀번호 수정 ########################################### -->
	    		<h4 class="card-title mt-3 text-center"><b>변경할 비밀번호를 입력해주세요</b></h4><br>
				<form action="updatePass" class="changePass" method="post" enctype="multipart/form-data" >
					<table>
						<tr>
							<td><b>새로운 비밀번호</b></td>
							<td><input type="text" id="changeNewPass" class="changeNewPass" name="changeNewPass" placeholder="2~15자 영문,숫자 조합" pattern="[A-Za-z0-9]{2,15}"></td>
						</tr>
						<tr>
							<td><b>비밀번호 확인</b></td>
							<td><input type="text" id="changeNewPassChk" class="changeNewPass" name="changeNewPassChk" placeholder="바뀐 값과 동일하게 작성" pattern="[A-Za-z0-9]{2,15}" ></td>
						</tr>
					</table><hr>
				<div class="d-grid ">
					<button type="button" class="btn btn-primary" id="changeAccountPass" name="changeAccountPass" style="width:280px; justify-content: center; text-align: center; margin-left: 35px;"> 비밀번호 변경하기 </button>
				</div>
				</form>
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
</html>