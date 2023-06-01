
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

.fileBox{
	background: #f5f5f5;
	padding:10px;
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
</style>
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
							<li><input type="submit" id="modify" value="수정" class="primary" /></li>
							<li><input type="submit" id="delete" value="삭제" class="primary" /></li>
							<li><input type="reset" id="read" value="취소" /></li>
						</ul>
					</div>
				</div>
			</form>
	</section>
</div>
<div type="hidden" id="fileName"></div>
<div type="hidden" id="src"></div>
<jsp:include page="../includes/footer.jsp"/>
<script>
$(document).ready(function(){
	
	var form = $("#actionForm");
	var cloneObj = $(".uploadDiv").clone();
	
	$(function(){
		var bno = "<c:out value="${pageObj.bno}"/>";
		$.getJSON("/board/fileList",{bno:bno},function(arr){
			
			var str = "";
			$(arr).each(function(i, obj){
				var originName = obj.filename.substring(0,obj.filename.lastIndexOf("."));
				var etx = obj.filename.substring(obj.filename.lastIndexOf(".")+1);
				
				var fileCallPath = encodeURIComponent(obj.uploadpath+"/s_"+obj.uuid+"_"+
						originName+"_"+etx);
				
				str += "<div class='imgBox'><div data-uuid='"+obj.uuid
				+"' data-filename='"+obj.filename+"' data-uploadpath='"+obj.uploadpath+
				"' class='delete'>x</div><img src='/view?fileName="+fileCallPath+"'></div>";
			});
			
			$(".fileBox").append(str);
		});
	})
	
	
	//------------수정 or 삭제 or 이전버튼------------------
	$("li input").on("click",function(e){
		e.stopPropagation();
		e.preventDefault();
		
		var id = $(this).attr("id");
			
		if(id == "modify"){
			form.attr("action","/board/update");
		}else if(id == "delete"){
			form.attr("action","/board/delete");
		}else if(id == "read"){
			form.attr("action","/board/read").attr("method","get");
		}
		
		var str="";
		
		$(".fileBox .imgBox div").each(function(i, obj){
			str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+$(obj).data("uuid")+"'>";
			str+="<input type='hidden' name='attachList["+i+"].filename' value='"+$(obj).data("filename")+"'>";	
			str+="<input type='hidden' name='attachList["+i+"].uploadpath' value='"+$(obj).data("uploadpath")+"'>";	
		});
		
		var finalName= $("#fileName").data("filename");
		var src=$("#src").data("src");
		console.log(src + finalName);
		
		$.ajax({
			url:'/imgDelete',
			type:'post',
			data:{src:src, finalName:finalName},
			dataType:'text',
			success:function(result){
				$(".uploadDiv").html(cloneObj.html());
			}
		})
	 	
		form.append(str).submit();
 
	});
	
	//-------------파일수정버튼------------------
	$("#files").change(function(e){
		
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
	
	
	//-------------파일삭제버튼------------------
	$(".fileBox").on("click",".delete",function(){
		
		var uploadPath = $(this).parent().find('div').attr("data-uploadpath");
		var uuid = $(this).parent().find('div').attr("data-uuid");
		var fileName = $(this).parent().find('div').attr("data-filename");
		var src=uploadPath;
		var finalName = uuid + "_" + fileName;
		
		$("#fileName").attr("data-fileName",finalName);
		$("#src").attr("data-src",src);

		$(this).parent().remove();
	});

});
</script>
	</body>
</html>