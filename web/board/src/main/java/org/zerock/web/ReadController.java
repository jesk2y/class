package org.zerock.web;

import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardVO vo= BoardDAO.INSTANCE.getBoard(Integer.parseInt(req.getParameter("bno")));
        BoardDAO.INSTANCE.addView(Integer.parseInt(req.getParameter("bno")));

        req.setAttribute("page",Integer.parseInt(req.getParameter("page")));
        req.setAttribute("board",vo);

        // getServletContext() 는 어플리케이션 전체에서 공유함, 여기선 글 하나를 전체가 공유할 필요가 없고 공유하면 안되서 뻄

        req.getRequestDispatcher("/WEB-INF/read.jsp").forward(req,resp);
    }
}
