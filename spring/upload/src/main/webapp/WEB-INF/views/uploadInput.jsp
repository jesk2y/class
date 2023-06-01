<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<form method="post" enctype="multipart/form-data" action="/upload">
		<input type="file" name="files" multiple="multiple">
		<button>upload</button>
	</form>
</body>
</html>