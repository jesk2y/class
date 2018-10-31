
<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="../includes/header.jsp"/>
<style>
hr{
	margin:1rem 0;
}

.imgBox{
	display:inline-block;
	height:80px;
	padding:5px;
}

.delete{
	padding:2px;
	position:absolute;
	width:12px;
	height:12px;
	background:#fff;
	font-size:12px;
	font-weight:bold;
	line-height:0.5;
	cursor:pointer;
}

.fileBox{
	background: #f5f5f5;
	padding:10px;
}
</style>
<!-- Main -->
	<div id="main">
		<!-- Post -->
		<section class="post">
			<!-- Form -->
			<h2>글 등록</h2>
		
			<form:form id="insertForm" modelAttribute="boardVO" method="post" action="/board/register">
			
				<div class="row gtr-uniform">
					<div class="col-6 col-12-xsmall">
						<form:input path="title" autocomplete="off" placeholder="Title"/>
						<form:errors path="title" />
					</div>
					<div class="col-6 col-12-xsmall">
						<input type="text" name="writer" value="user1" placeholder="user" />
					</div>
					<!-- Break -->
					<div class="col-12">
					 	<form:errors path="content" />
						<form:textarea path="content" autocomplete="off" rows="6" placeholder="Title"/></textarea>
					</div>
					
					<div class="col-12" id="uploadDiv">
						<hr>
						<div class="inputDiv">
						<input type="file" id="files" name="files" multiple="multiple"/>
						</div>
						<div class="fileBox">
							
						</div>
					</div>
					<!-- Break -->
					<div class="col-12">
						<ul class="actions">
							<li><input type="submit" id="insert" value="등록" class="primary" /></li>
							<li style="float:right"><input type="reset" id="list" value="리스트" /></li>
						</ul>
					</div>
				</div>
			</form:form>
		</section>
	</div>
</div>

			
<form id="actionForm">
	<input type="hidden" id="page" name="page" value="${pageObj.page}"/>
	<input type="hidden" name="display" value="${pageObj.display}"/>
	<input type="hidden"  name="keyword" value="${pageObj.keyword}"/>
	<input type="hidden" name="type" value="${pageObj.type}"/>
</form>

<jsp:include page="../includes/footer.jsp"/>
<script>
$(document).ready(function(){
	
	var form = $("#actionForm");
	var insertForm = $("#insertForm");
	
	var cloneObj = $(".inputDiv").clone();
	
	$("#insert").on("click",function(e){
		e.preventDefault();
		
		var str="";
		
		$(".fileBox .imgBox div").each(function(i, obj){
			str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+$(obj).data("uuid")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].filename' value='"+$(obj).data("filename")+"'>";	
			str+="<input type='hidden' name='attachList["+i+"].uploadpath' value='"+$(obj).data("uploadpath")+"'>";	
		});
		
		insertForm.append(str).submit();
	});
	
	$(".fileBox").on("click",".delete",function(){
		
		var uploadPath = $(this).parent().find('div').attr("data-uploadpath");
		var uuid = $(this).parent().find('div').attr("data-uuid");
		var fileName = $(this).parent().find('div').attr("data-filename");
		var src=uploadPath;
		var finalName = uuid + "_" + fileName;
		
		$.ajax({
			url:'/imgDelete',
			type:'post',
			data:{src:src, finalName:finalName},
			dataType:'text',
			success:function(result){
				$(".inputDiv").html(cloneObj.html());
			}
		})
		
		$(this).parent().remove();
	});

	$("#files").change(function(e){
		e.stopPropagation();
		e.preventDefault();
		
 		var formData = new FormData();
		var filesObj = $("#files");
		var files = filesObj[0].files;
		var regex = new RegExp(".+\\.(gif|jpg|png)$");
		var maxSize = 5242880;
		
		function checkExtension(fileName, fileSize){
			if(fileSize >= maxSize){ alert("파일 사이즈 초과"); return false; }
			if(!regex.test(fileName)){ alert("이미지 파일만 업로드할 수 있습니다."); return false; }
			
			return true;
		}
		
		for(var i=0; i<files.length; i++){
			if(!checkExtension(files[i].name, files[i].size)){ return false; }
			formData.append("files", files[i]); //이름 꼭! 써줘야함
		}
		
		$.ajax({
			url:'/upload',
			processData:false,
			contentType:false,
			data:formData,
			type:'post',
			dataType:'json',
			success:function(result){
				console.log(result);
				str = "";
				$(result).each(function(i,obj){
					
					var fileCallPath = encodeURIComponent(obj.uploadpath+"/s_"+obj.uuid+"_"+obj.filename);
					console.log(fileCallPath);
					
					str += "<div class='imgBox'><div data-uuid='"+obj.uuid
					+"' data-filename='"+obj.filename+"."+obj.etx+"' data-uploadpath='"+obj.uploadpath+
					"' class='delete'>x</div><img src='/view?fileName="+fileCallPath+"_"+obj.etx+"'></div>";
					
				});				
				
				$(".fileBox").append(str);

			}			
		});
	});
	

	$("#list").on("click",function(e){
		e.preventDefault;

		form.attr("action","/board/list").submit();
	});
});
</script>
	</body>
</html>