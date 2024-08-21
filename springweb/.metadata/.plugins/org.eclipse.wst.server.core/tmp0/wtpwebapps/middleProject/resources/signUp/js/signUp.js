//구매자인지 판매자인지에 따라 다른 입력폼을 제공하는 이벤트
$("select[name=customerType]").change(function(){
        var selectedValue = $(this).val();
        if (selectedValue == 1) {
            $("form").attr("action", "signUp2");
        } else if (selectedValue == 2) {
            $("form").attr("action", "signUp3");
        }
    });

	var checkAll = document.getElementById('checkAll');
	var subcheck = document.getElementsByClassName('joinCheck');
	 $('#checkAll').change(function() {
        if (this.checked) {
            $('.joinCheck').prop('checked', true);
        } else {
            $('.joinCheck').prop('checked', false);
        }
    });
    
    $('.joinCheck').change(function() {
        var checkboxes = $('.joinCheck:checked');
        var subcheck = $('.joinCheck');
        if (checkboxes.length !== subcheck.length) {
            $('#checkAll').prop('checked', false);
        } else {
            $('#checkAll').prop('checked', true);
        }
    });
   
  
    

