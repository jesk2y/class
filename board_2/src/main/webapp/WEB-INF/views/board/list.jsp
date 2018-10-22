<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board List</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
				<div class="row">
					<div class="col-sm-6">
						<div class="dataTables_length" id="dataTables-example_length">
							<label>Show 
							<select id="select" name="dataTables-example_length" aria-controls="dataTables-example" 
							class="form-control input-sm">
								<option value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
							</select> entries</label>
						</div>
					</div>
					<style>
					.form-control{
						display:inline-block;
						width="unset"
					}
					.sBtn{
						padding:3px 6px;
					}
					</style>
					<div class="col-sm-6">
						<div id="dataTables-example_filter" class="dataTables_filter">
							<label><select id="selectS" name="dataTables-example_length" aria-controls="dataTables-example" 
							class="form-control input-sm" style="width:100px">
								<option value="t">제목</option>
								<option value="c">내용</option>
								<option value="w">작성자</option>
								<option value="tc">제목+내용</option>
								<option value="tw">제목+작성자</option>
								<option value="cw">내용+작성자</option>
								<option value="tcw">제목+내용+작성자</option>
							</select>
							<input type="search" class="form-control input-sm inputS" placeholder="" 
							aria-controls="dataTables-example" style="width:100px;">
							<button class="btn btn-primary sBtn">검색</button>
							</label>
						</div>
					</div>
				</div>
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>
						<c:forEach items="${list}" var="board">
						<tbody>
							<tr>
								<td><c:out value="${board.bno}"/></td>
								<td><a href="${board.bno}" class="board"><c:out value="${board.title}"/></a></td>
								<td><c:out value="${board.writer}"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate}" /></td>
							</tr>
						</tbody>
						</c:forEach>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
	<button style="margin:0 15px" class="btn btn-primary write">글쓰기</button>
	<div class="col-sm-12">
		<div class="dataTables_paginate paging_simple_numbers"
			id="dataTables-example_paginate">
			<ul class="pagination">
			<c:if test="${pageObj.prev}">
				<li class="paginate_button previous"
					aria-controls="dataTables-example" tabindex="0"
					id="dataTables-example_previous"><a href="${pageObj.start-1}">Previous</a></li>
			</c:if>
			<c:forEach begin="${pageObj.start }" end="${pageObj.end }" var="num">
				<li class="paginate_button" data-page='${num }'
					aria-controls="dataTables-example" tabindex="0"><a href="${num }"><c:out value="${num}"></c:out></a></li>
			</c:forEach>
			<c:if test="${pageObj.next}">		
				<li class="paginate_button next" aria-controls="dataTables-example"
					tabindex="0" id="dataTables-example_next"><a href="${pageObj.end+1}">Next</a></li>
			</c:if>
			</ul>
		</div>
	</div>
</div>
<!-- /.row -->

<form id="actionForm">
	<input type='hidden' name='page' id='page' value='${pageObj.page}'>
	<input type='hidden' name='display' id='display' value='${pageObj.display}'>
	<input type='hidden' name='keyword' id='keyword' value='${pageObj.keyword}'>
	<input type='hidden' name='type' id='type' value='${pageObj.type}'>
</form>

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
			<div class="modal-body">등록이 완료되었습니다.</div>
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
$(document).ready(function(){
	
	var actionForm = $("#actionForm");
	var pageNum = ${pageObj.page};

	if(${pageObj.total} === 0){
		$(".table").html("검색 결과가 없습니다");
	}
	
	$('.pagination li[data-page='+pageNum+']').addClass("active");
	
	$('.pagination li a').on("click", function(e){
 		e.preventDefault();	//기본 동작 막음
		var target = $(this).attr("href");
		$("#page").val(target);
		actionForm.attr("action", "/board/list").attr("method","get").submit();
		
	});
	
	$(".board").on("click",function(e){
		e.preventDefault();
		var bno = $(this).attr("href");
		actionForm.append("<input type='hidden' name='bno' value='"+bno+"'>");
		actionForm.attr("action", "/board/read").attr("method","get").submit();
	});
	
	var result = '<c:out value="${result}"/>';
	
	checkModal(result);
	
	history.replaceState({},null,null);
	
	function checkModal(result){
		
		if(result === '' || history.state){ return; }
		
		if(result === 'INSERT'){
			$("#myModal").modal("show");
		}else if(result === 'REMOVE'){
			$("#myModal").modal("show");
			$(".modal-body").html("삭제가 완료되었습니다.")
		}
	};
	
	$(function(){
		  $("#select").val(${pageObj.display}).attr("selected","true");
		  $("#selectS").val("${pageObj.type}").attr("selected","true");
		$(".inputS").val("${pageObj.keyword}");
	});

	$("#select").change(function(e) {
		var val = $(".input-sm option:selected").val();
		window.location.href = '/board/list?page=1&display='+val;
	});
	
	$(".write").on("click",function(e){
		e.preventDefault();
		actionForm.attr("action","/board/register").submit();
	});
	
	$(".sBtn").on("click",function(e) {
		var type = $("#selectS option:selected").val();
		var keyword = $(".inputS").val();

  		actionForm.find("input[name='keyword']").val(keyword);
  		actionForm.find("input[name='type']").val(type);

  		$("#page").val(1);
  		actionForm.submit();
	});
});
</script>
</body>

</html>