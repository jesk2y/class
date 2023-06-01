<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Modify/Delete</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Modify/Delete</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/modify" method="post">
				<input type='hidden' name='bno' value='${board.bno}'>
                    <div class="form-group">
                        <label>Title</label>
                        <input name="title" class="form-control" autocomplete="off" 
                        value="<c:out value='${board.title}'/>">
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" autocomplete="off" 
                        value="<c:out value='${board.writer}'/>" readonly="readonly">
                    </div>
                    
                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name="content" autocomplete="off"
                        ><c:out value='${board.content}'/></textarea>
                    </div>
                    <div>
						<button class="btn etc btn-outline btn-default list" style="float:right">리스트</button>
						<button type="submit" class="btn btn-warning modify">수정</button>
						<button class="btn etc btn-danger delete" style="float:right;margin-right:5px;">삭제</button>
					</div>
				</form>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->

</div>
<!-- /.row -->

<form id="actionForm">
	<input type='hidden' name='page' id='page' value='${pageObj.page}'>
</form>

<%@include file="../includes/footer.jsp"%>
<script>
$(document).ready(function(){
	var actionForm = $("#actionForm");
	var pageNum = ${pageObj.page};
	
	$('.etc').on("click", function(e){
		e.preventDefault();	//기본 동작 막음
		var target = pageNum;
		$("#page").val(target);
		
		if($(this).hasClass('list')){
			actionForm.attr("action", "/board/list").attr("method","get").submit();
			
		}else if($(this).hasClass('delete')){
			actionForm.append("<input type='hidden' name='bno' value='"+${pageObj.bno}+"'>");
			actionForm.attr("action", "/board/remove").attr("method","post").submit();
		}	
		
	});
	
});
</script>
</body>

</html> 