<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- CSS추가 -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<style>
/* 추가한 스타일 */
.custom-btn {
	width: 50%;
}
</style>

<!-- javascript -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="/middleTest/resources/ProductDetail/js/report.js"></script>
<title>허위매물 신고 및 이용약관 사항</title>
</head>
<body>

	<div class="container">
									<!--  이용약관 및 매뉴얼 신고 사항에 대한 폼 -->
	<form class="validate-check">
		<div class="card bg-light">

			<div class="report_body">
				<div class="card-title mt-12 text-center">
					<h3>허위매물 신고</h3>
				</div>
				<br />
				<div class="text-center">한국인터넷자정책기구(KISO) 부동산매물클린관리센터는
					공정거래위원회에서 승인한 온라인 부동산 광고 자율규약에 따라 매물 신고 서비스를 운영하고 있습니다.</div>
				<br />

				<div class="col-lg-12">
					<div class="text-right">
						<a
							href="https://www.kiso.or.kr/정보센터/부동산매물클린관리센터-2/부동산매물클린관리센터-운영규정/부동산매물클린관리센터-개인정보-처리방침/
							 "
							target="_blank">매물신고 운영 정책 확인하기</a><br /> <input type="checkbox" class="validate-checkbox1">확인하였습니다.
					</div>
				</div>
				<hr />
				<div class="card-title mt-12 text-center">
					<h3>신고방법</h3>
				</div>
				<br />
				<div class="text-center">신고 후 부동산매물클린관리센터의 검증을 거쳐 허위매물임이 확인된
					경우에는 중개업소에 페널티가 부여됩니다. 다만 허위신고일 경우 서비스 이용에 제한 또는 형사고발 대상이 될 수 있으니,
					매물 신고 매뉴얼을 숙지 후 신고 부탁드립니다.</div>
				<br />

				<div class="col-lg-12">
					<div class="text-right">
						<a
							href="https://www.kiso.or.kr/%ec%95%8c%eb%a6%bc%eb%a7%88%eb%8b%b9/%ec%a3%bc%ec%9a%94-%ea%b3%b5%ea%b0%9c%ec%82%ac%ed%95%ad/%ea%b1%b0%ec%a7%93%eb%a7%a4%eb%ac%bc%ec%8b%a0%ea%b3%a0%ec%b2%98%eb%a6%ac%ed%98%84%ed%99%a9/?mod=document&pageid=1&uid=1336"
							target="_blank">매물신고 매뉴얼 확인하기</a><br /> <input type="checkbox" class="validate-checkbox2">확인하였습니다.
					</div>
				</div>
				<hr />
			</div>
		</div>
	</form>
	
	<!--  허위매물 신고에 대한  -->
			<form class="declarationFrm" action="declaration_insert"
				method='get' enctype="multipart/form-data">
				<div class="form-desc text-center">
					<div class="jumbotron card-title mt-12 text-center">
						<h2>
							<b>허위매물신고</b>
						</h2>
					</div>
				</div>
											<!-- div:신고 매물 정보  -->
				<div>
					<div class="title">
						<h4>신고매물정보</h4>
					</div>
					<table class="table">
						<tbody class="table-row-group;">
							<tr>
								<th>매물번호</th>
								<td >${property.property_id }</td>
								
							</tr>
							<tr>
								<th>매물이름</th>
								<td>${property.property_title }</td>
							</tr>
							<tr>
								<th>매물구분</th>
								<td>${property.property_type }</td>
							</tr>
							<tr>
								<th>매물소새지</th>
								<td>${property.property_addr }</td>
							</tr>
							<tr>
								<th>중개인</th>
								<td>${property.agent_id }</td>
							</tr>
							<tr>
								<th>사용자</th>
								<td>${sessionScope.user }</td>
							</tr>
						</tbody>
					</table>
				</div>
													<!-- 신고매물 정보 끝  -->

				<h3>
					<b>매물신고내용</b>
				</h3>
				<textarea class="col-lg-12" rows="5" name="declaration_contents"
					placeholder="정확한 확인을 위해 신고내용을 구체적으로 기재해주세요. (20자 이상) 본 신고 내용은 해당 중개업소에게 전달되므로, 개인정보(연락처, 이름 등)는 기재하지 말아주세요."></textarea>
				<!-- div:중개인 증명사진 입력 -->
				
				<!-- 
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-folder"></i>
						</span>
					</div>
					<label for="file">이미지</label> 
					<input name="file" type="file" maxlength="60" size="40">
					 
				</div>
 -->
				<div class="form-group">
												<!-- 사용자 정보 값 히든  -->
				<input type="hidden" value="${property.property_id}" name="property_id">
				<input type="hidden" value="${property.property_title}" name="property_title">
				<input type="hidden" value="${property.property_type}" name="property_type">
				<input type="hidden" value="${property.property_addr}" name="property_addr">
				<input type="hidden" value="${property.agent_id}" name="agent_id">
				<input type="hidden" value="${sessionScope.user}" name="user_id" class="user-session">
					<input type="submit" class="btn btn-danger btn-block custom-btn declaration-submit"
						value="신고하기 ">

				</div>
			
				
			</form>
			
										<!-- 신고 취소 했을때 돌아가는 폼  -->
			<form mathod="get" action="mainPage">
				<button class=" exit_report btn btn-primary btn-block ">취소</button>
				</form>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



	<!-- 
   <script src="../resources/signUp/js/signUp.js"></script>
   <script src="../resources/common/js/common_submit.js"></script>
   <script src="../resources/common/js/addressAPI.js"></script>
    -->
</body>
</html>