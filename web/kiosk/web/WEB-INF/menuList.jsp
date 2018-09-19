<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 2018-09-11
  Time: 오후 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>메뉴 리스트입니다</h1>
<form method="post">
    <ul>
        <c:forEach items="${menuList}" var="menu">
            <li>
                <div>
                        ${menu.cname}  ${menu.cprice}
                    <select name="ord">
                        <option value="0">0</option>
                        <option value="${menu.cno}_1">1</option>
                        <option value="${menu.cno}_2">2</option>
                        <option value="${menu.cno}_3">3</option>
                    </select>
                </div>
            </li>
        </c:forEach>
    </ul>
    <button>주문 하기 </button>
</form>
</body>
</html>
