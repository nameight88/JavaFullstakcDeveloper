<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원가입  </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script type="text/javascript">
$(function () {
	$('#btnIdCheck').click(function(){
		let idInput = $('input[name="id"]').val();
	
		//[예전방식]
		//window.open("CheckId.jsp?userId="+ idInput,"창이름","width=500, height=100");
		//변수를 새로 선언해서 저장을 해도 된다.
		//[Ajax 방식]
		$.ajax({
			type :'get' //데이터 전송 방식
			,url : 'CheckId.jsp' //이동하는 주소
			,data:	{'userId':idInput} //주소를 이동을 할때 가져가는 데이터
			,success :function(result){ //성공을 했을때의 함수실행
				//alert(result);
				if(result.trim()== 'true'){
					$('#result').text("아이디가 중복됩니다.")
					
				}else{
					$('#result').text("사용가능한 아이디입니다.")
				}
			}
			
			,error	:function(err){
				alert('서버전송실패');
				console.log(err);
			}
			
		});
		
	});
})
	
</script>
</head>
<body>

<h1>회원가입서 작성하기</h1>
 
	<form action="InsertMember.jsp" method="post" name="frm">
		<table>
			<tr>
				<td width="100">
				<font color="blue">아이디</font>
				</td>
				<td width="100">
				<input type="text" name="id">
				<input type="button" value="중복확인" id='btnIdCheck'>
				<!-- 중복결과 확인창 출력 -->
				<div id='result'></div>
				<br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">비밀번호</font>
				</td>
				<td width="100">
				<input type="password" name="password"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">비밀번호학인</font>
				</td>
				<td width="100">
				<input type="password" name="repassword"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">이름</font>
				</td>
				<td width="100">
				<input type="text" name="name"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">전화번호</font>
				</td>
				<td>
				<input type="text" size="15" name="tel"/>
				<br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">주소</font>
				</td>
				<td>
				<input type="text" size="50" name="addr"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				 <!--로그인 버튼-->
				 <input type="submit" value="회원가입">
				</td>
				<td width="100">
				<input type="reset" name="cancel" value="취소"><br/>
				</td>
			</tr>
		</table>
	</form>



 </body>
</html>
    