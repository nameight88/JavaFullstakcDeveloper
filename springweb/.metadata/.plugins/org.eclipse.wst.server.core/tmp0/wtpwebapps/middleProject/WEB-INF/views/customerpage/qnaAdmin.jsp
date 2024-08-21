<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	<meta name="author" content="">
  	<title></title>
  	<!-- Bootstrap core CSS -->
  	<link href="<%=request.getContextPath() %>/resources/myPage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  	<!-- Custom styles for this template -->
  	<link href="<%=request.getContextPath() %>/resources/common/css/shop-homepage.css" rel="stylesheet">
  	<link href="<%=request.getContextPath() %>/resources/common/css/common.css" rel="stylesheet">
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
						href="qnaAdmin" class="list-group-item active">신고내역</a> <a
						href="reservAdmin" class="list-group-item">예약관리</a>

				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>
      		
			<div class="col-lg-9">
				<div class="table-responsive">
				<br/><br/>
					<table class="table table-bordered table-hover">

						<thead>
							<h4 class="card-title mt-3 text-center">
								<strong>신고내역</strong>
							</h4>
							<tr>
								<th>신고번호</th>
								<th>매물번호</th>
								<th>중개인아이디</th>
								<th>신고내용</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<!-- 추가적인 매물 행들을 여기에 추가할 수 있습니다. -->
							<c:forEach items="${userDeclarationList}" var="declarationList">
								<tr>
									<th>${declarationList.declaration_num }</th>
									<th>${declarationList.property_id }</th>
									<th>${declarationList.agent_id }</th>
									<th>${declarationList.declaration_contents }</th>
									<th><button name="" class="btn btn-danger delete">삭제</button></th>
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
				<!-- 
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:forEach begin="1" end="${totalPages}" var="i">
							<li class="page-item ${currentPage == i ? 'active' : ''}"><a class="page-link"
								href="?page=${i}&size=${size}">${i}</a></li>
						</c:forEach>
					</ul>
				</nav>
				 -->
			</div>
		</div>
	</div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript -->
  	<script src="<%=request.getContextPath() %>/resources/myPage/vendor/jquery/jquery.min.js"></script>
  	<script src="<%=request.getContextPath() %>/resources/myPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/nav/js/nav.js"></script>
	<script type="text/javascript">
		$(".delete").click(function(){
			var $button = $(this); // 클릭된 버튼을 jQuery 객체로 저장
		    var declaration_num = $button.closest("tr").find("th:first").text();
			
			$.ajax({
				type 	: "get"
				,url 	: "declarationDelete"
				,data	: {"declaration_num" : declaration_num}
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
</body>
</html>