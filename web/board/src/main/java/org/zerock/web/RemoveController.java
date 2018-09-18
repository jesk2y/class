package org.zerock.web;

import org.zerock.dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mno = req.getParameter("bno");
        String addr = "/list?page=" + req.getParameter("page");

        BoardDAO.INSTANCE.delete(Integer.parseInt(mno));
        String adr = "/list";
        resp.sendRedirect(addr);
    }
}
