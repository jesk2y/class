<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
	<title>Login V7</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="../resources/login/images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="../resources/login/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="../resources/login/css/main.css">
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-90 p-b-30">
					<span class="login100-form-title p-b-40">
						Sign up
					</span>
					
					<form:form modelAttribute="memberVO" method="post" id="signUp">
					
						<label>ID</label>
						<div class="wrap-input100 validate-input m-b-16" >
							<form:input class="input100" type="text" path="id" id="id" placeholder="아이디를 입력해주세요" autocomplete="off"/>
							<span class="focus-input100"></span>
						</div>
						<form:errors path="id" />
						
						<label>Password</label>
						<div class="wrap-input100 validate-input m-b-16" >
							<form:input class="input100" type="password" path="pw" id="pw" placeholder="비밀번호를 입력해주세요" autocomplete="off"/>
							<span class="focus-input100"></span>
						</div>
							<form:errors path="pw" />
						
						<div class="container-login100-form-btn">
							<button class="login100-form-btn btn">
								회원가입
							</button>
						</div>
					</form:form>
			</div>
		</div>
	</div>
	
	<script src="../resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="../resources/login/vendor/animsition/js/animsition.min.js"></script>
	<script src="../resources/login/vendor/bootstrap/js/popper.js"></script>
	<script src="../resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/login/vendor/select2/select2.min.js"></script>
	<script src="../resources/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="../resources/login/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="../resources/login/vendor/countdowntime/countdowntime.js"></script>
	<script src="../resources/login/js/main.js"></script>
<script>
$(document).ready(function(){

	var result = "${result}";
	
	if(result){
		if(history.state){return;}
		alert("이미 있는 아이디입니다");
		return;
	}
	
	history.replaceState({},null,null);

	$(".btn").on("click",function(e){
		e.preventDefault();
		e.stopPropagation();

		
		$("#signUp").submit();
		
	})
	
	
});
</script>	
</body>
</html>