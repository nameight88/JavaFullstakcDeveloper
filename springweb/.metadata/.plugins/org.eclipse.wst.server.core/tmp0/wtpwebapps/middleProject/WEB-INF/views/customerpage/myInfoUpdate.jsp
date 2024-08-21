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
	href="<%=request.getContextPath()%>/resources/myPage/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/resources/common/css/shop-homepage.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/common/css/common.css"
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
					<a href="myInfo" class="list-group-item active">내정보</a> <a
						href="qnaAdmin" class="list-group-item">신고내역</a> <a
						href="reservAdmin" class="list-group-item">예약관리</a>

				</div>
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			</div>
			




<div class="col-lg-9">
    <div class="table-responsive">
        <br /> <br />
        <table class="table">
            <thead>
            </thead>
            <tbody>
                <h4 class="card-title mt-3 text-center">
                    <strong>내정보</strong>
                </h4>
                <form action="updateSubmit" method="post"> <!-- submit.php는 제출 시 데이터를 처리하는 서버 측 스크립트 파일입니다. -->
                    <tr>
                        <td>ID</td>
                        <td><input type="text" id="user_id" name="user_id" value="${userInfo.user_id}" readonly></td>
                    </tr>

                    <tr>
                        <td>이름</td>
                        <td><input type="text" id="user_name" name="user_name" value="${userInfo.user_name}"></td>
                    </tr>

                    <tr>
                        <td>연락처</td>
                        <td><input type="text" id="user_phone" name="user_phone" value="${userInfo.user_phone}"></td>
                    </tr>

                    <tr>
                        <td>이메일</td>
                        <td><input type="email" id="user_email" name="user_email" value="${userInfo.user_email}" readonly></td>
                    </tr>

                    <tr>
                        <td colspan="2" class="text-center">
                            <button type="submit" class="btn btn-primary">제출</button>
                        </td>
                    </tr>
                </form>
            </tbody>
        </table>
    </div>
</div>
				</div>
			</div>
		</div>
	</div>





	</div>
	</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/myPage/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/myPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/nav/js/nav.js"></script>
</body>
</html>