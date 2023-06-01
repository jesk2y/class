<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/customLogout" method="post">
<!-- 로그인 할땐 액션을 /login 으로만 줘도 알아서 post방식으로 처리되지만 
 		로그아웃은 컨트롤러에서 /customlogout post방식으로 받는 메서드를 따로 만들어줘야한다 -->
	<button>로그아웃</button>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
	<!-- 포스트 방식일 때 무조건 있어야함 -->
</form>
</body>
</html>