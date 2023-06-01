<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/login">
	<input type="text" name="username" />
	<input type="password" name="password" />
	<label>Remember Me</label><input type="checkbox" name="remember-me"/>
	<button>로그인</button>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
</form>
</body>
</html>