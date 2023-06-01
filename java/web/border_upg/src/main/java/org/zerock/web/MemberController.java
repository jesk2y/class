package org.zerock.web;

import lombok.extern.log4j.Log4j;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@WebServlet("/member/*")
@Log4j
/*
* 로그인 해서 "login"이라는 이름의 쿠키가 생겨야만 접속가능하게 함\
* ->필터에서 검사
* */
public class MemberController extends AbstractController {
    public String loginGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{

        log.info("login Post");

        Cookie loginCookie = new Cookie("login", URLEncoder.encode("Kim Jin Sol","UTF-8"));
        loginCookie.setMaxAge(60*60*24);

        loginCookie.setPath("/");   //모든 경로에서 접근가능하도록
        resp.addCookie(loginCookie);

        return "redirect/board/list";
    }

    @Override
    public String getBasic() {
        return "/member/";
    }
}
