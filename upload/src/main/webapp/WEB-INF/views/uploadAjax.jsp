<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
.fimg{
	display:inline-block;
}

.imgBox{
	position:absolute;
	width:100%;
	height:100vh;
	top:0px;
	left:0px;
	background:gray;
	display:none;
}
</style>
<h1> Ajax Upload Page</h1>

<input type="file" id="files" multiple="multiple"/>

<button id="btn">upload Button</button>

<div class="thumbs">
<div class="imgBox">
</div>
</div>

<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>

$(".thumbs").on("click","img",function(e){
	var obj = $(this);
	$(".imgBox").html("<img src='/view/"+obj.attr("data-src")+"'>").show('slow');
});

$(".imgBox").on("click",function(e){
	$(this).hide("slow");
});

$("#btn").on("click", function(e) {
	
	var thumbs = $(".thumbs");	
	var formData = new FormData();
	
	var filesObj = $("#files");
	
	console.log(filesObj);
	
	var files = filesObj[0].files;
	
	for(var i=0; i<files.length; i++){
		formData.append("files",files[i]);	// 컨트롤러에서 받는 매개변수랑 이름 같게
	}
	
	$.ajax({
		url:"/upload",
		processData:false,
		contentType:false,
		data:formData,
		type:"POST",
		success:function(result){
			console.log(result);
			
			var str = "";
			for(var i = 0; i<result.length; i++){
				
				var path = result[i].thumbName+"_"+result[i].ext;
				var fileSrc = (result[i].thumbName+"_"+result[i].ext).substring(2);
				
				str += "<div class='fimg'>";
				str +="<img data-src='"+fileSrc+"' src='/view/"+path+"'>";
				str += "<p>" + result[i].originName+"</p>"
				str += "</div>"
			}
			thumbs.append(str);
			
		}
	});
});
</script>
</body>
</html>