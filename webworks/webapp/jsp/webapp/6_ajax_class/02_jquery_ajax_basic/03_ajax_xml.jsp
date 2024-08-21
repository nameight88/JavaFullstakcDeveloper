<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="libs/jquery-1.9.1.min.js">
	
</script>
<script type="text/javascript">
	$(function() {
		let param = {
				cate : "book",
				name : "kim"
			}
		$.ajax({
			type		:	'post'
			,url		:	'03_server.jsp'
			,data		:	param //서버로 보내는 데이터
			,datatype	:	'xml' //응답 데이터 종류(text/html/xml/json....)
			,success	:	parseData
		});
		function parseData(result) {
			//alert(result);
			"<first>"+ "서버에서"+cate+"변경" +"</first>";
			"<second>"+ "from_"+name+"_server" +"</second>";
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


