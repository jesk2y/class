<%@ page import="org.salem.domain.ReviewVO" %>
<%@ page import="org.salem.ReviewDAO" %><%--
  Created by IntelliJ IDEA.
  User: hb03-30
  Date: 2018-09-05
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String snoStr = request.getParameter("sno");
    String mnoStr = request.getParameter("mno");
    String mid = request.getParameter("mid");
    String cmt = request.getParameter("cmt");
    String scoreStr = request.getParameter("score");

    System.out.println(snoStr);
    System.out.println(mnoStr);
    System.out.println(mid);
    System.out.println(cmt);
    System.out.println(scoreStr);

    ReviewVO vo = new ReviewVO();



    vo.setMno(Integer.parseInt(mnoStr));
    vo.setScore(Double.parseDouble(scoreStr));
    vo.setMid(mid);
    vo.setCmt(cmt);

    ReviewDAO dao = new ReviewDAO();
    dao.add(vo);
%>
<script>
    alert("리뷰가 등록되었습니다.");
</script>
</body>
</html>

