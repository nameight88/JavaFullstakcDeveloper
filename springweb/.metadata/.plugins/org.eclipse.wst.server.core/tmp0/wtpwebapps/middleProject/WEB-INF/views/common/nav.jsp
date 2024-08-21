<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
	      	<a class="navbar-brand" href="/middleTest/mainPage">부동산</a>
	      	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        	<span class="navbar-toggler-icon"></span>
	      	</button>
	      	<div class="collapse navbar-collapse" id="navbarResponsive">
	        	<ul class="navbar-nav ml-auto">
	          		<li class="nav-item active">
	            		<a class="nav-link" href="/middleTest/mainPage">홈<span class="sr-only">(current)</span></a>
	          		</li>

	          		<li class="nav-item">
	            		<a class="nav-link" href="/middleTest/customerpage/interestItem">관심매물</a>
	          		</li>
	          		<li class="nav-item">
	            		<a class="nav-link" href="/middleTest/map">지도</a>
	          		</li>
	          		
	          		
	          	
	          		<%	if(session.getAttribute("user")!=null){ %>
			          	<li class="nav-item">
			            	<a class="nav-link" href="/middleTest/customerpage/myInfo">마이페이지</a>
			          	</li>
			          	<li class="nav-item">
			            	<a class="nav-link" href="/middleTest/logout">로그아웃</a>
			          	</li>
			          	
			          	<li class="nav-message">
		            		<span style="font-weight: bold; color: orange; padding: 5px; margin-top:2px; display:inline-block; " >${sessionScope.user}님</span><span style=" font-weight: bold; color: white;"> 어서오세요.</span>
		          		</li>
			 		<%}else	if(session.getAttribute("admin")!=null){ %>
	          		<!-- 관리자만 보이게 -->
	          		<li class="nav-item">
	            		<a class="nav-link" href="/middleTest/manage/managerPage">관리자페이지</a>
	          		</li>
	          		<li class="nav-item">
			            <a class="nav-link" href="/middleTest/logout">로그아웃</a>
			        </li>
	          		<li class="nav-message">
		            	<span style="font-weight: bold; color: orange; padding: 5px; margin-top:2px; display:inline-block; " >${sessionScope.admin}님</span><span style=" font-weight: bold; color: white;">어서오세요.</span>
		          	</li>
			 		<%} else if(session.getAttribute("agent")!=null){ %>
			 		<li class="nav-item">
	            		<a class="nav-link" href="/middleTest/agent/agentInfo">중개인페이지</a>
	          		</li>
			 		<li class="nav-item">
			            	<a class="nav-link" href="/middleTest/logout">로그아웃</a>
			          	</li>
	          		
	          		<li class="nav-message">
		            	<span style="font-weight: bold; color: orange; padding: 5px; margin-top:2px; display:inline-block; " >${sessionScope.agent}님</span><span style=" font-weight: bold; color: white;">어서오세요.</span>
		          	</li>
			 		<% } else { %>
			 		  	<li class="nav-item">
			            	<a class="nav-link" href="/middleTest/login">로그인</a>
			          	</li>
			 		<% } %>
	        	</ul>
	      	</div>
    	</div>
  	</nav>

