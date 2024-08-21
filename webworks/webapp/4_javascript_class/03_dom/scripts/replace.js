
// window.onload = function(){	
		
  alert('yes3');
  var list = document.getElementById('list');
  var pic = document.getElementById('pic');
  var del = document.getElementById('del');

  // 리스트에서 선택(클릭했을 때)
  list.onclick = function(evt){
	  //console.log(evt.target);
	  var isbn = evt.target.getAttribute('data-isbn');
	  //alert(isbn);
	  
	  //
	  var img = document.createElement('img');
	  img.width = 100;
	  img.height = 150;
	  img.src = 'images/' + isbn + '.jpg';
	  
	  if(pic.getElementsByTagName('img').length>0){
		  pic.replaceChild(img, pic.lastChild)
	  }else {
		  pic.appendChild(img);
		  del.disabled = false;
	  }
	  /*pic.appendChild(img);*/
	  
  }

   // 삭제 버튼 누르면 pic 아래 자식(img 태그)를 지운다
 del.onclick = function(evt){
	pic.removeChild(pic.lastChild);
 }
  
//};
