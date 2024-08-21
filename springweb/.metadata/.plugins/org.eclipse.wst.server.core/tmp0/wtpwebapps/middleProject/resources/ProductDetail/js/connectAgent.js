$(function(){
 
 	// 중개인 버튼 클릭 시, overlay 실행
	$(".open-btn").click(function() {
	    $(".overlay").fadeIn();
	});
	// 취소 버튼 클릭 시, overlay 종료
	$(".close-btn").click(function() {
	    $(".overlay").fadeOut();
	});
	// 오버레이 내부를 클릭할 때 이벤트 전파를 방지합니다.
	$(".overlay-inner").click(function(event){
	    event.stopPropagation();
	});
	
	// 예약관리 지피티썜 ------------------------------------------------	
	
	// 시간 선택 시 , 전송 값 바뀌는 event
	$('.reservation_time').change(function(){
		// 일단 회원 아니면 쳐내
		var userData = $('#user_id').val();
		var dateData = $('#reservation_date').val();
		
	    if(userData == ""){
			alert("회원 가입 후 진행해주세요.");
			event.stopPropagation();
        	event.preventDefault();
			window.location.href = "login";
		}else if(dateData==""){
		// 날짜를 먼저 선택하게 유도하는 함수
			alert("날짜를 먼저 선택해주세요.");
			$('#time-slot').val("00:00");
			$('#reservation_time').val("");
			event.stopPropagation();
        	event.preventDefault();
		}else 
		
	    // 선택한 시간 및 날짜 업데이트
	    $('#reservation_date').val(date);
	    $('#reservation_time').val(time);
	    
	});
	
	
	// option 시간 선택 시, 전송 값 설정,바뀌는 event
	$('.time-slot').click(function(){
		
        var date = $('#selected-date').val();
        var time = $(this).text();
		
        // 예약 폼 표시
        $('#time-slot').show();
        // 선택한 시간 및 날짜 업데이트
        $('#reservation_date').val(date);
        $('#reservation_time').val(time);
	});

 	
 	// 내일 모레 부터 달력 선택 가능하게 해주는 기능 : Set minimum date to tomorrow + 1
	var today = new Date();
    var tomorrow = new Date(today);
    tomorrow.setDate(tomorrow.getDate() + 2);
    var dd = String(tomorrow.getDate()).padStart(2, '0'); // 여기부터 모르겟네
    var mm = String(tomorrow.getMonth() + 1).padStart(2, '0'); // January is 0!
    var yyyy = tomorrow.getFullYear();
    var minDate = yyyy + '-' + mm + '-' + dd;

	$('#selected-date').attr('min', minDate);
	 	
 	$('#selected-date').change(function(){	
        var selectedDate = new Date($(this).val());
        var day = selectedDate.getDay();
		
		// 이벤트 진행 전, 회원 여부 확인
		var userData = $('#user_id').val();
		var agent_id = $('#agent_id').val();
	    if(userData == ""){
			alert("회원 가입 후 진행해주세요.");
			event.stopPropagation();
        	event.preventDefault();
			window.location.href = "login";
		}else if(day === 0 || day === 6) {
        // Check if the selected date is a weekend (Saturday: 6, Sunday: 0)
           alert("주말은 선택할 수 없습니다. 다른 날짜를 선택해 주세요.");
           $(this).val('');
           $('#reservation_date').val('');
        } else {
           $('#reservation_date').val($(this).val());
		// 선택한 날짜에 예약된 시간 조회 및 업데이트
           $.ajax({
           url: 'getReservedTime',
           type:'GET',
           data:{ reservation_date: $(this).val(), agent_id: agent_id },
           dataType:"json",
           success: function(result) {
           		
           var timeSlotOptions = ["선택","09:30:00", "10:30:00", "11:30:00", "12:30:00", "14:30:00", "15:30:00", "16:30:00", "17:30:00", "18:30:00"];
            	
           // result가 문자열인 경우, JSON.parse를 사용하여 배열로 변환
           if (typeof result === 'string') {
           		result = JSON.parse(result);
           }
            	  
           // 예약된 시간을 제외한 사용 가능한 시간 슬롯을 필터링
           var availableTimes = timeSlotOptions.filter(function(time) {
           		return !result.includes(time);
           });

           var timeSlotSelect = $('#time-slot');
           timeSlotSelect.empty();

           availableTimes.forEach(function(time) {
           timeSlotSelect.append('<option class="time-slot" value="' + time + '">' + time + '</option>');
           });
            	
           },// end of success
           error: function() {
           		alert('시간 슬롯을 불러오는데 실패했습니다.');
           }// end of error
           }); // end of select-timeOption.ajax
           
        }// end of if문
    });// end of date select event
	
	// 시간 선택 시, 값 바꿔주는 event
	$('#time-slot').change(function(){
		
    	var selectedTime = $(this).val();
        // 이벤트 진행 전, 회원 여부 확인
		var userData = $('#user_id').val();
		var dateData = $('#reservation_date').val();
	    if(userData == ""){
			alert("회원 가입 후 진행해주세요.");
			event.stopPropagation();
        	event.preventDefault();
			window.location.href = "login";
		}else {
        $('#reservation_time').val(selectedTime);
        }
	});
	
	// 예약 정보 전송
    $('#submit-btn').click(function(event){
    
    	event.stopPropagation();
        event.preventDefault();
        
        var userData = $('#user_id').val();
        var dateData = $('#reservation_date').val();
		var timeData = $('#reservation_time').val();
		var formData = $('#reservation-form').serialize();
		
		//alert(userData+"유저, "+dateData+"날짜, 시간"+timeData);
		
		// 
		if(userData == ""){
			alert("회원 가입 후 진행해주세요.");
			event.stopPropagation();
        	event.preventDefault();
			window.location.href = "login";
		}else if(dateData == ""||timeData == ""){
			alert("날짜 확인 후 진행해주세요.");
			event.stopPropagation();
        	event.preventDefault();
		}else{
		
		$.ajax({
		type:"get"
		,url:"reservationInsert"
		,data: formData
		,success:function(result){
			
			alert("예약되었습니다2.");
			location.href ="/middleTest/customerpage/reservAdmin";
       	}
       ,error: function(err){
			console.log(err);
		}
       });
       
       // 오버레이 닫아버리기
       $(".overlay").fadeOut();
       }
       
       
	});
 
});