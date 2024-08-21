<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/ProductDetail/css/propNav.css">
<link rel="stylesheet"
	href="resources/ProductDetail/css/connectAgent.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>

	<!-- 중개인 연결 ########################################### -->
	<nav class="agentInfo">
		<div class="agentInfo">
			<div class="card bg-light" style="padding: 10px;">
				<div class="navInfo">
					<input class="propId" value="${property.property_id }"
						readonly="readonly" size="8"
						style="text-align: center; background-color: rgba(144, 238, 144, 0.8);">

				</div>
				<br>
				<div class="navInfo-price" style="font-size: 1.5em;">
					<c:choose>
						<c:when test="${property.property_cate == '월세'}">
							<strong>${property.property_cate}</strong>&nbsp;<strong>${property.deposit}</strong><strong>&nbsp;/&nbsp;${property.price}</strong>
						</c:when>
						<c:otherwise>
							<strong>${property.property_cate}</strong>&nbsp;<strong>&nbsp;&nbsp;${property.price}</strong>
							
						</c:otherwise>
					</c:choose>
					
					
				</div>
				<small>[단위:만원]</small>
				<div class="navInfo-summury">
					<table>
						<tr>
							<td><b>매물 정보 :</b></td>
							<td>${property.property_type }/ ${property.property_size}평</td>
						</tr>
						<tr>
							<td><b>방&nbsp;/&nbsp;욕실 :</b></td>
							<td>${property.bedrooms }개&nbsp;/&nbsp;${property.bathrooms }개</td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td><b>매물 등록일 :</b></td>
							<td>${property.reg_date }</td>
						</tr>
					</table>
				</div>
				<hr>
				<div style="margin-left: 30%;">
					<h5>
						<b>${agent.agency}</b>
					</h5>
				</div>
				<div class="contectImg">
					<table class="agentInfo">
						<tr>
							<td><input type="button"
								class="btn btn-primary btn-block open-btn" id="open-btn"
								value="연락처 보기"
								style="color: white; background-color: #007BFF; margin-left: 30%"></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- end of total div -->
		</div>
		<!-- end of agentInfo div -->
	</nav>
	<!-- end of agentInfo nav -->

</body>
</html>