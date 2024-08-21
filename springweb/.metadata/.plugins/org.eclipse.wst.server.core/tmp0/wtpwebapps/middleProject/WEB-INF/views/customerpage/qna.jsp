<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	<meta name="author" content="">
  	
  	
  	
  	
  	<title>문의하기</title>
  	<!-- Bootstrap core CSS -->
  	<link href="<%=request.getContextPath() %>/resources/myPage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  	<!-- Custom styles for this template -->
  	<link href="<%=request.getContextPath() %>/resources/common/css/shop-homepage.css" rel="stylesheet">
  	<link href="<%=request.getContextPath() %>/resources/common/css/common.css" rel="stylesheet">
  	<link href="<%=request.getContextPath() %>/resources/order/css/deliveryForm.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="container sub-container delivery-container">
			<h4 class="buyer-title">문의하기</h4>
			<div class="card-title mt-5 text-center">부동산 서비스에 궁금하신 점을 문의해주세요.<br>문의내용과 답변은'1:1 문의내역'에서 확인하실 수 있습니다</div>
			
			
			<!-- <div class="row">
				<div class="col-lg-6">
					<input type="text" value="ggg">
				</div> 
				<div class="col-lg-6">
					<input type="text" value="ggg">
				</div> 
				
			</div> -->
				<table class="table">
				  <tbody>
                     <tr>
				      <th scope="row" class="row-title">이름</th>
				      <td><input class="form-control" name="recipient" placeholder="${ delivery.recipient }" type="text" value="${ delivery.recipient }"></td>
				    </tr>
				    <tr>
				      <th scope="row" class="row-title">이메일</th>
				      <td>
				      	  <input class="form-control" name="shippingAddress" placeholder="${ delivery.shippingAddress }" type="text" value="${ delivery.shippingAddress }">
				      </td>
				    </tr>
				    <tr>
				      <th scope="row" class="row-title">전화번호</th>
				      <td><input class="form-control" name="deliverPhone" placeholder="${ delivery.deliverPhone }" type="text" value="${ delivery.deliverPhone }"></td>
				    </tr>
				    <tr>
				      <th scope="row" class="row-title">문의유형</th>
				      <td><select class="form-control" name="customerType">
							<option value="1">이용문의</option>
							<option value="2">기타문의</option>
							<option value="3">건의사항</option>
							<option value="4">오류신고</option>
							<option value="5"></option>
						</select></td>
				    </tr>
				  </tbody>
				</table>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		<div class="container sub-container delivery-container">
		<h5 class="buyer-title">문의제목</h5>
<td><input class="form-control" name="recipient" placeholder="${ delivery.recipient }" type="text" value="${ delivery.recipient }"></td>

<!-- 공백 추가 -->
<div style="margin-bottom: 50px;"></div>

<h5 class="buyer-title">문의내용</h5>
				<input name="orderCode" type="hidden" value="${ delivery.orderCode }">
				<input type="hidden" name="_method" value="put" />
				<table class="table">
				  <tbody>
				    <tr>
				      <form action="/submitForm" method="post">
    <div class="form-group">
        <textarea class="form-control" id="recipient" name="recipient" rows="5" maxlength="2000" placeholder="Enter text here..."></textarea>
    </div>
</form>
				    </tr>
				    
				  </tbody>
				</table>
				<div class="submit-container">
					<input type="button" class="btn btn-dark submit-button" value="제출"></input>
				</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->
	<script src="<%=request.getContextPath() %>/resources/mainPage/vendor/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/mainPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<!-- JavaScript -->
	<script src="<%=request.getContextPath() %>/resources/order/js/deliveryForm.js"></script>
	<script src="<%=request.getContextPath() %>/resources/common/js/addressAPI.js"></script>
	<script src="../resources/nav/js/nav.js"></script>
</body>
</html>