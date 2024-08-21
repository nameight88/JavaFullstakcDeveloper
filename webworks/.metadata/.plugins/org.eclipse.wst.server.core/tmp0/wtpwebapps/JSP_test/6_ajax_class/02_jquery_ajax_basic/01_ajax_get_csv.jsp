<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script  type="text/javascript"  src="libs/jquery-1.9.1.min.js"> </script>
	<script type="text/javascript">
		$(function () {			
			let param= {cate:"book",
						name:"kim"};
			//비동기통신(ajax)
			//화면을 가만히 있는 상태에서 서버에 요청하고 그 결과 받아오기
			/*
			$.ajax({
				type 	:	'get', //브라우저마다 보내는 방식이 다르다 ms get chrome post
				url 	:	'02_server.jsp',
				data	:	param,
				success	:	parseData
				error	:	function(err){
							alert("에러발생");
							console.log(err);
							}
			});
			*/
			//[참고] ajax 축약형
			$.get('02_server.jsp',param,parseData);
			function parseData(strText){
				
				// alert( strText );
				
				var aryData = strText.split("|");
							
				for(var i=0;i<aryData.length;i++){
					var param  = aryData[i].split("=");				
					if( param[0].trim() == 'cate'){  // 공백제거를 하지 않으면 처음에 공백에 들어와서 cate를 찾지 못함
						 document.getElementById("cate").value = param[1];
					}
					
					if( param[0].trim() == 'name'){
						document.getElementById("name").value = param[1];
					}
				
				}
				
			}
			
		})
		
		//부분적인 값이 바뀔때에 쓰인다.
	</script>
</head>


<body>
<form id="frm">
	<h3>서버로부터 넘겨받은 데이터</h3><br/>
	<label for = "cate">첫번째 데이터 : </label>
	<input type="text" name="" id="cate"/><br/>
	<label for = "name">두번째 데이터 : </label>
	<input type="text" name="" id="name"/><br/>
</form>
</body>
</html>


