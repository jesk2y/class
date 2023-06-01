package org.zerock.web;

import org.zerock.domain.BoardVO;
import org.zerock.dao.BoardDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/write.jsp");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardVO vo = new BoardVO();
        req.setCharacterEncoding("UTF-8");
        System.out.println("Register..............");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String poster = req.getParameter("poster");
        System.out.println(title + ":" + content + ":" + poster);


        vo.setTitle(title);
        vo.setContent(content);
        vo.setPoster(poster);

        BoardDAO.INSTANCE.write(vo);

        resp.sendRedirect("/list");
    }
}
