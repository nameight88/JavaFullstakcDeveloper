<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="../resources/ProductDetail/js/reply.js"></script>

<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href="../resources/ProductDetail/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../resources/ProductDetail/css/shop-item.css"
	rel="stylesheet">
<link href="../resources/agent/css/agent.css" rel="stylesheet">

</head>

<!-- Navigation -->
<%@include file="/WEB-INF/views/common/nav.jsp"%>
<body>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h1 class="my-4">중개인페이지</h1>
				<div class="list-group">
					<a href="agentInfo" class="list-group-item active">내정보</a> <a
						href="agentPage" class="list-group-item">매물등록</a> <a
						href="agentManagement" class="list-group-item">매물관리</a> <a
						href="agentReservation" class="list-group-item">예약관리</a>

				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>
			<br /> <br />
			<div class="col-lg-9">
				<div class="table-responsive">
					<br /><br />
					<table class="table">
						<thead>
						</thead>
						<tbody>
						
							<h4 class="card-title mt-3 text-center">
								<strong>내정보</strong>
							</h4>
							
							<form action="agentInfoUpdate" method="post">
								<!-- submit.php는 제출 시 데이터를 처리하는 서버 측 스크립트 파일입니다. -->
								<input type="hidden" id="agent_id" name="agent_id" value="${agentInfo.agent_id }">
								<tr>
									<td>이미지</td>
									<td><img id="agent-image" src="../resources/agentImg/${agentInfo.agent_realfname}" alt="중개인 이미지" width="100px" height="100px"></td>
								</tr>
								<tr>
									<td>ID</td>
									<td>${agentInfo.agent_id }</td>
								</tr>

								<tr>
									<td>이름</td>
									<td>${agentInfo.agent_name }</td>
								</tr>

								<tr>
									<td>연락처</td>
									<td>${agentInfo.agent_phone }</td>
								</tr>

								<tr>
									<td>이메일</td>
									<td>${agentInfo.agent_email }</td>
								</tr>
								<tr>
									<td>소속</td>
									<td>${agentInfo.agency }</td>
								</tr>
								<tr>
									<td>면허번호</td>
									<td>${agentInfo.license_num }</td>
								</tr>
								<tr>
									<td colspan="2" class="text-center">
										<button type="submit" class="btn btn-primary">수정하기</button>
										<button class="btn btn-danger delete">회원탈퇴</button>
										
									</td>
								</tr>
							</form>
							
						</tbody>
					</table>
					
				</div>
			</div>

			<br /> <br />
		</div>
	</div>


	<!-- /.container -->
	<!-- Footer -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="../resources/ProductDetail/vendor/jquery/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="../resources/myPage/js/basket.js"></script>
	<script src="../resources/ProductDetail/js/order.js"></script>

	<!-- 채은 추가 -->
	<script src="../resources/nav/js/nav.js"></script>


	<script
		src="../resources/ProductDetail/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
	$(".delete").click(function(){
		 event.preventDefault();
		//alert("ii");
		var agent_id = $("#agent_id").val();
		
		/* if(confirm(id+"님 회원 탈퇴 하시겠습니까?")){
			location.href = "agentInfoDelete?agent_id=" + agent_id;
		} */
		
		alert(agent_id+"님 회원 탈퇴 하겠습니까??");
		location.href = "agentInfoDelete?agent_id=" + agent_id;
		
	})
	
	</script>
</body>

</html>