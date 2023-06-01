package org.zerock.Filter;

import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebFilter(urlPatterns = {"/board/list"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========================================");
        System.out.println("LOGIN CHECK FILTER");
        System.out.println("========================================");

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        Cookie[] cks = req.getCookies();

        if(cks == null || cks.length == 0){
            resp.sendRedirect("/main");
        }   //쿠기값이 없으면 main으로

        boolean check = false;
        for(Cookie ck:cks){
            if(ck.getName().equals("login")){
                check = true;      //속성 창 끌때까지 있음
                break;
            }
        }   //쿠키값이 있으므로 필터검사 통과됨

        if(!check){
            resp.sendRedirect("/main");
            return;
        }//쿠키값이 있지만 login이라는 이름의 쿠키가 없으면 main으로

        System.out.println("==========================LOGIN CHECK RESULT : " + check);

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
