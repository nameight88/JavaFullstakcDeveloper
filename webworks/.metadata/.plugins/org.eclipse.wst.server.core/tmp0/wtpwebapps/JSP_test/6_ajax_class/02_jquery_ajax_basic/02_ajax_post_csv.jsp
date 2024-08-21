<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="libs/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		let param = {
			cate : "book",
			name : "kim"
		}
		$.ajax({
			type : 'post',
			data : param,
			url : '02_server.jsp',
			success : function(result){
				var aryData = result.split("|");//|를 기준으로 데이터 값을 나눈다
				for (var i = 0; i < aryData.length; i += 1) {
					var keyValue = aryData[i].split("=");//값을 =을 기준으로 한번더 나눈다
					if (keyValue[0].trim() == 'cate') {//배열의 값이 첫번째의 값에 대해서 조건을 하나 걸어준다.
						$('#cate').val(keyValue[1]);
					}
				}
			},
			error : function(err) {
				alert('서버전송실패')
			}
		});
	})
	//예제에선 함수를 만들어서 함수를 연결해서 보내는걸 추천
</script>

</head>


<body>
	서버로부터 넘겨받은 데이터
	<br /> 첫번째 데이터 :
	<input type="text" name="" id="cate" />
	<br /> 두번째 데이터 :
	<input type="text" name="" id="name" />
	<br />
</body>
</html>


