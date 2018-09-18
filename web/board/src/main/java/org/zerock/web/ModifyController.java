package org.zerock.web;

import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/modify")
public class ModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardVO vo=new BoardVO();
        vo= BoardDAO.INSTANCE.getBoard(Integer.parseInt(req.getParameter("bno")));
        req.setAttribute("page",req.getParameter("page"));
        req.setAttribute("board",vo);
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/modify.jsp");

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        BoardVO vo=new BoardVO();

        String bnoStr=req.getParameter("bno");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String poster=req.getParameter("poster");
        String addr = "/list?page=" + req.getParameter("page");

        int mno=Integer.parseInt(bnoStr);
        vo.setBno(mno);
        vo.setTitle(title);
        vo.setContent(content);
        vo.setPoster(poster);

        BoardDAO.INSTANCE.modifyMovie(vo);

        resp.sendRedirect(addr);
    }
}