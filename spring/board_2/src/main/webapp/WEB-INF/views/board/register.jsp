<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Write</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">글쓰기</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form id="actionForm" role="form" method="post">
                    <div class="form-group">
                        <label>제목</label>
                        <input name="title" id="title" class="form-control" autocomplete="off" value="">
                    </div>
                    <div class="form-group">
                        <label>닉네임</label>
                        <input class="form-control" name="writer" id="writer" autocomplete="off">
                    </div>
                    
                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="3" name="content" id="content" autocomplete="off"></textarea>
                    </div>
                    
                    <button type="submit" class="btn btn-primary submit">등록</button>
                    <button type="reset" class="btn btn-default" 
                    onclick="location='/board/list'" style="float:right">리스트</button>
                </form>
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
			<div class="modal-body">내용을 모두 입력해주세요</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%@include file="../includes/footer.jsp"%>
<script>
console.log($("#content").val().length == 0);
$(document).ready(function(){
	$(".submit").on("click",function(e){
		e.preventDefault();
		if($("#title").val().length == 0 || $("#writer").val().length == 0 || $("#content").val().length == 0 ){
			$("#myModal").modal("show");
		}else{
			$("#actionForm").submit();
		}
		
	})
});
</script>
</body>

</html>