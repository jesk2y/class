
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../includes/header.jsp"/>
<style>
select{
	width:150px;
	margin-bottom:20px;
}

input{
	width:150px !important;
}

li{
	display:inline-block;
}

.pagination{
	display:table;
	font-size:20px;
	margin:20px 0;
	text-align:center;
	width:100%;
}


</style>

<!-- Main -->
<div id="main">

	<!-- Post -->
		<section class="post">
				<h3>게시판</h3>
				<select id="select">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>등록일</th>
								<th>수정일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}"/></td>
								<td><a href="${board.bno}"><c:out value="${board.title}"/></a></td>
								<td><c:out value="${board.writer}"/></td>
								<td><fmt:formatDate pattern="yy-MM-dd" value="${board.regdate}" /></td>
								<td><fmt:formatDate pattern="yy-MM-dd" value="${board.updatedate}" /></td>
								<td>0</td>
							</tr>
							</c:forEach>
						</tbody>
						
					</table>
				</div>
				
				<form id="actionForm">
				<button id="register" class="button primary small">글쓰기</button>
				<div style="float:right">
					<select id="selectS" name="type">
						<option value="t" selected>제목</option>
						<option value="c">내용</option>
						<option value="tc">제목+내용</option>
						<option value="w">작성자</option>
					</select>
					<input type="text" id="inputS" name="keyword" autocomplete="off">
					<button class="button primary small" id="btnS">검색</button>
				</div>
				<input type="hidden" id="page" name="page" value="${pageObj.page}"/>
				<input type="hidden" id="display" name="display" value="${pageObj.display}"/>
				</form>
				
				
				<div class="pagination">
				<c:if test="${pageObj.prev}">
					<li data-index="${pageObj.start - 1}">
						<a class="previous" href="${pageObj.start - 1}">
							<c:out value="PREV"/>
						</a>
					</li>
				</c:if>
				<c:forEach begin="${pageObj.start}" end="${pageObj.end }" var="page" step="1">
					<li data-index="${page}"><a class="page" href="${page}"><c:out value="${page }"/></a></li>
				</c:forEach>
				<c:if test="${pageObj.next}">
					<li data-index="${pageObj.end + 1}">
						<a class="next" href=${pageObj.end + 1 }>
							<c:out value="NEXT"/>
						</a>
					</li>
				</c:if>
					</div>		
			</section>
	</div>
</div>


<!-- Link to open the modal -->


<jsp:include page="../includes/footer.jsp"/>
			
<form id="modal-form" class="modal">
  <p class="modalText">글 등록이 완료되었습니다</p>
  <a href="#" rel="modal:open">Close</a>
</form>

<script>
$(document).ready(function(e){
	
	var form = $("#actionForm");
	
	$(function(){
		$("input:text").keydown(function(evt) { if (evt.keyCode == 13) return false; });
	    $("#select").val("${pageObj.display}").attr("selected","true");
	    $("#selectS").val("${pageObj.type}").attr("selected","true");
		$("#inputS").val("${pageObj.keyword}");
		$('.pagination li[data-index='+$("#page").val()+'] a').addClass("active");
	});
	
	$("#btnS").on("click",function(e){
		form.submit();
	});

	
	$("tr a").on("click",function(e){
		e.preventDefault();
		var bno = e.target.href.substring(28);
		form.append("<input type='hidden' name='bno' value='"+bno+"'/>")
		form.attr("action","/board/read").submit();
	})
	
	$(".pagination a").on("click",function(e){
		e.preventDefault();
		$("#page").val(e.target.href.substring(28));
		form.submit();
	})
	
	$("#register").on("click",function(){
		form.attr("action","/board/register").submit();
	})
	
	$("#select").change(function(e){
		var val = $("#select option:selected");
		window.location.href = '/board/list?display='+val[0].label;
	});
	
	var result = '<c:out value="${result}"/>';
	
	checkModal(result);
	history.replaceState({},null,null);
	function checkModal(result){
		if(result === '' || history.state){return;}
		if(result === 'INSERT'){
			$('#modal-form').modal();
		}else if(result === 'REMOVE'){
			$(".modalText").html("글 삭제가 완료되었습니다");
			$('#modal-form').modal();
		}
	}	
	
});
</script>
	</body>
</html>