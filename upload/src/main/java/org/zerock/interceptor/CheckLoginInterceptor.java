package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

// 로그인 안하면 사전에 못들어가게 막음 : pre
@Log4j
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cks = request.getCookies();
		
		boolean check = false;
		
		if(cks == null || cks.length == 0) {
			response.sendRedirect("/");
			// null 나올 확률은 드무나 null도 체그하는게 좋음(다른 was의 문제)
			return false;
		}
		
		for (Cookie cookie : cks) {
			if(cookie.getName().equals("lcookie")) {
				check = true;
				break;
			}
		}
		log.info("LOGIN CHECK RESULT: " + check);
		if(check == false) {
			response.sendRedirect("/");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
}
