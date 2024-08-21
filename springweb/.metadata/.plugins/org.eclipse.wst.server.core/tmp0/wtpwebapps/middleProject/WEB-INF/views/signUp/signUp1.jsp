<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
	<!------ Include the above in your HEAD tag ---------->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link href="../resources/signUp/css/signUp.css" rel="stylesheet">
	<title>SignUp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>	
</head>
<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
<body>
	<div class="container">
		<p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
		<hr>
		
		<div class="card bg-light" style=" width: 75%; margin-left: 180px; margin-top: 15%;">
			<article class="card-body mx-auto" style="max-width: 400px;">
			    <h4 class="card-title mt-3 text-center">Create Account</h4>
			    <br>   
				<form class="signupForm" action="signUp2" method="POST">
					<c:set var="customer" value="${ newCustomer }" />
					<input type="hidden" name="socialId" value="${ newCustomer.socialId }">
				  	<input type="hidden" name="socialType" value="${ newCustomer.socialType }">
					<div class="form-desc"><h6><b>환영합니다! 고객유형을 선택해주세요</b></h6></div>
					<div class="form-group input-group">
					    <div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-filter"></i> </span>
							
						</div>
						<!-- div:input-group-prepend -->
						<select class="form-control" name="customerType">
							<option value="1">고객</option>
							<option value="2">중개자</option>
						</select>
					</div><hr>
					<!-- div:form-group input-group -->
					<div class="serciveCheckAll">
						<h3><b>약관 동의</b></h3>
						<h6>서비스 이용약관에 동의해주세요</h6><br>
						<input type="checkbox" id='checkAll' class='checkAll'> 네, 모두 동의합니다. <hr>
					</div>
					<div class="checkboxes">
						<input type="checkbox" id='check1' class='joinCheck' required="required"> <b>[필수]</b> 만 14세 이상입니다.	<br>
						<input type="checkbox" id='check2' class='joinCheck' required="required"> <b>[필수]</b> 부동산 서비스 이용약관 동의   <a href="termsOfService1" target="blank" >></a><br>
						<input type="checkbox" id='check3' class='joinCheck' required="required"> <b>[필수]</b> 개인정보 수집 및 이용 동의   <a href="https://main.d3qjzrynlab66o.amplifyapp.com/terms/dabang/join/collecting-use-personal" target="blank">></a><br>
						<input type="checkbox" id='check4' class='joinCheck' > [선택] 마케팅 정보 수신에 대한 동의							  <a href="https://main.d3qjzrynlab66o.amplifyapp.com/terms/dabang/marketing" target="blank">></a><br><br>
					</div>
				    <!-- div:form-group input-group -->
				    <div class="form-group">
				        <a href="signUp2"><input type="submit" onsubmit="formSubmit()" class="btn btn-primary btn-block" value="다음"></a> </input>
				    </div>
				</form>
			</article>
			<!-- article:card-body mx-auto -->
		</div> 
		<!-- div:card bg-light -->
	</div> 
	<!-- div:container -->
	<br><br>
	
	<script src="../resources/signUp/js/signUp.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</body>
</html>