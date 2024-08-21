

$(function(){
	
	$("button[name='update']").click(function(){
		
		var propertyId = $(this).closest("tr").find("td:first").text();
		//alert("수정할 매물의 아이디: " + propertyId);
		
		location.href = "agentDetail?id=" + propertyId;
		
	});
	
	
	$("button[name='delte']").click(function(){
		
		var propertyId = $(this).closest("tr").find("td:first").text();
		alert("삭제할 매물의 아이디 " + propertyId +"삭제하시겠습니까?");
		
		location.href = "agentDelete?id=" + propertyId;
		
	});

})