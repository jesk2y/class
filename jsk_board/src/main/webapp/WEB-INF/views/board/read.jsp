
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
img{
	width:80%;
}
hr{
margin:1rem 0;
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
							</section>
							
					</div>
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

<jsp:include page="../includes/footer.jsp"/>
<script>
$(document).ready(function(){
	
	var form = $("#actionForm");
	var bno = "<c:out value='${board.bno }'></c:out>";
		
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
	})();


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