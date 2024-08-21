<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title></title>
<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath() %>/resources/myPage/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath() %>/resources/common/css/shop-homepage.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/common/css/common.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h1 class="my-4">마이페이지</h1>
				<div class="list-group">
					<a href="myInfo" class="list-group-item">내정보</a> <a
						href="qnaAdmin" class="list-group-item">신고내역</a> <a
						href="reservAdmin" class="list-group-item active">예약관리</a>

				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>





			<div class="col-lg-9">
				<div class="table-responsive">
					<br />
					<br />
					<table class="table table-bordered table-hover">

						<thead>
							<h4 class="card-title mt-3 text-center">
								<strong>예약관리</strong>
							</h4>
							<!-- 추가적인 매물 행들을 여기에 추가할 수 있습니다.(임의로 만든 테이블) -->
							<tr>
								<th>예약No.</th>
								<th>예약시간</th>
								<th>주소</th>
								<th>중개인</th>
								<th>예약결과</th>
								<th>취소하기</th>

							</tr>
						</thead>
						<tbody>


							<c:forEach items="${reservationSelect}" var="reservationSelect">
								<tr>
									<td>${reservationSelect.reservation_id }</td>
									<td>${reservationSelect.reservation_date}<br/>${reservationSelect.reservation_time}</td>
									<td><a href="/middleTest/propertydetails?property_id=${reservationSelect.property_id }">${reservationSelect.addr}</a></td>
									<td>${reservationSelect.agent_id}</td>			
									<td>${reservationSelect.status}</td>
									<td><button class="btn btn-danger delete">취소</button></td>
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
                        <c:forEach var="i" begin="1" end="${totalPages / pageSize + (totalPages % pageSize == 0 ? 0 : 1)}">
                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                <a class="page-link" href="?page=${i}&size=${pageSize}">${i}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${currentPage * pageSize < totalPages}">
                            <li class="page-item">
                                <a class="page-link" href="?page=${currentPage + 1}&size=${pageSize}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath() %>/resources/myPage/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/myPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/nav/js/nav.js"></script>
	<script type="text/javascript">
		$(".delete").click(function(){
			var $button = $(this); // 클릭된 버튼을 jQuery 객체로 저장
		    var reservation_id = $button.closest("tr").find("td:first").text();
			
			
			$.ajax({
				type 	: "get"
				,url 	: "reservationDelete"
				,data	: {"reservation_id" : reservation_id}
				,success : function(result){
					if (result === "1"){
		                alert("취소 완료");
		                $button.closest("tr").remove();  // 클릭된 버튼의 부모 tr 요소를 삭제
		            } else if (result === null){
		                alert("취소 실패");
		            }
				}
				,error:function(err){
					console.log(err);
				}
				
			});
			
		});
	</script>
</body>
</html>