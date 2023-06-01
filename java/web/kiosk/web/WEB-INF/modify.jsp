<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-12
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" >
        <input type="hidden" name="mno" value="${movie.mno}">
        영화 제목<input type="text" name="title" value="${movie.title}"></br>
        시놉시스<input type="text" name="synop" value="${movie.synop}"></br>
        포스터<input type="text" name="poster" value="${movie.poster}"></br>

 <button>수정하기</button>
    </form>
</body>
</html>
