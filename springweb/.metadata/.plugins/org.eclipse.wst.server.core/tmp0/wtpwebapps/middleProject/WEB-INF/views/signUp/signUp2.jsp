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
	<!--<link rel="icon" type="image/png" href="icon.png">  여기에 사용하려는 아이콘 이미지 경로를 지정합니다. -->
	<title>고객가입 페이지</title>
</head>
<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
<body>
   <div class="container">
      <p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
      <hr>
      <div class="card bg-light" style=" width: 75%; margin-left: 180px; margin-top: 7%;">
         <article class="card-body mx-auto" style="max-width: 400px;">
             <h4 class="card-title mt-3 text-center">Create Account</h4>
             <br>  
             
             <!-- 회원가입 form!! ############################################################## -->
            <form class="signupForm" action="transfer.do" enctype="multipart/form-data">
               <div class="form-desc card-title mt-3 text-center"><h6><b>회원정보를 입력해주세요</b></h6></div><hr>
               
               <!-- div:사용자 아이디 -->
               <div class="form-desc">아이디</div>
               <div><span class="resultIdMessage" ></span></div>
               <div class="form-group input-group">
                  <div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-id-badge"></i> </span></div>
                   <input name="user_id" class="form-control" placeholder="2~10자 영문,숫자 조합" pattern="[A-Za-z0-9]{2,10}" type="text" required="required">
                   <input type="checkbox" name="idCheckBox" class="id-checkbox" value="id 중복확인" style="display: none;">
                   <button id='idCheck' class="idCheck" type="button" >중복확인</button>
               </div>
               
               <!-- div:사용자 비밀번호 -->
               <div class="form-desc">비밀번호</div>
               <div class="form-group input-group">
                   <div class="input-group-prepend">
                     <span class="input-group-text"><i class="fa fa-tty"></i></span>
                  </div>
                   <input name="user_password" class="form-control" placeholder="2~10자 영문,숫자 조합" pattern="[A-Za-z0-9]{2,10}" type="password" value="" required="required">
               </div>
               
               <!-- div:사용자 비밀번호 확인 -->
               <div class="form-desc">비밀번호 확인</div>
               <div class="form-group input-group">
                   <div class="input-group-prepend">
                     <span class="input-group-text"> <i class="fa fa-tty"></i> </span>
                  </div>
                   <input name="user_passwordChk" class="form-control" placeholder="입력한 비밀번호와 동일하게 작성"  type="password" value="" required="required">
               </div>
               <div><span class="resultPassMessage" ></span></div>
               
               <!-- div:사용자 이름 -->
               <div class="form-desc">이름</div>
               <div class="form-group input-group">
                   <div class="input-group-prepend">
                     <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                  </div>
                   <input name="user_name" class="form-control" placeholder="국문 성명 입력" pattern="[가-힣]{2,10}" type="text" required="required">
               </div>
               
               <!-- div:사용자 이메일  -->
               <div class="form-desc">이메일</div>
               <div><span class="resultMessage" ></span></div>
               <div class="form-group input-group">
                   <div class="input-group-prepend"><span class="input-group-text"> <i class="fa fa-envelope"></i> </span></div>
                   <input name="user_email" class="form-control" placeholder="example01@ict.com" type="email" required="required">
               </div>
               
               
               
               <!-- div:사용자 전화번호 입력 -->
               <div class="form-desc">전화번호(- 기호 포함)</div>
               <div class="form-group input-group">
                   <div class="input-group-prepend">
                     <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                  </div>
                   <input name="user_phone" class="form-control" placeholder="010-0000-0000" type="text" required="required">
               </div>
               <div class="addinput">

               </div>
                <!-- div:form-group input-group -->
                <div class="form-group">
                    <input type="submit" class="btn btn-primary btn-block" value="계정 만들기" ></input>
                </div><br>
                <!-- div:form-group -->      
                <p class="text-center" style="color: gray;"><small>계정이 이미 존재하나요?</small>  <a href="/middleTest/login">Login</a></p>                                                                 
            </form>
         </article>
         <!-- article:card-body mx-auto -->
      </div> 
      <!-- div:card bg-light -->
   </div> 
   <!-- div:container -->
   <br><br>
   
   
   <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
   <script src="../resources/signUp/js/signUp.js"></script>
   <script src="../resources/common/js/common_submit.js"></script>
   <script src="../resources/common/js/addressAPI.js"></script>
</body>
</html>