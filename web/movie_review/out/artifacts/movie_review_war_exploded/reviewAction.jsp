<%@ page import="org.movie.domain.ReviewVO" %>
<%@ page import="org.movie.dao.ReviewDAO" %><%--
  Created by IntelliJ IDEA.
  User: hb03-30
  Date: 2018-09-07
  Time: 오후 6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String mnum = request.getParameter("mnum");
    String cmt = request.getParameter("cmt");
    String score = request.getParameter("score");

    System.out.println(mnum);
    System.out.println(cmt);
    System.out.println(score);

    ReviewVO vo = new ReviewVO();

    vo.setMnum(Integer.parseInt(mnum));
    vo.setCmt(cmt);
    vo.setScore(Integer.parseInt(score));

    ReviewDAO dao = new ReviewDAO();
    dao.addReview(vo);
%>
<script>

    parent.doA();

</script>