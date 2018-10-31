
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
.re{
 	margin:10px 0 0 0;
}

section{
	margin:30px 0 0 0;
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


<section id="dummy" style="display:none">
	<div class="fields">
		<div class="field">
			<label>댓글수정</label>
			<textarea style="padding:5px" id="modifyInput" rows="2"></textarea>
		</div>
	</div>
	<div class="actions">
		<button id="modifyBtn" class="button small re" >댓글 수정</button>
	</div>	
</section>	


<jsp:include page="../includes/footer.jsp"/>
<script type="text/javascript" src="../resources/reply.js"></script>
<script>
$(document).ready(function(){
	
	var form = $("#actionForm");
	var bno = "<c:out value='${board.bno }'></c:out>";
	var replyDiv = $(".replyDiv");
	var cloneS = $("#dummy").clone(true);
	var replyopen = "f";
	
	(function(){
		$.getJSON("/board/fileList",{bno:bno},function(arr){
			var str="";
			$(arr).each(function(i,obj){

				var viewName=obj.filename.substring(0, obj.filename.lastIndexOf("."));
				var etx = obj.filename.substring(obj.filename.lastIndexOf(".")+1);
				var fileCallPath = encodeURIComponent(obj.uploadpath+"/"+obj.uuid+"_"+viewName+"_"+etx);
				
				str += "<div class='imgOne' data-uuid='"+obj.uuid
				+"' data-filename='"+obj.filename+"."+obj.etx+"' data-uploadpath='"+obj.uploadpath+
				"'><img src='/view?fileName="+fileCallPath+"'></div>";				
			});
			$(".imgList").append(str);
		});
		
		showList();
	})();
	
	$(replyDiv).on("click",".deleteReply",function(){
		var rno = $(this).parent().data("rno");
		
		replyService.remove(rno, function(result){
			alert("삭제했습니다");
			showList();
		})
	});
	
	$(replyDiv).on("click",".modifyReply",function(){
		
		if(replyopen == "f"){
			$(this).parent().append(cloneS.show());
			replyopen = "t"
		}else if(replyopen == "t"){
			$(this).parent().children("section").remove();
			replyopen = "f"
		}
		
	});
	
	$("section").on("click","#modifyBtn",function(e){
		var rno = $(this).parent().parent().parent().find("div").prevObject.data("rno");
		
		var reply = {
				rno : rno,
				reply : $("#modifyInput").val()
			}
			
		replyService.modify(reply,function(result){
				console.log("성공@");
				$("#modifyInput").val("");
				showList();
		});
	});
	
	
	function showList(){
			replyService.getList(bno,function(list){
			
			var str="";
			if(list.length == 0 || list == null){
				replyDiv.html("");
				return;
			}
			
			for(var i=0; i<list.length; i++){
				str+="<hr/><div class='replyBox' data-rno='"+list[i].rno+"'>";
				str+="<div class='replyer'>"+list[i].replyer+"</div>";
				str+="<div class='deleteReply'>d</div>";
				str+="<div class='modifyReply'>m</div>";
				str+="<div class='regdate'>"+list[i].replydate+"</div>";
				if(list[i].del === "n"){
					str+="<div class='content'>"+list[i].reply+"</div>";
				}else if(list[i].del === "y"){
					str+="<div class='delContent'>[삭제된 댓글입니다]</div>";
				}
				str+="</div>";
			}
			
			replyDiv.html(str);
		});
	};

	$("#replyBtn").on("click",function(e){
		
		var reply = {
			bno : bno,
			replyer : "user1",
			reply : $("#replyInput").val()
		}
		
		replyService.add(reply,function(result){
			console.log("성공@");
			$("#replyInput").val("");
			showList();
		}); 
	});
	
	$(".imgList").on("click","div img",function(e){
		var obj = $(this);
		
		$(".bigPictureWrapper").css("display","flex").show();
		$(".bigPicture")
		.html("<img src='"+obj[0].src+"'>")
	});
	
	
	$(".bigPictureWrapper").on("click",function(e){
		$(".bigPictureWrapper").hide();
	});
	
	$(".button").on("click",function(){
		
		if($(this).attr("id") == "mord"){
			form.append("<input type='hidden' name='bno' value='"+${pageObj.bno}+"'>");
			form.attr("action","/board/modify").submit();
		
		}else if($(this).attr("id") == "list"){
			form.attr("action","/board/list").submit();
		}
	})
	
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