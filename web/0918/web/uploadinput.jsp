<%--
  Created by IntelliJ IDEA.
  User: hb03-30
  Date: 2018-09-18
  Time: 오전 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload1" method="post" enctype="multipart/form-data">
    <%--슬래시로 시작하면 절대경로(추천함)--%>
    <input type="text" name="mname">
    <input type="number" name="price">
    <input type="file" name="files" multiple="multiple">
    <button>save</button>
</form>
</body>
</html>
