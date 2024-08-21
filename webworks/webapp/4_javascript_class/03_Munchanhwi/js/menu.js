/**
 * 
 */
let menu = ['더블 빅맥', '빅맥 BLT', '더블 쿼터파운더 치즈',
	'쿼터파운더 치즈', '빅맥', '맥크리스피 디럭스',
	'맥크리스피 클래식', '맥스파이시 상하이', '1955버거'];
let count = [1,1,1,1,1,1,1,1,1];
var menub = document.querySelectorAll('button')
for (let i of menub) {
	let j = 0;
	i.onclick = function(evt) {
		addjumun(evt, j);
	}
	j++;
}
function addjumun(evt, j) {
	let k = 1;
	var jumuntb = document.querySelector('.jumuntb');
	var tr = document.createElement('tr');
	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	var td3 = document.createElement('td');
	if (count[j]<2) {
		var txt1 = document.createTextNode(menu[j])
		alert(j);
		alert(menu[j]);
		var txt2 = document.createTextNode(evt.target.getAttribute('price'));
		var txt3 = document.createTextNode(count[j]);
		td1.appendChild(txt1);
		td2.appendChild(txt2);
		td3.appendChild(txt3);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		jumuntb.appendChild(tr);
		count[j]++;
	}
	else {
		txt3 = document.createTextNode(count[j]);
		count[j]++;
		td3.removeChild(td3.lastChild)
		td3.appendChild(txt3);
	}
}