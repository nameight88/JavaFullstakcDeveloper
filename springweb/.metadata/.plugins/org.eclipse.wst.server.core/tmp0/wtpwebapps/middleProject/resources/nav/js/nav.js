

// 실패
//$(function(){
//    $('#navbarResponsive .nav-item').each(function() {
//        $(this).click(function(evt) {
//        	alert("oo");
//        	//evt.stopPropagation();
//        	evt.preventDefault();
//        	$('#navbarResponsive .nav-item').removeClass('active'); 
//            $(this).addClass('active'); 
//            
//        });
//    });
//});



$(function(){
    // 페이지 로드 시 현재 페이지에 해당하는 네비게이션 항목에 'active' 클래스 추가
    var currentPath = window.location.pathname;
    $('#navbarResponsive .nav-item').each(function() {
        var itemPath = $(this).find('a').attr('href');
        if (itemPath === currentPath) {
        	$('#navbarResponsive .nav-item').removeClass('active'); 
            $(this).addClass('active');
        }
    
    });

//    // 네비게이션 항목 클릭 이벤트 처리
//    $('#navbarResponsive .nav-item').click(function(evt) {
//        // 'active' 클래스를 모든 항목에서 제거
//        $('#navbarResponsive .nav-item').removeClass('active'); 
//        // 클릭된 항목에 'active' 클래스 추가
//        $(this).addClass('active');
//    });
});