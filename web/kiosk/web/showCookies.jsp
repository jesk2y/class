<%--
  Created by IntelliJ IDEA.
  User: hb03-30
  Date: 2018-09-11
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();

    for(Cookie ck : cookies){
        out.write("<h1> getname: " + ck.getName() + "</h1>");
        out.write("<h1>getValue: " + ck.getValue() + "</h1>");
        out.write("<hr/>");
    }
%>
<h2>getid: <%=session.getId()%></h2>
</body>
</html>
