package org.zerock.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;
/*
* 페이지값 음수면 에러페이지 뜨게
* */
@WebFilter(urlPatterns = "/board/*")
public class SampleFilter implements Filter {   //javax.servlet에 있는 필터 구현해야함
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init sample Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // FilterChain - 필터를 여러개에 연결해줌(다음으로 넘어갈 수 있게해줌)
        System.out.println("do sample Filter");

        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpServletRequest req = (HttpServletRequest)servletRequest;

        String pageSTR = req.getParameter("page"); // 그냥 list만 쓰면 pageSTR은 자동으로 null이 됨
        if(pageSTR == null){
           pageSTR = "1";
        }

        int page = Integer.parseInt(pageSTR);

        if(page < 1){
            resp.sendRedirect("/board/list");
            return;
        }
//
//        try{
//            if(pageSTR == null){
//                throw new Exception("");
//            }
//            int page = Integer.parseInt(pageSTR);
//
//            if(page < 1){   //여기에 null도 걸리므로 따로 예외처리를 해주어야함
//                throw new ExportException("PAGE NUM");
//            }
//        }catch (NumberFormatException e){
//            resp.sendRedirect("/error");
//            return;
//        }catch(Exception ee){}
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
