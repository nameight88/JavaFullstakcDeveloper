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
<link href="../resources/ProductDetail/css/shop-item.css" rel="stylesheet">
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
					<a href="agentInfo" class="list-group-item">내정보</a>
					<a href="agentPage" class="list-group-item">매물등록</a>
					<a href="agentManagement" class="list-group-item active">매물관리</a> 
					<a href="agentReservation" class="list-group-item">예약관리</a>
				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>
			<br /> <br /> <br /> <br />
			<div class="col-lg-9">
				<div class="table-responsive">
					<input type="hidden" id="agent_id" name="agent_id" value="${sessionScope.agent }"> 
					<br />
					<br />
					<h4 class="card-title mt-3 text-center">
						<strong>매물 관리</strong>
					</h4>
					<table class="table table-bordered table-hover">

						<thead>
							<tr>
								<th>매물 번호</th>
								<th>거래 유형</th>
								<th>종류</th>
								<th>주소</th>
								<th>등록일</th>
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<!-- 추가적인 매물 행들을 여기에 추가할 수 있습니다. -->
							
							<!-- 채은 추가 -->
							<c:forEach items="${propertyList}" var="propertyList">
								<tr>
									<td>${propertyList.property_id }</td>
									<td>${propertyList.property_cate }</td>
									<td>${propertyList.property_type }</td>
									<td>${propertyList.property_addr }</td>
									<td>${propertyList.reg_date }</td>
									<td><button name="update" class="btn btn-success">수정</button></td>
									<td><button name="delte" class="btn btn-danger">삭제</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center">
                        <c:if test="${currentPage > 1}">
                            <li class="page-item">
                                <a class="page-link" href="?page=${currentPage - 1}&size=${pageSize}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${totalAgentProperty / pageSize + (totalAgentProperty % pageSize == 0 ? 0 : 1)}">
                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                <a class="page-link" href="?page=${i}&size=${pageSize}">${i}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${currentPage * pageSize < totalAgentProperty}">
                            <li class="page-item">
                                <a class="page-link" href="?page=${currentPage + 1}&size=${pageSize}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
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
	<script src="../resources/agent/js/agentupdate.js"></script>
	

	<script
		src="../resources/ProductDetail/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>