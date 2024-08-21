var replyService = (function() {
	
	function add(reply, callback, error) {
		console.log("add reply........");
		
		$.ajax({
			type : 'POST',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					//error(er);
					confirm("권한이 없습니다.");
				}
			}
		})
	}
	
	function getList(param, callback, error) {
		
		var product_code = param.product_code;
		var page = param.page || 1;
		
		$.getJSON("replies/pages/" + product_code + "/" + page + ".json",
				function(data) {
				if(callback) {
					callback(data.replyCount, data.list);
				}
		}).fail(function(xhr, status, err) {
			if(error) {
				error();
			}
		});
	}
	
	function remove(review_code, callback, error) {
		
		$.ajax({
			type : 'delete',
			url : '/replies/' + review_code,
			success : function(deleteResult, status, xhr) {
				if(callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	}
	
	function update(reply, callback, error) {
		
		$.ajax({
			type : 'PUT',
			url : '/replies/' + reply.review_code,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	}
	
	function get(review_code, callback, error) {
		
		$.get("/replies/" + review_code + ".json", function(result) {
			
			if(callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			
			if(error) {
				error();
			}
		});
	}
	
	function displayTime(timeValue) {
		var today = new Date();
		
		var gap = today.getTime() - timeValue;
		
		var dateObj = new Date(timeValue);
		var str = "";
		
		if(gap < (1000 * 60 * 60 * 24)) {
			
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return  [ (hh > 9 ? '' : '0') + hh, ":", (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
		} else {
			
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return [yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd].join('');
		}
	}

	return {
		add : add,
		remove : remove,
		update : update,
		get : get,
		getList : getList,
		displayTime : displayTime
	};
})();