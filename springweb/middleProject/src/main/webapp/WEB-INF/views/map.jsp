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
<title>부동산 Map Page</title>
<!-- Bootstrap core CSS -->
<link href="resources/mainPage/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/mainPage/css/heroic-features.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Kakao Maps SDK -->
<script
	src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=e4d5069dc9a490e0b400e0844235a47e&libraries=services"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


</head>
<!-- Navigation -->
<%@include file="/WEB-INF/views/common/nav.jsp"%>
<body>
	<!-- Page Content -->
	<div class="container">
		<br>

		<!-- Search Form -->
		<form action="searchMap" method="get">
			<div class="form-row">
				<div class="form-group col-md-3">
					<select name="property_type" id="property_type"
						class="form-control">
						<option ${map.property_type eq '전체' ? 'selected' : ''}>전체</option>
						<option ${map.property_type eq '원룸' ? 'selected' : ''}>원룸</option>
						<option ${map.property_type eq '투룸' ? 'selected' : ''}>투룸</option>
						<option ${map.property_type eq '오피스텔' ? 'selected' : ''}>오피스텔</option>
						<option ${map.property_type eq '아파트' ? 'selected' : ''}>아파트</option>
						<option ${map.property_type eq '빌라' ? 'selected' : ''}>빌라</option>
						<option ${map.property_type eq '주택' ? 'selected' : ''}>주택</option>
						<option ${map.property_type eq '사무실' ? 'selected' : ''}>사무실</option>
						<option ${map.property_type eq '상가' ? 'selected' : ''}>상가</option>


					</select>
				</div>
				<div class="form-group col-md-3">
					<select name="property_cate" id="property_cate"
						class="form-control">
						<option ${map.property_cate eq '전체' ? 'selected' : ''}>전체</option>
						<option ${map.property_cate eq '월세' ? 'selected' : ''}>월세</option>
						<option ${map.property_cate eq '전세' ? 'selected' : ''}>전세</option>
						<option ${map.property_cate eq '매매' ? 'selected' : ''}>매매</option>
					</select>
				</div>
				<div class="form-group col-md-4">
					<input type="text" class="form-control" placeholder="지역 또는 동 입력"
						name="searchText" id="searchText" value="${map.searchText }">
				</div>
				<div class="form-group col-md-2">
					<!--  <input type="submit" class="btn btn-primary" value="검색"> -->
					<input type="submit" id="btn" class="btn btn-primary" value="검색">
				</div>
			</div>
		</form>

		<!-- Map and Result List -->
		<div class="row">
			<!-- Map Container -->
			<div class="col-md-7">
				<div id="map" style="height: 700px"></div>
			</div>

			<!-- Result List Container -->
			<!--  다방 -->
			<div class="col-md-5">
				<div class="result-list">

					<ul class="list-unstyled bg-ligh">
						<c:forEach items="${propertyList}" var="property">
							<li class="media mb-3"><input type="hidden" id="property_id"
								name="property_id" value="${property.property_id }"> <img
								class="mr-3 property-image"
								src="resources/propertyImg/${property.property_realfname}"
								alt="매물 이미지" style="width: 200px; height: 200px">
								<div class="media-body">
									<c:choose>
										<c:when test="${property.property_cate == '월세'}">
											<h5>${property.property_cate}&nbsp;
												${property.deposit}/${property.price}</h5>
										</c:when>
										<c:otherwise>
											<h5>${property.property_cate}&nbsp;${property.price}</h5><small>[단위:만원]</small>
											
										</c:otherwise>
									</c:choose>

									<p class="property-type">${property.property_type}</p>
									<p class="property-size">${property.property_size}평</p>
									<p class="description">${property.description}</p>
									<p class="property_addr">${property.property_addr}</p>

								</div></li>
						</c:forEach>
					</ul>
					<div class="container">
						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center">
								<c:if test="${page > 1}">
									<li class="page-item"><a class="page-link"
										href="?page=${page - 1}&property_type=${map.property_type}&property_cate=${map.property_cate}&searchText=${map.searchText}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach var="i" begin="1"
									end="${totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1)}">
									<li class="page-item ${i == page ? 'active' : ''}"><a
										class="page-link"
										href="?page=${i}&property_type=${map.property_type}&property_cate=${map.property_cate}&searchText=${map.searchText}">${i}</a>
									</li>
								</c:forEach>
								<c:if test="${page * pageSize < totalCount}">
									<li class="page-item"><a class="page-link"
										href="?page=${page + 1}&property_type=${map.property_type}&property_cate=${map.property_cate}&searchText=${map.searchText}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>

		</div>

		<!-- End Result List Container -->

	</div>
	<br />


	<!-- Bootstrap core JavaScript -->
	<script src="resources/mainPage/vendor/jquery/jquery.min.js"></script>
	<script
		src="resources/mainPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="resources/map/js/map.js"></script>
	<script src="resources/nav/js/nav.js"></script>
	<script type="text/javascript">
		// 클릭한 li의 요소의 id값을 가지고 상세매물 페이지로 이동
		$(".media").click(function() {
			var propertyId = $(this).find("#property_id").val();
			

			location.href = "propertydetails?property_id=" + propertyId;

		});
	</script>

</body>
<!-- Footer -->
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</html>

