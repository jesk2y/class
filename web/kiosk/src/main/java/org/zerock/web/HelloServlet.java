package org.zerock.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/hello")
//  컨트롤러
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("HelloServlet service()...");
        req.setAttribute("msg","안녕하세요.");       //map
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);

        req.setAttribute("tName",threadName);
        // 화면에서 필요한 역할 받음

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
//
//        req.setAttribute("list", list);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/hello.jsp"); //배포
//
//        dispatcher.forward(req,resp);   // foward : 담은것 싹 비우고 jsp로 감
    }
}
