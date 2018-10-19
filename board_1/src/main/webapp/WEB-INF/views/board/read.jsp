<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
                    <div class="form-group">
                        <label>Title</label>
                        <input name="title" class="form-control" autocomplete="off" 
                        value="<c:out value='${board.title}'/>" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" autocomplete="off" 
                        value="<c:out value='${board.writer}'/>" readonly="readonly">
                    </div>
                    
                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name="content" autocomplete="off" 
                        readonly="readonly"><c:out value='${board.content}'/></textarea>
                    </div>
                    <div>
						<button class="btn btn-default btn-outline list" style="float:right">리스트</button>
						<button class="btn btn-info modify">수정/삭제</button>
					</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->

</div>
<!-- /.row -->

<!-- Modal  추가 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">알림메세지</h4>
			</div>
			<div class="modal-body">수정이 완료되었습니다.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<form id="actionForm" method="get">
	<input type='hidden' name='page' id='page' value='${pageObj.page}'>
</form>

<%@include file="../includes/footer.jsp"%>
<script>
$(document).ready(function(){
	var actionForm = $("#actionForm");
	var pageNum = ${pageObj.page};
	
	$('.btn').on("click", function(e){
		e.preventDefault();	//기본 동작 막음
		var target = pageNum;
		$("#page").val(target);
		
		if($(this).hasClass('list')){
			actionForm.attr("action", "/board/list").submit();
		}else if($(this).hasClass('modify')){

			actionForm.append("<input type='hidden' name='bno' value='"+${pageObj.bno}+"'>");
			actionForm.attr("action", "/board/modify").submit();
		}	
		
	});

	var result = '<c:out value="${result}"/>';

	checkModal(result);
	
	history.replaceState({},null,null);
	
	function checkModal(result){
		
		if(result === '' || history.state){
			return;
		}
		
		if(result === 'MODIFY'){
			$("#myModal").modal("show");
		}
	}
	
});
</script>
</body>

</html> 