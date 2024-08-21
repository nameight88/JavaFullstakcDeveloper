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

<title>중개인페이지</title>

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
			</div>
			<div class="col-lg-9">
				<br /> <br /> <br /> <br />
				<div class="card bg-light">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title mt-3 text-center">매물 수정</h4>
						<br>
						<!-- 매물 등록 폼 -->
						<form action="propertyUpdate" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<input type="text" class="form-control" id="property_id" name="property_id" value="${property.property_id}" readonly>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="property_title" name="property_title" value="${property.property_title }" required>
							</div>
							<div class="form-group">
								<input type="date" class="form-control" id="property_year" name="property_year" value="${property.property_year }" readonly>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<input type="text" class="form-control" id="property_type" name="property_type" value="${property.property_type}" readonly>
								</div>
								<div class="form-group col-md-6">
       							<select class="form-control" id="property_cate" name="property_cate">
       								<option value="매매" ${property.property_cate eq '매매' ? 'selected' : ''}>매매</option>
       								<option value="전세" ${property.property_cate eq '전세' ? 'selected' : ''}>전세</option>
           	 						<option value="월세" ${property.property_cate eq '월세' ? 'selected' : ''}>월세</option>
        						</select>
   				 				</div>
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-8">
									<input type="text" class="form-control" id="post_code" name="post_code" value="${property.post_code }" readonly>
								
								</div>
								<div class="form-group col-md-4">
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="property_addr" name="property_addr" value="${property.property_addr }" readonly>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="addr_detail" name="addr_detail" placeholder="상세주소" value="${property.addr_detail }" readonly>
							</div>
							<div class="form-row">
								<div class="form-group col-md-10">
								<input type="text" class="form-control" id="property_size" name="property_size" value="${property.property_size }" readonly>
								</div>
								<div class="form-group col-md-2">
									<h5>평</h5>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-10">
									<input type="text" class="form-control" id="price" name="price" value="${property.price }" required>
								</div>
								<div class="form-group col-md-2">
									<h5>만원</h5>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-10">
									<input type="text" class="form-control" id="deposit" name="deposit" value="${property.deposit }" disabled="false">
								</div>
								<div class="form-group col-md-2">
									<h5>만원</h5>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="roomcnt">방</label> 
									<input type="text" class="form-control" id="bedrooms" name="bedrooms" value="${property.bedrooms}" readonly>
								</div>
								<div class="form-group col-md-6">
									<label for="bathroomcnt">욕실</label>
									<input type="text" class="form-control" id="bathrooms" name="bathrooms" value="${property.bathrooms}" readonly>
								</div>
							</div>
<!-- <option value="매매" ${property.property_cate eq '매매' ? 'selected' : ''}>매매</option> -->
							<!-- 옵션 체크박스 -->
							<div class="form-group">
								<label for="property_option">옵션선택</label> <br />
								<div class="checkbox-row">
									<input type="checkbox" name="aircon" value="${option.aircon }" ${option.aircon ? 'checked' : ''}> 에어컨 
									<input type="checkbox" name="refrigerator" value="${option.refrigerator }" ${option.refrigerator ? 'checked' : ''}> 냉장고 
									<input type="checkbox" name="washing_machine" value="${option.washing_machine }" ${option.refrigerator ? 'checked' : ''}> 세탁기 
									<input type="checkbox" name="shower_booth" value="${option.shower_booth }" ${option.shower_booth ? 'checked' : ''}> 샤워부스
								</div>
								<div class="checkbox-row">
									<input type="checkbox" name="sink" value="${option.sink }" ${option.sink ? 'checked' : ''}> 싱크대 
									<input type="checkbox" name="induction" value="${option.induction }" ${option.induction ? 'checked' : ''}> 인덕션 
									<input type="checkbox" name="veranda" value="${option.veranda }" ${option.veranda ? 'checked' : ''}> 베란다 
									<input type="checkbox" name="fire_alarm" value="${option.fire_alarm }" ${option.fire_alarm ? 'checked' : ''}> 화재경보기
									<input type="checkbox" name="tub" value="${option.tub }" ${option.tub ? 'checked' : ''}>욕조
								</div>
							</div>

							<!-- 보안 체크박스 -->
							<div class="form-group">
								<label for="security">보안</label> <br />
								<div class="checkbox-row">
									<input type="checkbox" name="storage_box" value="${security.storage_box}" ${security.storage_box ? 'checked' : ''} >택배보관함
									<input type="checkbox" name="cctv" value="${security.cctv}"  ${security.cctv ? 'checked' : ''}> cctv 
									<input type="checkbox" name="door_lock" value="${security.door_lock}"  ${security.door_lock ? 'checked' : ''}> 도어락 
									<input type="checkbox" name="intercom" value="${security.intercom}"  ${security.intercom ? 'checked' : ''}> 인터폰
									<input type="checkbox" name="entrance_security" value="${security.entrance_security}"  ${security.entrance_security ? 'checked' : ''}> 현관보안
									<input type="checkbox" name="bodyguard" value="${security.bodyguard}"  ${security.bodyguard ? 'checked' : ''}>경호원
										
								</div>
							</div>

							<div class="form-group">
								
								<textarea class="form-control" rows="3" cols="40" id="description" name="description" placeholder="매물설명" required>${property.description}</textarea>
							
							</div>

							<div class="form-group">
								<input type="file" name='file' maxlength="60" size="40">
							</div>

							<!-- 기타 필드들을 추가할 수 있습니다. -->
							<div class="form-group">
								<input type="submit" class="btn btn-primary btn-block" value="수정">
							</div>
						</form>
					</article>
				</div>
				<br />
				<br />
			</div>
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
		
	<script>
	 // 페이지 로드 시 거래 유형에 따른 보증금 필드 상태 설정
    var transactionType = $('#property_cate').val();
    if (transactionType === '전세' || transactionType === '매매') {
        $('#deposit').prop('disabled', true).val('');
    } else {
        $('#deposit').prop('disabled', false);
    }

    // 거래 유형 변경 시 보증금 필드 상태 변경
    $('#property_cate').change(function() {
        var transactionType = $(this).val();
        if (transactionType === '매매') {
            $('#deposit').prop('disabled', true).val('');
        } else {
            $('#deposit').prop('disabled', false);
        }
    });
	 
	 // 체크박스가 변경될 때 이벤트 처리
    $('input[type="checkbox"]').change(function() {
        // 체크박스가 선택된 경우
        if ($(this).prop('checked')) {
            $(this).val(true); // true 값을 설정
        } else {
            // 체크박스가 선택되지 않은 경우
            $(this).val(false); // false 값을 설정
        }
    });

	 
</script>

</body>

</html>