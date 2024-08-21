window.onload = function(){

		var frm = document.getElementById('frm');
		var inputs = document.querySelectorAll("input");
		

	// 폼의 submit 이벤트 발생했을 때
	/*frm.onsubmit = function(evt){
		// 기존 이벤트 역할 막기
		evt.preventDefault();	
		evt.stopPropagation();
		
		// 유효성검사
		
		var agree = frm.agree;
		if(!agree.checked){
			alert('반드시 약관에 동의하셔야합니다');
			return;
		}
		else{
			frm.submit();
		}
	}*/
	
	// 버튼이 클릭했을 때
	var btn = document.getElementById('btn');
	btn.onclick = function(){
		
		// 유효성 검사를 해주지 않기 때문에 직접 유효성 검사 필요
		
		
		
		//frm.submit();
	}

}