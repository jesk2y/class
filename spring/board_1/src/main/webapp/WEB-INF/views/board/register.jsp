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
				<form role="form" method="post">
                    <div class="form-group">
                        <label>제목</label>
                        <input name="title" class="form-control" autocomplete="off" value="">
                    </div>
                    <div class="form-group">
                        <label>닉네임</label>
                        <input class="form-control" name="writer" autocomplete="off">
                    </div>
                    
                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="3" name="content" autocomplete="off"></textarea>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">등록</button>
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

<%@include file="../includes/footer.jsp"%>
</body>

</html>