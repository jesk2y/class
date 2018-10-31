var replyService = (function(){
	
	function getList(bno, callback, error){
		$.getJSON("/replies/pages/" + bno + ".json", function(data){
			if(callback){
				callback(data);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	function remove(rno, callback,error){
		$.ajax({
			url:'/replies/'+rno,
			type:'post',
			success:function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function add(reply, callback, error){
		$.ajax({
			url:'/replies/new',
			type:'post',
			data:JSON.stringify(reply),
			contentType:"application/json; charset=UTF-8",
			success:function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}
	
	function modify(reply, callback, error){
		$.ajax({
			url:'/replies/' + reply.rno,
			type:'post',
			data:JSON.stringify(reply),
			contentType:"application/json; charset=UTF-8",
			success:function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}
	
	return{
		modify : modify,
		remove : remove,
		add : add,
		getList : getList
	}
	
})();