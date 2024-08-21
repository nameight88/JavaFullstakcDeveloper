<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
		<h1>회원가입</h1>		
		<hr>
		<form action="insertMember" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">아이디</td><td align="left">
					<input type="text" name="id" size="10"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">비밀번호</td><td align="left">
					<input type="text" name="pass" size="10"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">사용자이름</td><td align="left">
					<input type="text" name="name" size="10"/></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="회원가입" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="deleteMember?seq=${board.seq }">회원 탈퇴</a>&nbsp;&nbsp;&nbsp;
		<a href="regist">회원 목록</a>
</body>
</html>
