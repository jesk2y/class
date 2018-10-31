
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../includes/header.jsp"/>

				<!-- Main -->
					<div id="main">

						<!-- Post -->
							<section class="post">

								<header>
									<h2><c:out value="${board.title }"/></h2>
									<p><c:out value="${board.writer }"/></p>
								</header>
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
			console.log(arr);
		});
	})();
	
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