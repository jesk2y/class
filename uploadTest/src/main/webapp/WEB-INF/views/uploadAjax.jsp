<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="file" id="files" name="files" multiple="multiple"/>
<button id="btn">등록</button>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>
 $("#btn").on("click",function(e){
	
	 var formData = new FormData();
		 
	 var files = $("#files")[0].files;
	 
	 for(var i=0; i<files.length; i++){
		 formData.append("files", files[i]);
	 }
	 
	 $.ajax({
		url:'/upload',
		processData:false,
		contentType:false,
		data:formData,
		type:'POST',
		success:function(result){
			console.log(result);
		}
		 
	 })
	 
	 
 });
</script>
</body>
</html>