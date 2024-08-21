<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>9_review</title>
<h1>회원가입서 작성하기</h1>
<link type="text/css" href="./css/info.css/" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="./js/info.js"></script>
</head>
<body>
 <div class="wrapper">
        <form id="frmtest" method='get' action='infoSave.jsp'>
            <div class="form-field">
                <label class="label-form" for="username">성명</label>
                <input type="text" class="form-control" name="username" id="username" required>
            </div>

            <div class="form-field">
                <label class="label-form" for="password">비밀번호</label>
                <input type="password" class="form-control" name="password" id="password" required>
            </div>

            <div class="form-field">
                <label class="label-form" for="password_confirm">비밀번호 재확인</label>
                <input type="password" class="form-control" name="password_confirm" id="password_confirm" required>
            </div>

            <div class="form-field">
                <label class="label-form" for="email">이메일 주소</label>
                <input type="email" class="form-control" name="email" id="email" required>
            </div>

            <div class="form-field">
                <label class="label-form" for="tel">연락처</label>
                <input type="tel" class="form-control" name="tel" id="tel" required>
            </div>

            <div class="form-field">
            	<label for="addr">주소</label>
                <input type='text' id='addr' readonly> <input type='button' id='btn_search' value='주소찾기'>
                <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            </div>

            <div class="form-field">
                <button type="submit" class="button-submit">제출하기</button>
            </div>
        </form>
    </div>
</form>		
</body>
</html>