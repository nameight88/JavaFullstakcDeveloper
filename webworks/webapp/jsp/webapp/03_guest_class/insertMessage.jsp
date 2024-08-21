<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){//jquery
		$('form > input[type=button]:nth-child(10)').click(function(){
			
			//유효성 검사[추가작업]
			
			$('form[name="frm"]').submit();
		});//end of submit button event
		
	})
	
</script>
<title> 방명록 </title>
</head>

<body>

	<form action="saveMessage.jsp" name="frm" method="post">
		이름 : <input type="text" name="guestName" required /><br/><br/>
		암호 : <input type="password" name="password" required /><br/><br/>
		메세지 : <textarea name="message" rows="3" cols="30" required></textarea><br/><br/>
		<input type="button" value="메세지 남기기">
	</form>
</body>
</html>