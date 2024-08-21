<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="libs/jquery-1.9.1.min.js">
	
</script>
<script>
	$(function() {
		let param = {
			cate : "book",
			name : "kim"
		}
		$.ajax({
			type 		: 	'post'
			,url 		: 	'04_server.jsp'
			,data 		: 	param //서버로 보내는 데이터
			,datatype 	: 	'text' //응답 데이터 종류(text/html/xml/json....)
		//추후에는 text가 아니라 json으로 사용을 해야한다.
		// json 라이브러리를 사용해야함
		// 웹은 json을 주로하고 장비쪽은 xml구조로 보낸다.
			,success 	: 	parseData
		});
		function parseData(result) {
			alert(result);
			
			//추후에는 json 변환 라이브러리가 필요하다.
			//지금은 편법으로 json 객체 생성
			
			var obj 	=	{};
			obj 		= eval("("+result+)");
			
			$('#cate').val(obj.first);
		}
	})
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


