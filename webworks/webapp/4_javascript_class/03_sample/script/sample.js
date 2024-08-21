/**
 *
 *
 */
var tdlist = document.querySelectorAll('.item');
for(let j of tdlist){
	j.onclick = function(){
	//	alert('ok');
	//	alert(this.getAttribute('data-price'));
	//	alert(evt.target.getAttribute('data-price'));
	    alert(j.getAttribute('data-price'));
	}
}