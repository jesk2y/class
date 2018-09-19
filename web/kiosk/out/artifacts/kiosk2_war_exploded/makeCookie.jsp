<%--
  Created by IntelliJ IDEA.
  User: hb03-30
  Date: 2018-09-12
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("items","");

    cookie.setMaxAge(180);
    response.addCookie(cookie);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
