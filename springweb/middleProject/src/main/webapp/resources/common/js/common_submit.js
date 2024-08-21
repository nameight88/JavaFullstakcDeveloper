//회원가입 submit 전 유효성 검사
$(".signupForm").submit(function() {
	var result = checkBeforeSubmit();
	if (result==true) {
		alert("회원가입이 완료되었습니다!");
	}
	return result;
});

//회원정보 수정 submit 전 유효성 검사 ------------------------------------------------------------------
$(".modifySubmit").submit(function() {
	var result = checkBeforeSubmit();
	
	if (result==true) {
		alert("회원정보 수정이 완료되었습니다.");
	}
	
	return result;
}) // end of sample

// 아이디 입력 후, 중복 검사 --------------------------------------------------------------------------
$('.idCheck').click(function(){

	var checkBeforeId = $(".form-control[name='user_id']").val();
	// 아이디가 공백일 경우
	if (checkBeforeId.length < 2) {
		alert("ID를 형식에 맞춰 입력하세요.");
	// admin manager 입력방지*(일단 대문자 소문자만)
	}else if(checkBeforeId.toLowerCase().includes("admin")||checkBeforeId.toUpperCase().includes("admin")){
		alert("포함할 수 없는 단어가 들어가있습니다.");
	}else if(checkBeforeId.toLowerCase().includes("manager")||checkBeforeId.toUpperCase().includes("manager")){
		alert("포함할 수 없는 단어가 들어가있습니다.");
	}else{
	// 아이디 중복 검사
		$.ajax({
	        url:"userIdCheck.do",
	        type:"post",
	        data:{ checkBeforeId },
	        dataType: "json",
	        success:function(result){
		        if(result){
		        	alert("중복된 아이디가 없습니다.");
		        	$(".resultIdMessage").text("중복된 아이디가 없습니다.").css("color", "green").css("font-weight", "bold").css("font-size", "14px");
		        	$('.id-checkbox').prop('checked', true)
		            $(".form-control[name='user_id']").val();
		        }else{    
		        	alert("이미 사용중인 아이디입니다. 다시 입력해주세요.")
		     		$(".resultIdMessage").text("이미 사용 중인 아이디입니다.").css("color", "red").css("font-weight", "bold").css("font-size", "14px");
		            $(".form-control[name='user_id']").val("")
		            $('.id-checkbox').prop('checked', false);  
		        }
		    },error: function(error) {
	        	console.log(error);
	    	}   
	    });// end of ajax	
	}// end of if문

});// end of 'ID-Check' click event

// 비밀번호 상호작용 -------------------------------------------------------------------------------------
// 비밀번호 입력 시, 비밀번호 확인과 값 비교 - 1
$(".form-control[name='user_password']").keyup(function(){
	var passcheck = $(".form-control[name='user_password']").val();
	var pass = $(".form-control[name='user_passwordChk']").val();
	
	if(pass.length < 2){
		$(".resultPassMessage").text("비밀번호 양식에 맞춰주세요.").css("color", "orange").css("font-weight", "bold").css("font-size", "14px");
	}else if (passcheck !== pass) {
    	$(".resultPassMessage").text("비밀번호 확인란을 확인해주세요.").css("color", "red").css("font-weight", "bold").css("font-size", "14px");
	}else if(passcheck == pass){
		$(".resultPassMessage").text("비밀번호가 일치합니다.").css("color", "green").css("font-weight", "bold").css("font-size", "14px");
	}
});

// 비밀번호 확인 입력 시, 비밀번호와  값 비교 - 2
$(".form-control[name='user_passwordChk']").keyup(function(){
	var passcheck = $(".form-control[name='user_password']").val();
	var pass = $(".form-control[name='user_passwordChk']").val();
	
	if(pass.length < 2){
		$(".resultPassMessage").text("비밀번호 양식에 맞춰주세요.").css("color", "orange").css("font-weight", "bold").css("font-size", "14px");
	}else if (passcheck !== pass) {
    	$(".resultPassMessage").text("비밀번호와 일치하지 않습니다.").css("color", "red").css("font-weight", "bold").css("font-size", "14px");
    	result = false;
    	return result;
	}else if(passcheck == pass){
		$(".resultPassMessage").text("비밀번호와 일치합니다.").css("color", "green").css("font-weight", "bold").css("font-size", "14px");
	}
});
// 비밀번호 확인 끝

// 이메일 중복확인 -------------------------------------------------------------------------------
$(".form-control[name='user_email']").keyup(function(){
	var checkEmail = $(".form-control[name='user_email']").val();
	var emailRef = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
	
	if(!emailRef.test(checkEmail)){
		$(".resultMessage").text("이메일양식에 맞춰주세요.").css("color", "orange").css("font-weight", "bold").css("font-size", "14px");
	}else{
		$.ajax({
		        url:"userEmailCheck.do",
		        type:"post",
		        data:{ checkEmail },
		        dataType: "json",
		        success:function(result){
			         if(result) {
	                    $(".resultMessage").text("사용 가능한 이메일입니다.").css("color", "green").css("font-weight", "bold").css("font-size", "14px");
	                } else {
	                    $(".resultMessage").text("이미 사용 중인 이메일입니다.").css("color", "red").css("font-weight", "bold").css("font-size", "14px");
	                    setTimeout(function(){
	                    $(".form-control[name='user_email']").val("");}, 500); // 0.5초 후에 실행될 코드
	                }
			    },error: function(error) {
		        	console.error(error);
		    	}   
		    });// end of ajax
	}
});// end of email-check event

//회원가입, 회원정보 수정 submit 전 유효성 검사하는 함수
function checkBeforeSubmit() {
	var formControls = $(".form-control");
	var result = true;
	
	//제출 시 null값이 존재하는지 확인하는 유효성 검사
	for (var i=0; i<formControls.length; i++) { 
		console.log(formControls[i].value);
		if (formControls[i].value=="") {
			alert("모든 값이 입력되지 않았습니다.");
			formControls[i].focus();
			result = false;
			
			return result;
		}
	}
	
	// 비밀번호 체크
	var passcheck = $(".form-control[name='user_password']").val();
	var pass = $(".form-control[name='user_passwordChk']").val();
	if (passcheck !== pass) {
    	alert("비밀번호가 다릅니다.");
    	$(".resultMessage").text("비밀번호와 일치하지 않습니다.").css("color", "red").css("font-weight", "bold").css("font-size", "14px");
    	result = false;
    	return result;
	}else if(passcheck == pass){
		$(".resultPassMessage").text("비밀번호와 일치합니다.").css("color", "green").css("font-weight", "bold").css("font-size", "14px");
	}
	
	//전화번호 형식 유효성 검사
	var regPhone = /^\d{3}-\d{3,4}-\d{4}$/;
	var inputCustomerType = $(".form-control[name=customerType]");
	var inputCustomerPhone = $(".form-control[name=user_phone]");
	
	if (inputCustomerType.val()==2) {
		var inputCompanyPhone = $(".form-control[name=companyPhone]");
		if (!regPhone.test(inputCustomerPhone.val())||!regPhone.test(inputCompanyPhone.val())) {
			alert("휴대전화 형식을 맞춰주세요");
			result = false;
		}
	}
	else {
		if (!regPhone.test(inputCustomerPhone.val())) {
			alert("휴대전화 형식을 맞춰주세요");
			result = false;
		}
	}
	
	//아이디 중복확인 검사 필수
	var idCheckBox = $('.id-checkbox').is(':checked');
	if(!idCheckBox){
		alert("ID 중복을 확인해주세요");
		result = false;
	}
	return result;
} 
