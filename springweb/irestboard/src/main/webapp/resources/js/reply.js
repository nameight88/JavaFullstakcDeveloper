
$(function(){
	$("#replyConfirm").click(function(){
	
	var param={
		bno : $('#bno').val(),
		replyer : $('#replyer').val(),
		reply : $('#reply').val()
	};
	
	/*
	let param_test={
	$('#replyFrm').serialize();
	};
	*/
				$.ajax({
					type 	:	'post',
					data	:	param,
					url  	:	'../replies/new',
					success :	function(result){
						alert(result);
						$('#reply').val('');
						replyList();
					},
					error 	:	function(err){
						alert('error');
						console.log(err);
					}
				});
	});
	
	// 댓글목록을 서버에서 가지고 와서 출력
	replyList();
	function replyList(){
		$.ajax({
			 type     : 'get'
			,url 	  :	'../replies'
			,data 	  : {bno : $('#bno').val()}
			//여기까지 값을 받아오기 위해서 필요한 부분
			,dataType : 'json'
			,success  : function(result){
				console.log(result);
				var replyList = $('#replyList');
				replyList.empty();
				for(row of result){
					var tr =$('<tr/>');
					
					var rno = $('<td/>').text(row['rno']);
					tr.append(rno);
					
					var replyer = $('<td/>').text(row['replyer']);
					tr.append(replyer);
					
					var reply = $('<td/>').text(row['reply']);
					tr.append(reply);
					
					var modifyBtn = $('<td/>').html('<button class="modify">수정</button>');
					tr.append(modifyBtn);
					
					var deleteBtn = $('<td/>').html('<button class="delete">삭제</button>');
					tr.append(deleteBtn);
					
					replyList.append(tr);
				}
			}
			,erorr	  : function(err){
				console.log(err);
			}
		});
		
	}
	
	$("#replyList").on('click','.delete',function(){
		//alert('delete');
		var rno = $(this).parents('tr').children().eq(0).text();
		//alert(rno);
		
		$.ajax({
			type : 'delete'
			,url : '../replies/'+rno
			, success : function(result){
				replyList();
			}
			, error: function(err){
				alert("삭제실패");
				console.log(err);
			}
		});
	
	});


	$("#replyList").on('click','.modify',function(){
		//alert('modify');
		var rno = $(this).parents('tr').children().eq(0).text();
		var btnText = $(this).text();
		
		if(btnText=="수정"){
		
			var replytd = $(this).parents('tr').children().eq(2);
			var replyText = $(this).parents('tr').children().eq(2).text();
			//alert(replyText);
			replytd.text('');
			replytd.append('<input type="text" name="reply" value="'+replyText+'">');
			
			
			
			var replytd = $(this).parents('tr').children().eq(1);
			var replyer = $(this).parents('tr').children().eq(1).text();
			//alert(replyText);
			replytd.text('');
			replytd.append('<input type="text" name="replyer" value="'+replyer+'">');
			
			$(this).text('수정하기');
			
		}else if(btnText=='수정하기'){
		//	alert("진짜 서버에서 수정");
			var replyer = $(this).parents('tr').find('input').eq(0).val();
			var reply = $(this).parents('tr').find('input').eq(1).val();
			
			alert(replyer+reply);
			
			var param = {
				rno : rno
				, replyer : replyer
				, reply : reply
			}
			
			$.ajax({
				type : 'post'
				,data : param
				,url : '../replies'+rno
				
				,success :function(result){
					replyList();
				}
				,error : function(err){
				alert("수정실패");
				console.log(err);
				}
			})
		}
	});

});