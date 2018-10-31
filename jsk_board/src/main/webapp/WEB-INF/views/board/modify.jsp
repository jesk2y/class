
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../includes/header.jsp"/>

				<!-- Main -->
					<div id="main">

						<!-- Post -->
							<section class="post">
								<!-- Form -->
									<h2>글 수정</h2>

									<form method="post" id="actionForm">
									<input type="hidden" id="bno" name="bno" value="${pageObj.bno}"/>
										<input type="hidden" id="page" name="page" value="${pageObj.page}"/>
										<input type="hidden" id="display" name="display" value="${pageObj.display}"/>
										<input type="hidden" name="keyword" value="${pageObj.keyword}"/>
										<input type="hidden" name="type" value="${pageObj.type}"/>
										
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="title" autocomplete="off" value="${board.title}"
												placeholder="Title" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="writer" value="user1" value="${board.writer}"
												placeholder="user" readonly="readonly" />
											</div>
											<!-- Break -->
											<div class="col-12">
												<textarea name="content" placeholder="content" rows="6" 
												autocomplete="off"><c:out value="${board.content}" /></textarea>
											</div>
											<!-- Break -->
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" id="modify" value="수정" class="primary" /></li>
													<li><input type="submit" id="delete" value="삭제" class="primary" /></li>
													<li><input type="reset" id="read" value="취소" /></li>
												</ul>
											</div>
										</div>
									</form>
							</section>
					</div>
			</div>

<jsp:include page="../includes/footer.jsp"/>
<script>
$(document).ready(function(){
	
	var form = $("#actionForm");

		
	$("li input").on("click",function(e){
		e.preventDefault;
		var id = $(this).attr("id");
			
		if(id == "modify"){
			form.attr("action","/board/update").submit();
		}else if(id == "delete"){
			form.attr("action","/board/delete").submit();
		}else if(id == "read"){
			form.attr("action","/board/read").attr("method","get").submit();
		}

	});

});
</script>
	</body>
</html>