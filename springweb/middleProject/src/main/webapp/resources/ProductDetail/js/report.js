$(function(){
	var userData = $('#user_id').val();
	$('.declaration-submit').click(function(){
		
		alert("신고가 접수 되었습니다.");
	});
	
	
	//신고전 로그인 상태 확인 
	$(".decalarationFrm").on("submit", function(e){
		if(!userIdcheck()){
			e.preventDefault();
		}
		
	});
	
	
	//신고전 이용약관에 대한 유효성 검사
	$(".declarationFrm").on("submit", function(event) {
		if (!checkPolicyAcceptance()) {
			event.preventDefault();
		}
	});
	
	
	//신고 취소 했을때의 이벤트 발생
	$('exit_report').click(function(){
		window.location.href = "mainPage";
	});
	
	//로그인을 하지 않고 신고 버튼을 눌렀을때의 이벤트 발생 
	
	function userIdcheck (){
	if (userData == "") {
		alert("회원만 이용 가능합니다.");
		window.location.href="/middleTest/login";
		return false;
	}
	return true;
	
	}
	
	//체크 박스에 체크가 되어있는지 확인 
	function checkPolicyAcceptance (){
		if (!$('.validate-checkbox1').is(':checked') || !$('.validate-checkbox2').is(':checked')) {
		alert("매물신고 운영 정책과 매물신고 매뉴얼 확인 체크해주시길 바랍니다.");
		$('.validate-checkbox1').focus();
		return false;
	}
	return true;
	
	}


	//관리자 페이지에서 허위매물 신고에 대한 수락 버튼을 눌렀을때
	$('.btn_declarationDelete_property').click(function(){
		
		
		var declaration_num =$(this).closest('tr').find('td:first-child').text().trim();
		var property_id = $(this).closest('tr').find('td:nth-child(2)').text().trim()
		var param = {
		declaration_num:declaration_num
		,property_id:property_id
			
		};
		
		
		$.ajax({
			type:"get",
			url:"declarationPropertyDelete",
			data:param,
			success:function(result){
			alert("삭제 완료");
			window.location.href="/middleTest/manage/managereport";
			
			},
			error:function(error){
			console.error(error);
			alert("삭제 실패: " + param);
			}
		});
		
	});
	
	
	
	
	//관리자가 반려 번튼을 눌렀을 때 
	$('.btn_declarationDelete').click(function(){
		
		
		var declaration_num = $(this).closest('tr').find('td:first-child').text().trim();
		
		$.ajax({
				type:"get",
				url:"declarationDelete",
				data:{declaration_num:declaration_num},
				success:function(result){
				alert("반려 완료");
				
				window.location.href="/middleTest/manage/managereport";
			},
				error:function(error){
				console.error(error);
				alert("반려 실패: " + declaration_num);
			}
		});
		
	});
	
})