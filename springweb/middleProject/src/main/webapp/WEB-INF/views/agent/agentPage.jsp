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
					<a href="agentPage" class="list-group-item active">매물등록</a>
					<a href="agentManagement" class="list-group-item">매물관리</a> 
					<a href="agentReservation" class="list-group-item">예약관리</a>
				
				</div>
			</div>
			<div class="col-lg-9">
				<br /> <br /> <br /> <br />
				<div class="card bg-light">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title mt-3 text-center">매물 등록</h4>
						<br>
						<!-- 매물 등록 폼 -->
						<form action="propertyInsert" method="post" enctype="multipart/form-data">
							<input type="hidden" id="agent_id" name="agent_id" value="${sessionScope.agent }"> 
							<div class="form-group">
								<input type="text" class="form-control" id="property_title" name="property_title" placeholder="타이틀" required>
							</div>
							<div class="form-group">
								<input type="date" class="form-control" id="property_year" name="property_year" placeholder="연식" required>
							</div>
							<div class="form-row">
									
								
								<div class="form-group col-md-6">
									 <select class="form-control" id="property_type" name="property_type">
										<option value="원룸">원룸</option>
										<option value="투룸">투룸</option>
										<option value="오피스텔">오피스텔</option>
										<option value="아파트">아파트</option>
										<option value="빌라">빌라</option>
										<option value="주택">주택</option>
										<option value="사무실">사무실</option>
										<option value="상가">상가</option>
										
									</select>
								</div>
								<div class="form-group col-md-6">
								<select class="form-control" id="property_cate" name="property_cate">
										<option value="매매">매매</option>
										<option value="전세">전세</option>
										<option value="월세">월세</option>
								</select>
								</div>
							</div>
							<div class="form-row">
							
								<div class="form-group col-md-8">
									<input type="text" class="form-control" id="post_code" name="post_code" placeholder="우편번호" required>
								</div>
								<div class="form-group col-md-4">
									<button type="button" id="addrSearch" class="btn btn-primary btn-block">주소찾기</button>
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="property_addr" name="property_addr" placeholder="주소" required>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="addr_detail" name="addr_detail" placeholder="상세주소">
							</div>
							<div class="form-row">
								<div class="form-group col-md-10">
									<input type="text" class="form-control" id="property_size" name="property_size" placeholder="면적" required>
								</div>
								<div class="form-group col-md-2">
									<h5>평</h5>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-10">
									<input type="text" class="form-control" id="price" name="price" placeholder="가격" required>
								</div>
								<div class="form-group col-md-2">
									<h5>만원</h5>
								</div>
								
							</div>
							<div class="form-row">
								<div class="form-group col-md-10">
									<input type="text" class="form-control" id="deposit" name="deposit" placeholder="보증금" disabled="false">
								</div>
								<div class="form-group col-md-2">
									<h5>만원</h5>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="roomcnt">방</label> 
									<select class="form-control" id="bedrooms" name="bedrooms">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
									</select>
								</div>
								<div class="form-group col-md-6">
									<label for="bathroomcnt">욕실</label>
									<select class="form-control" id="bathrooms" name="bathrooms">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</div>
							</div>

							<!-- 옵션 체크박스 -->
							<div class="form-group">
								<label for="property_option">옵션선택</label> <br />
								<div class="checkbox-row">
									<input type="checkbox" name="aircon" value="false"> 에어컨 <input
										type="checkbox" name="refrigerator" value="false"> 냉장고 <input
										type="checkbox" name="washing_machine" value="false"> 세탁기 <input
										type="checkbox" name="shower_booth" value="false"> 샤워부스
								</div>
								<div class="checkbox-row">
									<input type="checkbox" name="sink" value="false"> 싱크대 <input
										type="checkbox" name="induction" value="false"> 인덕션 <input
										type="checkbox" name="veranda" value="false"> 베란다 <input
										type="checkbox" name="fire_alarm" value="false"> 화재경보기 <input
										type="checkbox" name="tub" value="false">욕조
								</div>
							</div>

							<!-- 보안 체크박스 -->
							<div class="form-group">
								<label for="security">보안</label> <br />
								<div class="checkbox-row">
									<input type="checkbox" name="storage_box" value="false">택배보관함
									<input type="checkbox" name="cctv" value="false"> cctv <input
										type="checkbox" name="door_lock" value="false"> 도어락 <input
										type="checkbox" name="intercom" value="false"> 인터폰 <input
										type="checkbox" name="entrance_security" value="false"> 현관보안
										<input type="checkbox" name="bodyguard" value="false">경호원
										
								</div>
							</div>

							<div class="form-group">
								<textarea class="form-control" rows="3" cols="40" id="description" name="description" placeholder="매물설명" required></textarea>
							
							</div>

							<div class="form-group">
								<input type="file" name='file' maxlength="60" size="40" required>
							</div>

							<!-- 기타 필드들을 추가할 수 있습니다. -->
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">등록하기</button>
							
							</div>
						</form>
					</article>
				</div>
				<br />
				<br />
			</div>
		</div>
	</div>
	<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
	<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
	<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
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
		
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    $('#property_cate').change(function() {
        // 선택된 거래 유형 값을 가져옴
        var transactionType = $(this).val();
       
        
        
        // 만약 거래 유형이 '매매'라면
        if (transactionType == '전세' || transactionType == '매매') {
            // 보증금 입력 필드를 활성화
        	$('#deposit').prop('disabled', true).val('');
           
        } else {
            // 아니라면 보증금 입력 필드를 비활성화하고 값을 초기화
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
	 
	 // 주소찾기 카카오 api
    $(document).on('click', '#addrSearch', function() {
    	
    	/* var popUrl = 'addrSearch'; // 팝업창에 표시할 주소 입력
        var popOption = "width=400, height=500, resizable=no, scrollbars=yes, status=no;";    // 팝업창 옵션(optoin)
        window.open(popUrl,"addressPopup",popOption); // 팝업창 오픈 */
    	
    	
        new daum.Postcode({
            oncomplete: function(data) { // 선택시 입력값 세팅
            	$("#post_code").val(data.zonecode);
                $("#property_addr").val(data.address); // 주소 넣기
                $("#addr_detail").focus(); // 상세입력 포커싱
            }
        }).open({
        	 popupName: 'addressPopup', // 팝업 이름 설정
             popup: true, // 팝업으로 띄우기
             autoResize: false, // 자동 조절 비활성화
             width: 400, // 팝업 너비
             height: 500 // 팝업 높이

        });
        
        
    });
    
    
    
</script>

</body>

</html>