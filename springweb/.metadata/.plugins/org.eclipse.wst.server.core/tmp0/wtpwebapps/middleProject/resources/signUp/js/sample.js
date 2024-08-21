/**
 * 
 */
 window.onload = function() {
		var Adult = document.getElementById("Adult");
		var Child = document.getElementById("Child");
		var Baby = document.getElementById("Baby");
		var total = document.getElementById("total");
		var totalsum = 0;
		
		Adult.onchange = function() {
			var anum = Adult.value;
			totalsum += anum * 39000;

			total.value = totalsum;
		}

		Child.onchange = function() {
			var cnum = Child.value;
			totalsum += cnum * 29000;

			total.value = totalsum;
		}

		Baby.onchange = function() {
			var bnum = Baby.value;
			totalsum += bnum * 19000;

			total.value = totalsum;
		}
		frm.name.onchange = function() {
			const name = frm.name.value;
			const ref = /^[가-힣]{2,5}$/;

			if (!ref.test(name)) {
				alert("이름은 2자에서 5자 사이의 한글로 입력해주세요.");
				return;
			}

			return true;

		}

		frm.sung.onchange = function() {
			const sung = frm.sung.value
			const ref = /^[A-Za-z]{2,10}$/;

			if (!ref.test(sung)) {
				alert("성은 2~10자 사이의 영어로 입력해주세요.");
				return;
			}
			return true;
		}

		frm.eume.onchange = function() {
			const eume = frm.eume.value
			const ref = /^[A-Za-z]{2,20}$/;

			if (!ref.test(eume)) {
				alert("이름은 2~20자 사이의 영어로 입력해주세요.");
				return;
			}
			return true;
		}

		frm.phone1.onchange = function() {

			const phone1 = frm.phone1.value;
			const ref = /^[0-9]{2,3}$/;

			if (!ref.test(phone1)) {
				alert("전화번호 앞자리는 2~3 숫자로 입력");
				return;
			}
			return true;

		}

		frm.phone2.onchange = function() {

			const phone2 = frm.phone2.value;
			const ref = /^[0-9]{3,4}$/;
			
			if (!ref.test(phone2)) {
				alert("전화번호 앞자리 4개 숫자로 입력");
				return;
			}
			return true;

		}

		frm.phone3.onchange = function() {

			const phone3 = frm.phone3.value;
			const ref = /^[0-9]{4}$/;

			if (!ref.test(phone3)) {
				alert("전화번호 뒷자리 4개 숫자로 입력");
				return;
			}
			return true;

		}
		
		frm.email.onchange = function(){
			const email = frm.email.value;
			const ref = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
			
			if(!ref.test(email)){
				alert("이메일형식 올바르지 않음")
				return;
			}
			return true;
			
		}
		frm.sex.onchange = function(){
			
		}

		
		
		
		frm.bb.onclick = function(evt) {
			
			evt.preventDefault();
			evt.stopPropagation();

			var checkBox = document.getElementById("checkBox");
			var checkBox2 = document.getElementById("checkBox2");

			const is_checked = checkbox.checked;
			const is_checked2 = checkbox2.checked;

			if (is_checked == true && is_checked2 == true) {
				alert("성공");
			} else {
				alert("체크해라");
				// 체크 안했을때 넘어가면 안되기 때문에 
				return;
			}
			
			const email = frm.email.value;
			const ref = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
			
			if(!ref.test(email)){
				alert("이메일형식 올바르지 않음")
				return;
			}
			
			// 넘김
			document.getElementById("frm").submit();

		}
		

	}