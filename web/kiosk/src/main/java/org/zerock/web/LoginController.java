package org.zerock.web;

import org.zerock.domain.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/login.jsp");

        dispatcher.forward(req,resp);;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login post...........");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        System.out.println(id + " : " + pw);

        MemberVO vo = null;
        if(id.equals(pw) == false){
            resp.sendRedirect("/login");
            return;
        }
        vo = new MemberVO(id,pw,"사용자" +id,"Seoul");


        HttpSession session = req.getSession();
        if(vo  != null){
            session.setAttribute("member",vo);
            resp.sendRedirect("/");
        }
    }
}
