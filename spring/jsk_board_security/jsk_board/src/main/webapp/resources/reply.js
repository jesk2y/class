var replyService = (function(){
	
	function getList(param, callback, error){
		var bno = param.bno
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json", function(data){
			
			if(callback){
				callback(data.list, data.param);
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