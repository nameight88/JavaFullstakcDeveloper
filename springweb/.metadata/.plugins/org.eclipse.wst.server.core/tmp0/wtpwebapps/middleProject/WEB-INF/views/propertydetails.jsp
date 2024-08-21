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
<!-- 24/05/16 - ㄱㅈ - 중개인 연결 -->
<link href="/middleTest/resources/ProductDetail/css/connectAgent.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Kakao Maps SDK -->
<script
	src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=e4d5069dc9a490e0b400e0844235a47e&libraries=services,clusterer"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


</head>
<!-- Navigation -->
<%@include file="/WEB-INF/views/common/nav.jsp"%>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<br>
				<div class="card bg-light">
					<div class="card-body">
						<div class="row">
							<div class="col-md-9">
								<h3 class="card-title">${property.property_title}</h3>
							</div>
							<div class="col-md-3 d-flex justify-content-end">
								<svg class="watchlist" xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 24 24" width="40" height="40"
									style="${watch ? 'display:none;' : 'display:block;'}">
                    			<path
										d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Zm-3.585,18.4a2.973,2.973,0,0,1-3.83,0C4.947,16.006,2,11.87,2,8.967a4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,11,8.967a1,1,0,0,0,2,0,4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,22,8.967C22,11.87,19.053,16.006,13.915,20.313Z" />
              					</svg>
								<svg class="watchlistDelete" xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 24 24" width="40" height="40"
									style="${watch ? 'display:block;' : 'display:none;'}">
								<path
										d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Z" /></svg>

							</div>

						</div>
						<br />
						<!-- 매물 이미지 슬라이드 -->

						<div id="carouselExampleIndicators" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0"
									class="active"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="resources/propertyImg/${property.property_realfname}"
										alt="..." style="width: 800px; height: 400px">
								</div>
								<div class="carousel-item">
									<img src="http://placehold.it/800x400" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item">
									<img src="http://placehold.it/800x400" class="d-block w-100"
										alt="...">
								</div>
							</div>
							<a class="carousel-control-prev"
								href="#carouselExampleIndicators" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleIndicators" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>



						<!-- 매물 정보 -->

						<div>
							<br />
							<h5 class="card-subtitle mb-2 text-muted">
								매물번호 : <span class="property_id">${property.property_id }</span>
							</h5>
							<br />

							<h5 class="card-subtitle mb-2 text-muted">가격정보</h5>
							<div>
								<table class="table" id="price">
									<tbody>
										<c:choose>
										<c:when test="${property.property_cate == '월세'}">
											<tr>
												<td>${property.property_cate }</td>
												<td>${property.deposit }/${property.price }</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>${property.property_cate }</td>
												<td>${property.price } 만원</td>
											</tr>
										</c:otherwise>
									</c:choose>
										
									</tbody>
								</table>
								<br />

								<h5 class="card-subtitle mb-2 text-muted">상세정보</h5>
								<table class="table" id="info">
									<tbody>
										<tr>
											<td>방종류</td>
											<td class="property_type">${property.property_type }</td>
										</tr>
										<tr>
											<td>면적</td>
											<td class="property_size">${property.property_size }평</td>
										</tr>
										<tr>
											<td>방수</td>
											<td class="bedrooms">${property.bedrooms }개</td>
										</tr>
										<tr>
											<td>욕실 수</td>
											<td class="bathrooms">${property.bathrooms }개</td>
										</tr>
										<tr>
											<td>연식</td>
											<td class="property_year">${property.property_year }</td>
										</tr>
										<tr>
											<td>최초등록일</td>
											<td class="reg_date">${property.reg_date }</td>
										</tr>

										<tr>
											<td>주소</td>
											<td class="property_addr">${property.property_addr }&nbsp;${property.addr_detail }</td>
										</tr>
									</tbody>
								</table>

							</div>
						</div>
						<br />
						<!-- 지도 가져오기 -->
						<h5 class="card-subtitle mb-2 text-muted">매물 위치</h5>
						<div class="col-md-12">
							<div id="map" style="height: 400px"></div>
						</div>

						<!-- 매물 설명 -->
						<div class="mt-3">
							<h5 class="card-subtitle mb-2 text-muted">매물 설명</h5>
							<p class="card-text">${property.description}</p>
						</div>


						<br />
						<h5 class="card-subtitle mb-2 text-muted">옵션</h5>
						<div class="row">
							<c:if test="${option.aircon}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M21.5,0H2.5C1.121,0,0,1.122,0,2.5V11H24V2.5c0-1.378-1.121-2.5-2.5-2.5Zm1.5,10H1V2.5c0-.827,.673-1.5,1.5-1.5H21.5c.827,0,1.5,.673,1.5,1.5v7.5ZM3,6H21v1H3v-1Zm4,7h1v7.5c0,1.93-1.57,3.5-3.5,3.5s-3.5-1.57-3.5-3.5,1.57-3.5,3.5-3.5v1c-1.379,0-2.5,1.122-2.5,2.5s1.121,2.5,2.5,2.5,2.5-1.122,2.5-2.5v-7.5Zm16,7.5c0,1.93-1.57,3.5-3.5,3.5s-3.5-1.57-3.5-3.5v-7.5h1v7.5c0,1.378,1.121,2.5,2.5,2.5s2.5-1.122,2.5-2.5-1.121-2.5-2.5-2.5v-1c1.93,0,3.5,1.57,3.5,3.5Zm-11.5-7.5h1v11h-1V13Z" /></svg>
											<p>에어컨</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.refrigerator}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m19.5,0H4.5c-1.379,0-2.5,1.122-2.5,2.5v21.5h20V2.5c0-1.378-1.121-2.5-2.5-2.5ZM4.5,1h15c.827,0,1.5.673,1.5,1.5v6.5h-4v-4h-1v4H3V2.5c0-.827.673-1.5,1.5-1.5Zm-1.5,22v-13h13v8h1v-8h4v13H3Z" /></svg>
										</span>
										<p>냉장고</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.washing_machine}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m17.5,0H6.5C4.019,0,2,2.019,2,4.5v15c0,2.481,2.019,4.5,4.5,4.5h11c2.481,0,4.5-2.019,4.5-4.5V4.5c0-2.481-2.019-4.5-4.5-4.5Zm3.5,19.5c0,1.93-1.57,3.5-3.5,3.5H6.5c-1.93,0-3.5-1.57-3.5-3.5V4.5c0-1.93,1.57-3.5,3.5-3.5h11c1.93,0,3.5,1.57,3.5,3.5v15ZM6,5c-.552,0-1-.448-1-1s.448-1,1-1,1,.448,1,1-.448,1-1,1Zm3-1c0-.552.448-1,1-1s1,.448,1,1-.448,1-1,1-1-.448-1-1Zm3,4c-3.309,0-6,2.691-6,6s2.691,6,6,6,6-2.691,6-6-2.691-6-6-6Zm0,1c2.684,0,4.865,2.131,4.979,4.788-.313.243-1.038.712-1.979.712-1.326,0-2.709-.907-2.723-.916-.066-.044-1.645-1.084-3.277-1.084-.768,0-1.41.229-1.895.482.472-2.27,2.487-3.982,4.895-3.982Zm0,10c-2.684,0-4.865-2.131-4.979-4.788.313-.243,1.038-.712,1.979-.712,1.326,0,2.709.907,2.723.916.066.044,1.645,1.084,3.277,1.084.768,0,1.41-.229,1.895-.482-.472,2.27-2.487,3.982-4.895,3.982Z" /></svg>
										</span>
										<p>세탁기</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.shower_booth}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m18,15c0,.552-.448,1-1,1s-1-.448-1-1,.448-1,1-1,1,.448,1,1Zm3-5c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm-4,8c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm4-4c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm0,4c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm0,4c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm-4,0c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm-4-4c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm4-8c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm3-3c0,.552.448,1,1,1s1-.448,1-1-.448-1-1-1-1,.448-1,1Zm-7,7c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1Zm0,8c-.552,0-1,.448-1,1s.448,1,1,1,1-.448,1-1-.448-1-1-1ZM21.207,3l-11.207,11.207-1-1V2.686c-.354-.394-1.659-1.686-3.583-1.686-1.333,0-2.417,1.084-2.417,2.417v20.583h-1V3.417c0-1.884,1.533-3.417,3.417-3.417,2.315,0,3.836,1.47,4.311,2h10.48l1,1Zm-1.414,0h-9.793v9.793L19.793,3Z" /></svg>
										</span>
										<p>샤워부스</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.sink}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M12,0C5.383,0,0,5.383,0,12s5.383,12,12,12,12-5.383,12-12S18.617,0,12,0Zm0,23c-6.065,0-11-4.935-11-11S5.935,1,12,1s11,4.935,11,11-4.935,11-11,11Zm8-11c0,4.411-3.589,8-8,8s-8-3.589-8-8S7.589,4,12,4v1c-3.86,0-7,3.141-7,7s3.14,7,7,7,7-3.141,7-7h1Z" /></svg>
										</span>
										<p>싱크대</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.induction}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m23.854,23.146l-6.449-6.449c1.607-1.775,2.596-4.12,2.596-6.697C20,4.486,15.514,0,10,0S0,4.486,0,10s4.486,10,10,10c2.577,0,4.922-.988,6.697-2.596l6.449,6.449c.098.098.226.146.354.146s.256-.049.354-.146c.195-.195.195-.512,0-.707ZM1,10C1,5.038,5.038,1,10,1s9,4.038,9,9-4.038,9-9,9S1,14.962,1,10Zm8-2c-1.103,0-2,.897-2,2s.897,2,2,2,2-.897,2-2-.897-2-2-2Zm0,3c-.551,0-1-.449-1-1s.449-1,1-1,1,.449,1,1-.449,1-1,1Zm4.357-4.309c-.069-.016-.164-.055-.22-.151-1.104-1.907-2.976-2.826-5.007-2.461-2.394.43-4.131,2.587-4.131,5.129v.292c0,3.584,2.916,6.5,6.5,6.5,1.896,0,3.55-1.252,3.849-2.912.063-.351.345-.682.485-.808.73-.654,1.166-1.601,1.166-2.531,0-1.452-1.086-2.71-2.643-3.059Zm.809,4.846c-.11.099-.668.631-.802,1.375-.21,1.171-1.468,2.088-2.864,2.088-3.033,0-5.5-2.467-5.5-5.5v-.292c0-2.024,1.422-3.806,3.308-4.145.228-.041.453-.061.674-.061,1.334,0,2.532.73,3.291,2.039.186.32.494.542.867.625.896.201,1.861.939,1.861,2.083,0,.641-.319,1.325-.834,1.787Z" /></svg>
										</span>
										<p>인덕션</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.fire_alarm}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M24,2.5V11.842c-.315-.385-.652-.748-1-1.093V2.5c0-.827-.673-1.5-1.5-1.5H2.5c-.827,0-1.5,.673-1.5,1.5V23H10.309c.323,.359,.67,.696,1.046,1H0V2.5C0,1.122,1.121,0,2.5,0H21.5c1.379,0,2.5,1.122,2.5,2.5ZM3,4c0,.552,.448,1,1,1s1-.448,1-1-.448-1-1-1-1,.448-1,1Zm4,0c0,.552,.448,1,1,1s1-.448,1-1-.448-1-1-1-1,.448-1,1Zm17,13c0,3.651-3,7.037-7,7.037s-7-3.386-7-7.037c0-2.152,1.314-3.756,2.304-4.775l.561-.578,.27,.759c.259,.732,.677,1.475,.892,1.593,.308-.04,.538-.817,.782-1.638,.344-1.156,.771-2.594,1.814-3.799l.352-.406,.38,.38c.492,.492,1.145,1.013,1.836,1.563,2.143,1.709,4.811,3.836,4.811,6.901Zm-7.468,5.982c.154,.012,.311,.018,.468,.018s.314-.006,.468-.018c.347-.083,.676-.259,.946-.529,.378-.378,.586-.88,.586-1.414s-.208-1.037-.586-1.415l-1.414-1.414-1.414,1.414c-.378,.378-.586,.88-.586,1.415s.208,1.036,.586,1.414c.27,.27,.599,.446,.946,.529Zm6.468-5.982c0-2.583-2.355-4.462-4.435-6.12-.541-.432-1.06-.845-1.51-1.251-.68,.964-1.014,2.089-1.289,3.016-.376,1.264-.7,2.355-1.767,2.355-.646,0-1.159-.766-1.504-1.507-.776,.904-1.496,2.062-1.496,3.507,0,2.34,1.347,4.372,3.306,5.36-.2-.406-.306-.856-.306-1.322,0-.801,.312-1.555,.879-2.122l2.121-2.121,2.121,2.121c.566,.567,.879,1.32,.879,2.122,0,.466-.106,.916-.306,1.322,1.959-.989,3.306-3.02,3.306-5.36Z" /></svg>
										</span>

										<p>화재경보기</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.veranda}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m22.922,7.02L13.471.479c-.878-.641-2.062-.64-2.932-.007L1.078,7.02c-.675.466-1.078,1.234-1.078,2.056v2.925h11.5v12h1v-12h11.5v-2.925c0-.821-.403-1.59-1.078-2.056ZM1,9.075c0-.492.241-.953.646-1.233L10.488,1.723l-3.813,5.219c-.441.603-.675,1.316-.675,2.064v1.994H1v-1.925Zm6,1.925v-1.994c0-.534.167-1.044.481-1.475l4.019-5.5v8.969h-4.5ZM12.5,2.028l4.209,5.739c.19.26.291.567.291.888v2.346h-4.5V2.028Zm10.5,8.972h-5v-2.346c0-.534-.167-1.045-.483-1.479l-3.994-5.446,8.831,6.112c.405.28.646.741.646,1.233v1.925ZM6,20.5v3.5h-1v-3.5c0-.275-.225-.5-.5-.5H1v4H0v-9h1v4h3.5c.827,0,1.5.673,1.5,1.5Zm17-5.5h1v9h-1v-4h-3.5c-.275,0-.5.225-.5.5v3.5h-1v-3.5c0-.827.673-1.5,1.5-1.5h3.5v-4Z" /></svg>
										</span>
										<p>베란다</p>
									</div>
								</div>
							</c:if>
							<c:if test="${option.tub}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M12.344,12l-3.065-3.722c-.667-.81-1.649-1.274-2.698-1.275l-2.079-.002h-.002c-.667,0-1.295,.26-1.767,.731-.473,.472-.733,1.1-.733,1.769v2.5H0v9.5c0,1.378,1.122,2.5,2.5,2.5H21.5c1.378,0,2.5-1.122,2.5-2.5V12H12.344Zm-3.344,1v10h-3V13h3Zm1,0h4v10h-4V13Zm5,0h3v10h-3V13ZM3,9.5c0-.401,.156-.778,.44-1.061s.66-.439,1.061-.439h.001l2.079,.002c.749,0,1.451,.333,1.927,.911l2.542,3.086H3v-2.5ZM1,21.5V13H5v10H2.5c-.827,0-1.5-.673-1.5-1.5Zm22,0c0,.827-.673,1.5-1.5,1.5h-2.5V13h4v8.5ZM5.5,5c1.378,0,2.5-1.122,2.5-2.5S6.878,0,5.5,0,3,1.122,3,2.5s1.122,2.5,2.5,2.5Zm0-4c.827,0,1.5,.673,1.5,1.5s-.673,1.5-1.5,1.5-1.5-.673-1.5-1.5,.673-1.5,1.5-1.5Zm11.646,3.354c-.739-.739-1.146-1.722-1.146-2.768V0h1V1.586c0,.778,.303,1.51,.854,2.061,.739,.739,1.146,1.722,1.146,2.768v1.585h-1v-1.585c0-.779-.303-1.511-.854-2.061Zm4.054-.953c-.793-.786-1.201-1.769-1.201-2.814V0h1V.586c0,.778,.303,1.51,.854,2.061,.733,.541,1.125,1.459,1.146,2.76v1.594h-1v-1.585c-.016-.962-.277-1.624-.799-2.014Z" /></svg>
										</span>

										<p>욕조</p>
									</div>
								</div>
							</c:if>


						</div>


						<br />
						<h5 class="card-subtitle mb-2 text-muted">보안</h5>
						<div class="row">
							<c:if test="${security.storage_box}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M21.5,24c-1.379,0-2.5-1.122-2.5-2.5V13.5c0-.827-.673-1.5-1.5-1.5H6.5c-.827,0-1.5,.673-1.5,1.5v8c0,1.378-1.121,2.5-2.5,2.5s-2.5-1.122-2.5-2.5V9.561c0-1.499,.741-2.893,1.983-3.73L9.483,.77c1.527-1.031,3.504-1.032,5.033,0l7.5,5.061c1.242,.837,1.983,2.232,1.983,3.73v11.939c0,1.378-1.121,2.5-2.5,2.5ZM6.5,11h11c1.379,0,2.5,1.122,2.5,2.5v8c0,.827,.673,1.5,1.5,1.5s1.5-.673,1.5-1.5V9.561c0-1.166-.576-2.25-1.542-2.901L13.958,1.599c-1.189-.803-2.727-.803-3.916,0L2.542,6.66c-.966,.651-1.542,1.736-1.542,2.901v11.939c0,.827,.673,1.5,1.5,1.5s1.5-.673,1.5-1.5V13.5c0-1.378,1.121-2.5,2.5-2.5Zm3.3,13h-1.6c-.662,0-1.2-.539-1.2-1.2v-1.6c0-.662,.538-1.2,1.2-1.2h1.6c.662,0,1.2,.539,1.2,1.2v1.6c0,.662-.538,1.2-1.2,1.2Zm-1.6-3c-.11,0-.2,.09-.2,.2v1.6c0,.11,.09,.2,.2,.2h1.6c.11,0,.2-.09,.2-.2v-1.6c0-.11-.09-.2-.2-.2h-1.6Zm1.6-3h-1.6c-.662,0-1.2-.539-1.2-1.2v-1.6c0-.662,.538-1.2,1.2-1.2h1.6c.662,0,1.2,.539,1.2,1.2v1.6c0,.662-.538,1.2-1.2,1.2Zm-1.6-3c-.11,0-.2,.09-.2,.2v1.6c0,.11,.09,.2,.2,.2h1.6c.11,0,.2-.09,.2-.2v-1.6c0-.11-.09-.2-.2-.2h-1.6Zm7.6,9h-1.6c-.662,0-1.2-.539-1.2-1.2v-1.6c0-.662,.538-1.2,1.2-1.2h1.6c.662,0,1.2,.539,1.2,1.2v1.6c0,.662-.538,1.2-1.2,1.2Zm-1.6-3c-.11,0-.2,.09-.2,.2v1.6c0,.11,.09,.2,.2,.2h1.6c.11,0,.2-.09,.2-.2v-1.6c0-.11-.09-.2-.2-.2h-1.6Z" /></svg>
										</span>

										<p>무인택배함</p>
									</div>
								</div>
							</c:if>
							<c:if test="${security.cctv}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m23.944,12.13l-2.928-1.604.009-.016,2.507-1.792L8.509.301c-1.208-.653-2.725-.204-3.383,1.001l-1.821,3.336c-.66,1.21-.213,2.731.99,3.388l6.406,3.632-1.772,5.315c-.205.614-.777,1.026-1.423,1.026H1v-5H0v11h1v-5h6.507c1.078,0,2.031-.687,2.372-1.709l1.71-5.129,6.519,3.696.595-1.09,2.928,1.604,2.314-4.24Zm-6.228,2.355L4.782,7.153c-.726-.396-.994-1.31-.598-2.035l1.821-3.336c.272-.499.791-.782,1.321-.782.238,0,.479.057.701.177l13.643,7.644-1.319.943-2.634,4.722Zm1.465-.597l1.356-2.485,2.051,1.123-1.356,2.484-2.051-1.123Z" />
										</svg>
										</span>

										<p>CCTV</p>
									</div>
								</div>
							</c:if>
							<c:if test="${security.door_lock}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M8,7v-3C8,1.79,6.21,0,4,0S0,1.79,0,4v3c0,2.21,1.79,4,4,4s4-1.79,4-4Zm-4,3c-1.65,0-3-1.35-3-3v-3c0-1.65,1.35-3,3-3s3,1.35,3,3v3c0,1.65-1.35,3-3,3Zm8.85,4.91c-.2,.19-.51,.19-.71,0-.57-.58-1.33-.9-2.14-.9-1.65,0-3,1.35-3,3v3c0,1.65,1.35,3,3,3,.29,0,.58-.04,.86-.12,.27-.08,.54,.07,.62,.34,.08,.26-.07,.54-.34,.62-.37,.11-.75,.17-1.14,.17-2.21,0-4-1.79-4-4v-3c0-2.21,1.79-4,4-4,1.08,0,2.1,.43,2.86,1.2,.19,.2,.19,.51,0,.71ZM10.2,3.8c-.2-.2-.2-.51,0-.71L13.15,.15c.14-.14,.36-.19,.54-.11,.19,.08,.31,.26,.31,.46V9.5c0,.28-.22,.5-.5,.5s-.5-.22-.5-.5V1.71l-2.09,2.09c-.2,.2-.51,.2-.71,0ZM4,13.5v10c0,.28-.22,.5-.5,.5s-.5-.22-.5-.5V14.71l-2.09,2.09c-.2,.2-.51,.2-.71,0s-.2-.51,0-.71l2.94-2.94c.14-.14,.36-.19,.54-.11,.19,.08,.31,.26,.31,.46Zm18,1.85v-1.85c0-1.93-1.57-3.5-3.5-3.5s-3.5,1.57-3.5,3.5v1.85c-1.18,.56-2,1.76-2,3.15v2c0,1.93,1.57,3.5,3.5,3.5h4c1.93,0,3.5-1.57,3.5-3.5v-2c0-1.39-.82-2.58-2-3.15Zm-6-1.85c0-1.38,1.12-2.5,2.5-2.5s2.5,1.12,2.5,2.5v1.55c-.16-.02-.33-.05-.5-.05h-4c-.17,0-.34,.03-.5,.05v-1.55Zm7,7c0,1.38-1.12,2.5-2.5,2.5h-4c-1.38,0-2.5-1.12-2.5-2.5v-2c0-1.38,1.12-2.5,2.5-2.5h4c1.38,0,2.5,1.12,2.5,2.5v2Zm-3.5-1c0,.55-.45,1-1,1s-1-.45-1-1,.45-1,1-1,1,.45,1,1Z" /></svg>
										</span>

										<p>도어락</p>
									</div>
								</div>
							</c:if>
							<c:if test="${security.intercom}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="M22.97,3.27l-2.24-2.24c-.66-.66-1.54-1.03-2.48-1.03h-5.76c-1.93,0-3.5,1.57-3.5,3.5v4.5h-2v-.5c0-1.93-1.57-3.5-3.5-3.5S0,5.57,0,7.5v13c0,1.93,1.57,3.5,3.5,3.5H19.5c2.48,0,4.5-2.02,4.5-4.5V5.74c0-.92-.37-1.82-1.03-2.47Zm-.71,.71c.29,.29,.5,.64,.62,1.03h-2.39c-.83,0-1.5-.67-1.5-1.5V1.11c.38,.12,.73,.33,1.03,.62l2.24,2.24Zm-12.27-.47c0-1.38,1.12-2.5,2.5-2.5h5.5V3.5c0,1.38,1.12,2.5,2.5,2.5h2.5v2H10V3.5ZM3.5,23c-1.38,0-2.5-1.12-2.5-2.5V7.5c0-1.38,1.12-2.5,2.5-2.5s2.5,1.12,2.5,2.5v13c0,1.38-1.12,2.5-2.5,2.5Zm19.5-3.5c0,1.93-1.57,3.5-3.5,3.5H5.95c.65-.64,1.05-1.52,1.05-2.5V9H23v10.5Zm-9-7.5c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm-4,0c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm8,0c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm-4,4c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm-4,0c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm8,0c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm-4,4c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm-4,0c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Zm8,0c0-.55,.45-1,1-1s1,.45,1,1-.45,1-1,1-1-.45-1-1Z" /></svg>
										</span>

										<p>인터폰</p>
									</div>
								</div>
							</c:if>
							<c:if test="${security.entrance_security}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40"> <path
													d="m8,0C4.691,0,2,2.691,2,6s2.691,6,6,6,6-2.691,6-6S11.309,0,8,0Zm0,11c-2.757,0-5-2.243-5-5S5.243,1,8,1s5,2.243,5,5-2.243,5-5,5Zm-3,3h6v1h-6c-2.206,0-4,1.794-4,4v5H0v-5c0-2.757,2.243-5,5-5Zm17.287-2.51l-3.787-1.255-3.787,1.255c-1.024.34-1.713,1.294-1.713,2.373v3.531c0,3.613,3.868,5.83,5.054,6.423l.425.212.441-.178c1.191-.479,5.08-2.361,5.08-6.458v-3.531c0-1.079-.688-2.033-1.713-2.373Zm.713,5.904c0,3.469-3.408,5.109-4.454,5.53l-.022.01-.022-.011c-1.056-.528-4.501-2.489-4.501-5.528v-3.531c0-.647.413-1.22,1.027-1.424l3.473-1.151,3.473,1.151c.614.204,1.027.776,1.027,1.424v3.531Z" /></svg>
										</span>

										<p>현관보안</p>
									</div>
								</div>
							</c:if>
							<c:if test="${security.bodyguard}">
								<div class="col-lg-2">
									<div class="option-item">
										<span> <svg xmlns="http://www.w3.org/2000/svg"
												class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
												width="40" height="40">
											<path
													d="m11.774,6.746c.076.044.162.065.247.065.074,0,.149-.017.218-.05.529-.257,1.761-.997,1.761-2.329v-1.45c0-.22-.144-.414-.354-.479l-1.494-.458c-.099-.029-.205-.027-.304.004l-1.544.513c-.21.069-.349.268-.343.488l.038,1.382c0,1.137,1.112,1.938,1.774,2.313Zm.237-3.697l.988.304v1.08c0,.628-.562,1.068-.962,1.304-.4-.26-1.038-.762-1.038-1.317l-.028-1.024,1.04-.346Zm8.518,20.95c-.01,0-.02,0-.029,0-.264,0-.483-.205-.499-.471-.119-2.053-1.073-4.987-2.606-6.381-.225-.205-.569-.197-.782.016l-4.226,5.153c-.095.115-.237.183-.387.183s-.292-.067-.387-.183l-4.245-5.176c-.182-.18-.525-.186-.749.021-1.524,1.395-2.473,4.321-2.591,6.366-.016.276-.213.509-.527.471-.276-.016-.486-.252-.471-.528.133-2.299,1.176-5.457,2.914-7.046.62-.569,1.572-.548,2.164.046l3.892,4.741,3.872-4.719c.626-.628,1.576-.647,2.194-.085,1.749,1.589,2.799,4.756,2.933,7.062.017.276-.194.513-.47.528ZM5.222,5.604l.793.396v3c0,3.309,2.691,6,6,6s6-2.691,6-6v-3l.791-.396c.746-.371,1.209-1.12,1.209-1.953,0-.971-.652-1.835-1.587-2.103L13.68.2c-1.093-.271-2.26-.269-3.394.018l-4.686,1.332c-.934.266-1.586,1.13-1.586,2.101,0,.834.463,1.582,1.207,1.953Zm6.793,8.396c-2.757,0-5-2.243-5-5v-1.431c1.328.908,3.12,1.431,5,1.431,2.395,0,4.03-.775,5-1.451v1.451c0,2.757-2.243,5-5,5ZM5.874,2.511l4.67-1.327c.958-.24,1.96-.244,2.879-.017l4.73,1.343c.507.146.861.614.861,1.141,0,.451-.251.857-.655,1.059l-1.068.534s-.276.102-.276.447v.582c-.584.532-2.208,1.728-5,1.728-2.772,0-4.392-1.157-5-1.702,0,0-.001-.54-.003-.558.02-.201-.082-.402-.273-.497l-1.07-.534c-.403-.201-.653-.606-.653-1.059,0-.526.354-.995.859-1.14Z" /></svg>
										</span>
										<p>경호원</p>

									</div>
								</div>
							</c:if>
						</div>

						<br />
						<h5 class="card-subtitle mb-2 text-muted">주변시설</h5>
						<!-- 아직구현못함 -->
						<div class="col-md-12">
							<div id="map2" style="height: 400px"></div>
						</div>
						<br />
						<!--편의 시설 혹시 모르니깐 넣어둔거  -->
						<div class="row">

							<div class="col-lg-2" id="subway">
								<span> <svg xmlns="http://www.w3.org/2000/svg"
										class="Layer_1" data-name="Layer 1" width="40" height="40"
										viewBox="0 0 24 24">
												<path
											d="M17.5,0H6.5C4.019,0,2,2.019,2,4.5V14.5c0,2.481,2.019,4.5,4.5,4.5h.117l-2.546,4.243c-.143,.237-.065,.544,.172,.686,.08,.048,.169,.071,.257,.071,.169,0,.335-.086,.429-.243l2.854-4.757h8.434l2.854,4.757c.094,.156,.26,.243,.429,.243,.088,0,.177-.023,.257-.071,.237-.142,.314-.449,.172-.686l-2.546-4.243h.117c2.481,0,4.5-2.019,4.5-4.5V4.5c0-2.481-2.019-4.5-4.5-4.5Zm-5,12V5h8.5v7H12.5Zm-9.5,0V5H11.5v7H3ZM6.5,1h11c1.76,0,3.221,1.306,3.464,3H3.036c.243-1.694,1.704-3,3.464-3Zm11,17H6.5c-1.93,0-3.5-1.57-3.5-3.5v-1.5h3v1.5c0,.276,.224,.5,.5,.5s.5-.224,.5-.5v-1.5h10v1.5c0,.276,.224,.5,.5,.5s.5-.224,.5-.5v-1.5h3v1.5c0,1.93-1.57,3.5-3.5,3.5Z" /></svg>
								</span>
								<p>지하철</p>
							</div>
							<div class="col-lg-2" id="bus">
								<span> <svg xmlns="http://www.w3.org/2000/svg"
										id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
										width="40" height="40">
 									 		<path
											d="m21.5,6h-7.43l-1.346-1.303,4.394-2.197L12.118,0h-1.118v4.965l-1.07,1.035H2.5c-1.379,0-2.5,1.122-2.5,2.5v15.5h24v-15.5c0-1.378-1.121-2.5-2.5-2.5Zm0,1c.827,0,1.5.673,1.5,1.5v1.5h-4.798l-3.099-3h6.397ZM12,1.059l2.882,1.441-2.882,1.441V1.059ZM2.5,7h6.397l-3.099,3H1v-1.5c0-.827.673-1.5,1.5-1.5Zm11.5,16h-4v-6c0-1.103.897-2,2-2s2,.897,2,2v6Zm1,0v-6c0-1.654-1.346-3-3-3s-3,1.346-3,3v6H1v-12h5.202l5.798-5.612,5.798,5.612h5.202v12h-8ZM4,15h3v1h-3v-1Zm0,4h3v1h-3v-1Zm13-4h3v1h-3v-1Zm0,4h3v1h-3v-1Zm-4-9c0,.552-.448,1-1,1s-1-.448-1-1,.448-1,1-1,1,.448,1,1Z" />
										</svg>
								</span>
								<p>학교</p>
							</div>
							<div class="col-lg-2" id="hospital">
								<span> <svg xmlns="http://www.w3.org/2000/svg"
										class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
										width="40" height="40">
												<path
											d="m21.5,6h-1.5v-3.5c0-1.378-1.121-2.5-2.5-2.5H6.5c-1.379,0-2.5,1.122-2.5,2.5v3.5h-1.5c-1.379,0-2.5,1.122-2.5,2.5v15.5h24v-15.5c0-1.378-1.121-2.5-2.5-2.5ZM1,23v-14.5c0-.827.673-1.5,1.5-1.5h1.5v16H1Zm18,0H5V2.5c0-.827.673-1.5,1.5-1.5h11c.827,0,1.5.673,1.5,1.5v20.5Zm4,0h-3V7h1.5c.827,0,1.5.673,1.5,1.5v14.5Zm-15-9h3v1h-3v-1Zm5,0h3v1h-3v-1Zm-5,4h3v1h-3v-1Zm5,0h3v1h-3v-1Zm-.5-10.5v2.5h-1v-2.5h-2.5v-1h2.5v-2.5h1v2.5h2.5v1h-2.5Z" /></svg>
								</span>
								<p>병원</p>
							</div>
							<div class="col-lg-2" id="mart">
								<span> <svg xmlns="http://www.w3.org/2000/svg"
										class="Layer_1" data-name="Layer 1" viewBox="0 0 24 24"
										width="40" height="40">
 												 <path
											d="m11,23.5c0,.276-.224.5-.5.5h-6c-1.93,0-3.5-1.57-3.5-3.5v-9.558c-.617-.631-1-1.492-1-2.442C0,8.459,2.015.379,2.015.379c.056-.223.255-.379.485-.379h19c.229,0,.429.156.485.379,0,0,2.015,8.08,2.015,8.121,0,.862-.316,1.691-.892,2.333-.185.206-.5.224-.706.039-.206-.184-.223-.5-.039-.706.397-.444.622-1.013.636-1.608l-1.89-7.559h-4.109v3.5c0,.276-.224.5-.5.5s-.5-.224-.5-.5V1h-8v3.5c0,.276-.224.5-.5.5s-.5-.224-.5-.5V1H2.891l-1.89,7.559c.032,1.352,1.141,2.441,2.5,2.441h1c1.378,0,2.5-1.122,2.5-2.5,0-.276.224-.5.5-.5s.5.224.5.5c0,1.378,1.122,2.5,2.5,2.5h1c.276,0,.5.224.5.5s-.224.5-.5.5h-1c-1.28,0-2.39-.698-3-1.726-.61,1.028-1.72,1.726-3,1.726h-1c-.539,0-1.044-.133-1.5-.351v8.851c0,1.379,1.122,2.5,2.5,2.5h6c.276,0,.5.224.5.5Zm13-6c0,3.584-2.916,6.5-6.5,6.5s-6.5-2.916-6.5-6.5,2.916-6.5,6.5-6.5,6.5,2.916,6.5,6.5Zm-1,0c0-3.032-2.467-5.5-5.5-5.5s-5.5,2.468-5.5,5.5,2.467,5.5,5.5,5.5,5.5-2.468,5.5-5.5Zm-2.857-1.369l-2.706,2.618c-.337.33-.886.334-1.223.004l-1.363-1.345c-.196-.194-.513-.191-.707.004-.194.197-.192.514.005.707l1.364,1.347c.362.354.837.531,1.312.531s.951-.178,1.311-.533l2.703-2.614c.198-.192.204-.509.012-.707-.191-.198-.508-.203-.707-.012Z" />
												</svg>
								</span>
								<p>마트</p>
							</div>
						</div>
						<!-- 허위매물 신고 -->
						<!--  다윗 추가 -->
						<form class="decalarationFrm" action="report" method="post">
							<div>
								<input name="property_id" type="hidden"
									value="${property.property_id}">
							</div>
							<div class="reportDivTag">
								<input name="user_id" type="hidden" class="user-session"
									value="${sessionScope.user}"> <input type="submit"
									class="reportButton btn btn-danger btn-block" value="허위매물 신고">
							</div>
						</form>
						<!-- 다윗끝 -->
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="card bg-light mt-4">
					<div class="card-body">
						<div class=" container">
							<%@include file="/WEB-INF/views/propDetail/propNav.jsp"%>
						</div>
					</div>
				</div>
			</div>
			<!-- col-lg-4 -->
		</div>
		<div class="container overlay">
			<div class=" card bg-light mt-4">
				<div class="card-body overlay-inner" style="margin-top: 10px;">
					<img id="agent-image"
						src="resources/agentImg/${agent.agent_realfname}" alt="중개인 이미지"
						width="100px" height="100px"><br> <br>
					<table class="reservation-AgentInfo" id="reservation-AgentInfo">
						<tr>
							<td class="card-title"><span id="agent-name"><small><b>이름&nbsp;:&nbsp;</b></small></span></td>
							<td><p class="card-text">
									<small>${property.agent_id}</small>
								</p></td>
						</tr>
						<tr>
							<td class="card-title"><span id="agent-contact"><small><b>연락처&nbsp;:&nbsp;</b></small></span></td>
							<td><p class="card-text">${agent.agent_phone}</p></td>
						</tr>
						<tr>
							<td class="card-title"><span id="agent-email"><small><b>이메일&nbsp;:&nbsp;</b></small></span></td>
							<td><p class="card-text">
									<i class="far fa-envelope mr-2"></i>${agent.agent_email}</p></td>
						</tr>
					</table>
					<hr>

					<h5 class="card-title mt-4">
						<b>집예약<b>
					</h5>
					<label for="time-slot">날짜 선택 :</label> <input type="date"
						id="selected-date">

					<div class="reservation_time">
						<label for="time-slot"><small>시간 선택 :</small></label> <select
							id="time-slot">
							<option class="time-slot" value="00:00">선택</option>
							<option class="time-slot" value="09:30">9:30</option>
							<option class="time-slot" value="10:30">10:30</option>
							<option class="time-slot" value="11:30">11:30</option>
							<option class="time-slot" value="12:30">12:30</option>
							<option class="time-slot" value="14:30">14:30</option>
							<option class="time-slot" value="15:30">15:30</option>
							<option class="time-slot" value="16:30">16:30</option>
							<option class="time-slot" value="17:30">17:30</option>
							<option class="time-slot" value="18:30">18:30</option>

						</select>

						<form action="reservationInsert" id="reservation-form"
							style="display: none;">
							<label for="reservation_date">예약 날짜:</label> <input type="date"
								id="reservation_date" class="reservation_date"
								name="reservation_date" readonly="readonly" required="required">
							<label for="reservation_time">예약 시간:</label> <input type="time"
								id="reservation_time" class="reservation_time"
								name="reservation_time" readonly="readonly" required="required">
							<label for="user_id">고객 id:</label> <input type="text"
								id="user_id" name="user_id" readonly="readonly"
								value="${sessionScope.user}" required="required"> <label
								for="agent_id">중개인 id:</label> <input type="text" id="agent_id"
								name="agent_id" readonly="readonly" value="${property.agent_id}"
								required="required"> <label for="property_id">매물번호:</label>
							<input type="text" id="property_id" name="property_id"
								readonly="readonly" value="${property.property_id }"
								required="required">
						</form>

						<hr>
						<input type="submit" id="submit-btn"
							class="btn btn-primary btn-block" value="예약하기"> <input
							type="button" class="btn btn-primary btn-block close-btn"
							value="나가기">
						<hr>
					</div>
				</div>
			</div>
			<!-- end of layout space -->
		</div>
	</div>
	<!-- layout event 시, 중개인 연결  ---------------------------------------------------------------------------- -->







	<!-- Bootstrap core JavaScript -->
	<script src="resources/mainPage/vendor/jquery/jquery.min.js"></script>
	<script
		src="resources/mainPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="resources/map/js/propertymap.js"></script>
	<script src="resources/map/js/categorymap.js"></script>
	<!-- js파일 연동 추가 -->
	<!-- 24/05/16 - ㄱㅈ - 중개인 연결 -->
	<script type="text/javascript"
		src="resources/ProductDetail/js/connectAgent.js"></script>

	<script src="resources/nav/js/nav.js"></script>

	<!-- 다윗추가 -->
	<script type="text/javascript"
		src="resources/ProductDetail/js/report.js"></script>
	<script type="text/javascript">
		// 관심매물 등록
		$(".watchlist").click(function() {
			var property_id = $(".property_id").text();

			$.ajax({
				type : "get",
				url : "watchListInsert",
				data : {
					"property_id" : property_id
				},
				success : function(result) {
					if (result === "1") {
						alert("관심매물에 추가되었습니다.");
						$(".watchlist").hide(); // watchlist 아이콘 숨기기
						$(".watchlistDelete").show(); // watchlistDelete 아이콘 보이기
					} else if (result === "0") {
						alert("로그인한 회원만 이용 가능합니다.");
						location.href = "login";

					}
				},
				error : function(err) {
					console.log(err);
					alert(err);
				}
			});
		});

		// 관심매물 삭제
		$(".watchlistDelete").click(function() {
			var property_id = $(".property_id").text();

			$.ajax({
				type : "get",
				url : "watchListDelete",
				data : {
					"property_id" : property_id
				},
				success : function(result) {
					if (result === "1") {
						alert("관심매물에서 제거되었습니다.");
						$(".watchlistDelete").hide(); // watchlistDelete 아이콘 숨기기
						$(".watchlist").show(); // watchlist 아이콘 보이기
					} else if (result === "0") {
						alert("로그인한 회원만 이용 가능합니다.");
						location.href = "login";
					}
				},
				error : function(err) {
					console.log(err);
				}

			});

		});
	</script>

</body>
<!-- Footer -->
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</html>
