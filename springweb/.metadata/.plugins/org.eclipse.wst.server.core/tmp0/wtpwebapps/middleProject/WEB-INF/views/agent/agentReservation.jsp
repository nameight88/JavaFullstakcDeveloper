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
<!-- // 0518 기진 : 중개인페이지 - 예약관리 ---------------------------------------------------------------------- -->
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h1 class="my-4">중개인페이지</h1>
				<div class="list-group">
					<a href="agentInfo" class="list-group-item">내정보</a>
					<a href="agentPage" class="list-group-item">매물등록</a>
					<a href="agentManagement" class="list-group-item">매물관리</a> 
					<a href="agentReservation" class="list-group-item active">예약관리</a>
				
				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>
			<br /> <br /> <br /> <br />
			<div class="col-lg-9">
			
				<div class="table-responsive" name="reservationList">
					<br />
					<br />
					<h4 class="card-title mt-3 text-center">
						<strong>예약 관리</strong>
					</h4>
					<table id="reservationList" class="table table-bordered table-hover">
					
						<thead>
							<tr>
								<th>예약No.</th>
								<th>종류</th>
								<th>주소</th>
								<th>회원ID</th>
								<th>예약날짜</th>
								<th>예약</th>
								<th>노쇼</th>
								
							</tr>
						</thead>
						<tbody>
							<!-- 추가적인 매물 행들을 여기에 추가할 수 있습니다. -->
							<c:forEach var="reservationList" items="${reservationList}">
							<tr>
								<input type="hidden" id="reservation_id" name="reservation_id" value="${reservationList.reservation_id }">
								<td>${reservationList.reservation_id}</td>
								<td>${reservationList.type}</td>
								<td><a href="/middleTest/propertydetails?property_id=${reservationList.property_id }">${reservationList.addr}</a></td>
								<td>${reservationList.user_id}</td>
								<td>${reservationList.reservation_date}<br/>${reservationList.reservation_time}</td>
								
								<td>
								<c:choose>
											<c:when test="${reservationList.status == '예약중'}">
												<button class="btn btn-success regsuccess">승인</button>
											</c:when>
											<c:when test="${reservationList.status == '예약승인'}">
												<button class="btn btn-danger regCancel">취소</button>
											</c:when>
										</c:choose>
								</td>
								<td><c:choose>
											<c:when test="${reservationList.noshow == true}">
												<button class="btn btn-success noshowCancel">취소</button>
											</c:when>
											<c:otherwise>
												<button class="btn btn-danger noshow">노쇼</button>
											</c:otherwise>
										</c:choose>
								</td>
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
	<script src="../resources/nav/js/nav.js"></script>

	<script
		src="../resources/ProductDetail/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		
	<script type="text/javascript">
	$(document).on("click", ".noshow", function() {
		var $button = $(this);
		 var reservation_id = $(this).closest("tr").find("input:first").val();
		 var user_id = $(this).closest("tr").find("td").eq(3).text();
		 
		 
		 $.ajax({
				type 	: "get"
				,url 	: "noshowInsert"
				,data	: {"reservation_id" : reservation_id, "user_id" : user_id}
				,success : function(result){
					
					if (result === "1"){
		                //alert("노쇼등록");
		               	$button.removeClass("btn-danger noshow").addClass("btn-success noshowCancel").text("취소");
		                
		            } else if (result === ""){
		                //alert("취소 실패");
		                
		            }
				}
				,error:function(err){
					console.log(err);
				}
				
			});
	});
	
	$(document).on("click", ".noshowCancel", function() {
		var $button = $(this);
	    var reservation_id = $button.closest("tr").find("#reservation_id").val();
	    var user_id = $(this).closest("tr").find("td").eq(3).text();
	    
	    
	    $.ajax({
			type 	: "get"
			,url 	: "noshowCancel"
			,data	: {"reservation_id" : reservation_id, "user_id" : user_id}
			,success : function(result){
				
				if (result === "1"){
	                //alert("노쇼취소");
	               $button.removeClass("btn-danger noshowCancel").addClass("btn-danger noshow").text("노쇼");
	                
	            } else if (result === ""){
	                //alert("취소 실패");
	                
	            }
			}
			,error:function(err){
				
				console.log(err);
			}
			
		});
	    
		
	});
	

	$(document).on("click", ".regsuccess", function() {
		var $button = $(this);
		var reservation_id = $(this).closest("tr").find("input:first").val();
		var user_id = $(this).closest("tr").find("td").eq(3).text();
		
		
		$.ajax({
			type 	: "get"
			,url 	: "regsuccess"
			,data	: {"reservation_id" : reservation_id, "user_id" : user_id}
			,success : function(result){
				
				if (result === "1"){
	                //alert("예약승인");
	               $button.removeClass("btn-success regsuccess").addClass("btn-danger regCancel").text("취소");
	                
	            } else if (result === ""){
	                //alert("예약승인 실패");
	                
	            }
			}
			,error:function(err){
				
				console.log(err);
			}
			
		});
		
		
		
	});
	
	$(document).on("click", ".regCancel", function() {
		var $button = $(this);
		var reservation_id = $(this).closest("tr").find("input:first").val();
		var user_id = $(this).closest("tr").find("td").eq(3).text();
		
		
		$.ajax({
			type 	: "get"
			,url 	: "regCancel"
			,data	: {"reservation_id" : reservation_id, "user_id" : user_id}
			,success : function(result){
				
				if (result === "1"){
	                //alert("예약취소");
	               $button.removeClass("btn-danger regCancel").addClass("btn-success regsuccess").text("승인");
	                
	            } else if (result === ""){
	                //alert("예약취소 실패");
	                
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