	$(".btn[name=findIdButton]").click(function(event){
	
		var inputEmail = $(".findId_email").val();
		if (inputEmail.length < 5) {
			alert("이메일을 올바르게 입력해주세요.");
			
			event.preventDefault();
		}else{
			$.ajax({
		    type: "POST",
		    url: "findId", // 서버의 로그인 엔드포인트 URL
		    data: {inputEmail},
		    dataType: "text",
		    success:function(result){
		    		//alert(result);
					if(result == "??" ){
						alert("해당 이메일을 가진 아이디가 없습니다. 계정생성 페이지로 이동하겠습니다.")
						window.location.href = "signUp1";
					}else {
					alert(inputEmail+"에 해당하는 ID는 '"+result+"' 입니다.");
					}
					
			},error: function(err) {
				console.log(err);
			}
			});
		}
	});
	
	// enter를 눌렀을 때 이벤트 발생 
	$('.findAccount-Id').keydown(function(event){
		var inputEmail = $(".findId_email").val();
		if (event.key === 'Enter') {
			event.preventDefault();
			$.ajax({
		    type: "POST",
		    url: "findId", // 서버의 로그인 엔드포인트 URL
		    data: {inputEmail},
		    dataType: "text",
		    success:function(result){
		    		//alert(result);
					if(result == "??" ){
						alert("해당 이메일을 가진 아이디가 없습니다. 계정생성 페이지로 이동하겠습니다.")
						window.location.href = "signUp1";
					}else {
					alert(inputEmail+"에 해당하는 ID는 '"+result+"' 입니다.");
					}
					
			},error: function(err) {
				console.log(err);
			}
			});// end of ajax
		}
	})// enter 를 누르며 ㄴ
	
	
	
	$(".btn[name=findPassButton]").click(function(event){
		
		var inputPwId = $(".findPass[name=findPass_id]").val();
		var inputPwEmail = $(".findPass[name=findPass_email]").val();
		if (inputPwEmail.length < 5 || inputPwId.length < 2) {
			alert("형식에 맞게 올바르게 입력해주세요.");
			
			event.preventDefault();
		}else{
			$.ajax({
		    type: "POST",
		    url: "fixPass", // 서버의 로그인 엔드포인트 URL
		    data: { inputPwId: inputPwId,
		    		inputPwEmail: inputPwEmail
		    },
		    dataType: "json",
		    success:function(result){
				if(result){
					alert("해당 이메일: "+inputPwEmail+" 과 \n아이디: "+inputPwId+"의 비밀번호 변경 페이지로 이동하겠습니다.")
					window.open("changePass", "_blank", "width=500,height=300");
					location.href = "/middleTest/login";
				}else {
					alert("해당 정보가 없습니다. 회원가입 페이지로 이동하겠습니다.")
					window.location.href = "signUp1"
				}	
			},error: function(err) {
				console.log(err);
			}
			});// end of ajax
		}
	});// end of pass-click event
	
	
	$(".btn[name=changeAccountPass]").click(function(event){
		
		var inputNewPw = $(".changeNewPass[name=changeNewPass]").val();
		var inputNewPwChk = $(".changeNewPass[name=changeNewPassChk]").val();
		// 수정해해요 var rememberId =$(".changeNewPass[name=changeNewPassChk]").val();
		if(inputNewPw.length < 2 && inputNewPwChk.length < 2){
			alert("비밀번호를 입력해주세요");
			
			event.preventDefault();
		}else if (inputNewPw != inputNewPwChk) {
			alert("비밀번호가 같지않습니다.");
			
			event.preventDefault();
		}else{
			$.ajax({
		    type: "POST",
		    url: "updatePass", // 서버의 로그인 엔드포인트 URL
		    data: { inputNewPw: inputNewPw },
		    dataType: "json",
		    success:function(result){
				if(result == 1){
					alert("해당 비밀번호로 변경되었습니다.")
					window.close();
					
				}	
			},error: function(err) {
				console.log(err);
			}
			});
		}
	});