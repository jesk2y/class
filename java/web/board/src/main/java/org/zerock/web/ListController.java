package org.zerock.web;

import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page_str = req.getParameter("page");
        if (page_str==null){
            page_str = "1";
        }

        int page = Integer.parseInt(page_str);

        List<BoardVO> boardVOList = BoardDAO.INSTANCE.getList(page);
        int count = BoardDAO.INSTANCE.countMovie();

        int totalPage = count/10;
        if((count % 10) != 0){totalPage = (count/10) + 1;}

        int startPage = page - (page%10) + 1;
        if(page%10 == 0){startPage = page - 9;}

        int endPage = page - (page%10) + 10;
        if(page%10 == 0){endPage = page;}
        if(endPage > totalPage){endPage = totalPage;}


        req.setAttribute("list", boardVOList);
        req.setAttribute("count",count);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("page",page);
        req.setAttribute("startPage",startPage);
        req.setAttribute("endPage",endPage);

        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req,resp);

    }
}
