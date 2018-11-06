
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../includes/header.jsp"/>
<div class="bigPictureWrapper">
	<div class="bigPicture">
	</div>
</div>	
<style>

.modal a.close-modal{
	top:3px !important;
	right:3px !important;
}


.pagination{
	margin:20px 0;
}

.content{
	line-height:1.5;
}

.addReply img{
	width:15px;
	opacity:0.6;
	cursor:pointer;
}

.addReply{
	font-size:10px;
	text-align:right;
}

.getFile{
	
	padding-left:10px;
}

.re{
 	margin:10px 0 0 0;
}

section{
	margin:10px 0;
}

section button{
	margin:5px;
}
.replyer{
	display:inline-block;
	font-weight:bold;
	font-size:12px;
}

.regdate{
	float:right;
	display:inline-block;
	font-size:12px;
}

.reply{
	padding:0 10px;
}

.delContent{
	color:lightgray;
}

img{
	width:80%;
}
hr{
margin:5px;
}

.deleteReply{
	display:inline-block;
	font-size:11px;
	margin-left:10px;
	color:red;
	cursor:pointer;
}

.modifyReply{
	display:inline-block;
	font-size:11px;
	color:orange;
	cursor:pointer;
	margin-left:10px;
}

.bigPictureWrapper{
	position:absolute;
	z-index:100;
	top:0%;
	width:100%;
	display:none;
	justify-content: center;
	align-items: center;
	height:100%;
	background-color:gray;
	background:rgba(255,255,255,0.5);
}

.bigPicture{
	display:flex;
	justify-content: center;
	align-items: center;
}
</style>
<!-- Main -->
<div id="main">

	<!-- Post -->
	<section class="post">
		<header>
			<h2><c:out value="${board.title }"/></h2>
			<p><c:out value="${board.writer }"/></p>
		</header>
		<div class="imgList">
		</div>
		<p><c:out value="${board.content }"/></p>
		<hr/>
		<div class="fileList"><strong>첨부파일 :</strong></div>
		<hr/>
		<button class="button primary small" id="mord">수정/삭제</button>
		<button class="button small" style="float:right" id="list">목록</button>
			
		<div class="replyDiv">
		</div>
		
		<hr/>
		<section>
			<div class="fields">
				<div class="field">
					<label for="message">댓글쓰기</label>
					<textarea style="padding:5px" id="replyInput" rows="2"></textarea>
				</div>
			</div>
			<div class="actions">
				<button id="replyBtn" class="button small re" >댓글 입력</button>
			</div>	
		</section>
	</section>
</div>
			
<form id="modal-form" class="modal">
  <p class="modalText">글 수정이 완료되었습니다</p>
  <a href="#" rel="modal:open">Close</a>
</form>

<form id="actionForm">
	<input type="hidden" id="page" name="page" value="${pageObj.page}"/>
	<input type="hidden" id="display" name="display" value="${pageObj.display}"/>
		<input type="hidden" name="keyword" value="${pageObj.keyword}"/>
	<input type="hidden"  name="type" value="${pageObj.type}"/>
</form>


<section class="dummy" style="display:none">
	<div class="fields">
		<div class="field">
			<label class="label"></label>
			<textarea style="padding:5px" class="dummyInput" rows="2"></textarea>
		</div>
	</div>
	<div class="actions">
		<button class="button small re dummyBtn" ></button>
	</div>	
</section>	


