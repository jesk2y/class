package org.zerock.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.Member;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Member member = new Member();
        member.setName("Thor");
        member.setAge(23);
        member.setMarried(false);

        request.setAttribute("member", member);

        request
                .getRequestDispatcher("WEB-INF/sample.jsp")
                .forward(request, response);

    }

}