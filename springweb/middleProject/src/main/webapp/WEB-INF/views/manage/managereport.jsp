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


<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href="../resources/ProductDetail/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../resources/ProductDetail/css/shop-item.css" rel="stylesheet">

</head>

<!-- Navigation -->
<%@include file="/WEB-INF/views/common/nav.jsp"%>
<body>
<form class="manager_declaration">
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h2 class="my-4">관리자 페이지</h2>
				<div class="list-group">
					<a href="managerPage" class="list-group-item">뉴스관리</a>
					<a href="manageReservation" class="list-group-item">회원관리</a>
					<a href="managereport" class="list-group-item active">신고</a>
					<!--  <a href="managerQnA" class="list-group-item">QnA</a> -->
				
				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>
			
			<div class="col-lg-9">
				<div class="table-responsive">
				<br/><br/><br/><br/>
					<table class="table table-bordered table-hover">
					
						<thead>
							<tr>
								<th>신고번호</th>
								<th>매물번호</th>
								<th>회원ID</th>
								<th>신고내용</th>
								<th>중개인ID</th>
								<th>수락</th>
								<th>반려</th>
							</tr>
						</thead>
						<tbody>
							<!-- 여기에 매물 행을 동적으로 추가할 수 있습니다. -->
						<c:forEach var="declaration" items="${declarationList}">
							<tr>
								<td>${declaration.declaration_num}</td>
								<td>${declaration.property_id }</td>
								<td>${declaration.user_id}</td>
								<td>${declaration.declaration_contents}</td>
								<td>${declaration.agent_id}</td>
								<td><button class="btn btn-success btn btn_declarationDelete_property">수락</button></td>
								<td><button class="btn btn-danger btn_declarationDelete">반려</button></td>
							</tr>
						</c:forEach>
							
							<!-- 추가적인 매물 행들을 여기에 추가할 수 있습니다. -->
						</tbody>
					</table>
				</div>
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:forEach begin="1" end="${totalPages}" var="i">
							<li class="page-item ${currentPage == i ? 'active' : ''}"><a class="page-link"
								href="?page=${i}&size=${size}">${i}</a></li>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</form>
	<!-- /.container -->
	<!-- Footer -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="../resources/ProductDetail/vendor/jquery/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="../resources/myPage/js/basket.js"></script>
	<script src="../resources/ProductDetail/js/order.js"></script>
	<script src="../resources/nav/js/nav.js"></script>

	<script
		src="../resources/ProductDetail/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/ProductDetail/js/report.js"></script>
	
</body>

</html>