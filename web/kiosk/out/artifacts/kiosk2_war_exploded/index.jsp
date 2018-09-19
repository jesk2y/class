<%--
  Created by IntelliJ IDEA.
  User: hb03-30
  Date: 2018-09-11
  Time: 오전 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <C:if test="${member != null}">
      <h1>${member.name}</h1>
    </C:if>
    <C:if test="${member == null}">
      <h1>로그인 하세요.</h1>
    </C:if>
    <form action="/login">
      <button >로그인</button>
    </form>
        <form action="/logout" method="post">
          <button>로그아웃</button>
        </form>

  </body>
</html>
