$(function () {
    //(1)오늘 날짜 출력
    let now_date = new Date();
    let year = now_date.getFullYear();
    let month = now_date.getMonth() + 1;
    let date = now_date.getDate();
    $('#date_wrap>.year').text(year)

    $('#date_wrap>.month').text(month)

    $('#date_wrap>.date').text(date)

    //(2) 포커스 가면 ‘검색어를 입력하세요’를 안보이고 다시 포커스가 없으면 다시 출력 
    $('#keyword').focus(function () {
       $('#keyword').css("background-position","0 -500px")
    });

    $('#keyword').blur(function(){
        $('#keyword').css("background-position","0 0")
    });
    //(3) 탭팬 구현 
    var tabmenu = $("#tabmenu");
    var allA = tabmenu.find('dt > a'); // a태그들
    var overA = allA.filter('_over');  // over을 가지고 있는 a태그
    var panel = overA.parent().next(); // over을갖고잇는 판넬
    
    allA.show();
    panel.show();
    
    allA.click(function(e){
       e.preventDefault();
       
       let clickA = $(this);
       let clickP = clickA.parent().next();
       
       allA.parent().next().hide();
       clickP.show();      
       
       allA.each(function() {
         var imgSrc = $(this).find('img').attr('src');
         $(this).find('img').attr('src', imgSrc.replace("over","out"));
        });
 
        // 클릭한 탭의 이미지를 'over' 이미지로 변경합니다.
        var clickImgSrc = clickA.find('img').attr('src');
        clickA.find('img').attr('src', clickImgSrc.replace("out", "over"));
       
       overA = clickA;
         panel = clickP;
       
       
    });
    //(4) 이미지슬라이드 구현 

   $('#best_bg > ul').bxSlider({
     minSlides : 4
    ,maxSlides : 4
    ,slideMargin :100
    ,slideWidth : 100
    ,moveSlides :1
    ,goToNextSlide:$('.next_btn>a')
   
    })
    
   

    //(5) [로그인]을 누르면 로그인 창이 보이고 [Close]를 누르면 다시 안 보임 
    $('.login_wrap > a > img').click(function(){
        $('#login_f').css({
            top:25
        });
    });

    $('p.login_close_btn > a > img').click(function(){
        $('#login_f').css({
            top:-500
        });
    })
    //(6) [전체메뉴]를 선택하면 전체메뉴가 보이고 [Close] 누르면 다시 안 보임 
    $('#total_btn > a > img').click(function(){
        $('#total_menu').show();
    });
    $('#total_close').click(function(){
        $('#total_menu').hide();
    })
    //(7) 그 외 추가적으로 구현하면 해당 화면 캡쳐 파일을 추가로 업로드 합니다.
    
})