<jsp:include page="../includes/footer.jsp"/>
<script type="text/javascript" src="../resources/reply.js"></script>
<script>
$(document).ready(function(){
	
	var form = $("#actionForm");
	var bno = "<c:out value='${board.bno }'></c:out>";
	var replyDiv = $(".replyDiv");
	var cloneS = $(".dummy").clone(true);
	var replyopen = "f";
	var currentPage = '1';
	
	
	//--------------첨부파일 본문에 뿌려줌-----------------
	(function(){
		$.getJSON("/board/fileList",{bno:bno},function(arr){
			var str="";
			var fileStr="";
			
			$(arr).each(function(i,obj){

				var viewName=obj.filename.substring(0, obj.filename.lastIndexOf("."));
				var etx = obj.filename.substring(obj.filename.lastIndexOf(".")+1);
				var fileCallPath = encodeURIComponent(obj.uploadpath+"/"+obj.uuid+"_"+viewName+"_"+etx);
				
				str += "<div class='imgOne' data-uuid='"+obj.uuid
				+"' data-filename='"+obj.filename+"."+obj.etx+"' data-uploadpath='"+obj.uploadpath+
				"'><img src='/view?fileName="+fileCallPath+"'></div>";	
				
				fileStr += "<span class='getFile' data-downName='"+obj.uploadpath+"/"+obj.uuid+"_"+viewName
				+"_"+etx+"' data-src=''>";
				fileStr += "<a href='#'>"+obj.filename+"</a></span>";
			});
			
			$(".imgList").append(str);
			$(".fileList").append(fileStr);
			
		});
		
		showList(-1);
	})();
	
	
	//---------------------댓글보여주기---------------------
	function showList(page){
			replyDiv.html("");
			replyService.getList({bno:bno, page: page||1 },function(list, param){
			
			currentPage = param.page;
			console.log(currentPage);
			
			var str="";
			if(list.length == 0 || list == null){
				return;
			}
			
			for(var i=0; i<list.length; i++){
				
				str+="<div class='replyBox' data-rno='"+list[i].rno+"'";
				
				if(list[i].dep == 1){
					str+=" style='margin-left:30px'";
				}
				
				str+="><div class='replyer'>"+list[i].replyer+"</div>";
				str+="<div class='deleteReply'>d</div>";
				str+="<div class='modifyReply'>m</div>";
				str+="<div class='regdate'>"+list[i].replydate+"</div>";
				str+="<div class='content'>"+list[i].reply+"</div>";
				
				if(list[i].dep == 0){
					str+="<div class='addReply'><img src='../resources/reply.png'></div>";
				}else{
					str+="<div style='height:23px'></div>";
				}
				str+="</div>";
			}
			
			var strP = "";
			
			if(param.count > param.display){
				strP+="<div class='pagination'>";
				
				if(param.prev){
					strP+="<li data-index='"+ (param.start-1) 
					+"'><a class='previous' href='"+(param.start - 1)
					+"'><c:out value='PREV'/></a></li>"
				}
				
				for(var i=param.start; i <= param.end; i++ ){
					
					if(currentPage == i){
						strP+="<li data-index='"+i+"'><a class='page active' href='"+i+"'>"
					}else{
						strP+="<li data-index='"+i+"'><a class='page' href='"+i+"'>"
					}
					
					strP+= i + "</a></li>"
					
				}
				
				if(param.next){
					strP+="<li data-index='"+ (param.end+1) 
					+"'><a class='next' href='"+(param.end+1)
					+"'><c:out value='Next'/></a></li>"
				}

				strP+="</div>"
			}
			
			replyDiv.append(str);
			replyDiv.append(strP);
		});
	};
	
	//------------------댓글 페이지네이션---------------------
	$(replyDiv).on("click",".pagination a",function(e){
		e.preventDefault();
		var target = $(this).attr("href")
		
		showList(target);
	})

		
	//---------------------댓글수정버튼---------------------
	$(replyDiv).on("click",".modifyReply",function(e){
		if(replyopen == "f"){
			
			$(this).parent().append(cloneS.show());
			
			$(".dummyInput").val($(this).parent().find(".content").html());
			$(".label").html("댓글 수정하기");
			$(".dummyBtn").html("댓글 수정");
			$(".dummyBtn").attr("id", "modify");
	
			replyopen = "t"
			
		}else if(replyopen == "t"){
			$(".replyDiv section").remove();
			replyopen = "f"
		}
		
	});
	
	//---------------------댓글수정완료버튼---------------------
	$("section").on("click","#modify",function(e){
		
		if($(".dummyInput").val() == ""){	return	}

		if($(".dummyInput").val().length > 255){
			alert("내용은 255자 아래로 써야 합니다");
			return;
		}
		
		var rno = $(this).parent().parent().parent().find("div").prevObject.data("rno");
		
		var reply = {
				rno : rno,
				reply : $(".dummyInput").val()
			}
			
		replyService.modify(reply,function(result){
				replyopen = "f";
				$(".dummyInput").val("");
				showList(currentPage);
		});
	});
	
	//---------------------댓글등록버튼---------------------
	$("#replyBtn").on("click",function(e){
		
		if($("#replyInput").val() == ""){	return	}
		
		if($("#replyInput").val().length > 255){
			alert("내용은 255자 아래로 써야 합니다");
			return;
		}
		
		var reply = {
			bno : bno,
			dep : 0,
			pno : 0,
			replyer : "user1",
			reply : $("#replyInput").val()
		}
		
		replyService.add(reply,function(result){
			console.log("성공@");
			$("#replyInput").val("");
			replyopen = "f";
			showList(-1);
		}); 
	});
	
	
	//---------------------댓글삭제버튼---------------------
	$(replyDiv).on("click",".deleteReply",function(){
		var rno = $(this).parent().data("rno");
		console.log(rno);
		replyService.remove(rno, function(result){
			alert("삭제했습니다");
			showList(currentPage);
		})
	});
	

	//---------------------대댓글버튼---------------------
	$(replyDiv).on("click",".addReply img",function(){

		if(replyopen == "f"){
			$(".dummyInput").val("");
			$(this).parent().append(cloneS.show());
			$(".label").html("대댓글 달기");
			$(".dummyBtn").html("대댓글 작성");
			$(".dummyBtn").attr("id", "rere");
			replyopen = "t"
		}else if(replyopen == "t"){
			$(".replyDiv section").remove();
			replyopen = "f"
		}
		
	});
	
	//---------------------대댓글등록버튼---------------------
	$("section").on("click", "#rere",function(e){
		
		if($(".dummyInput").val() == ""){	return	}
		if($(".dummyInput").val().length > 255){
			alert("내용은 255자 아래로 써야 합니다");
			return;
		}
		
		var rno = $(this).parent().parent().parent().parent().find("div").prevObject.data("rno");
		
		var reply = {
			bno : bno,
			dep : 1,
			pno : rno,
			replyer : "user1",
			reply : $(".dummyInput").val()
		}
		
		 replyService.add(reply,function(result){
			$(".dummyInput").val("");
			replyopen = "f";
			showList(currentPage);
		});
	});
	
	
	//---------------------원본이미지---------------------
	$(".imgList").on("click","div img",function(e){
		var obj = $(this);
		
		$(".bigPictureWrapper").css("display","flex").show();
		$(".bigPicture")
		.html("<img src='"+obj[0].src+"'>")
	});
	
	//---------------------이미지닫기---------------------
	$(".bigPictureWrapper").on("click",function(e){
		$(".bigPictureWrapper").hide();
	});
	
	//--------------------이미지다운----------------------
	$(".fileList").on("click", ".getFile",function(e){
		
		var downName = $(this).data("downname");
		var link = "/download?downName=" + encodeURIComponent(downName);
		self.location = link;
		
	});
	
	
	//---------------------수정 or 삭제버튼---------------------
	$(".button").on("click",function(){
		
		if($(this).attr("id") == "mord"){
			form.append("<input type='hidden' name='bno' value='"+${pageObj.bno}+"'>");
			form.attr("action","/board/modify").submit();
		
		}else if($(this).attr("id") == "list"){
			form.attr("action","/board/list").submit();
		}
	})
	
	
	//---------------------모달창---------------------
	var result = '<c:out value="${result}"/>';
	
	checkModal(result);
	history.replaceState({},null,null);
	function checkModal(result){
		if(result === '' || history.state){return;}
		if(result === 'MODIFY'){
			$('#modal-form').modal();
		}
	}
	
});
</script>
	</body>
</html>