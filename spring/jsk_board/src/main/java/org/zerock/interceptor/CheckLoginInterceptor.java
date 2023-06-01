package org.zerock.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Cookie[] cks = request.getCookies();
		boolean check = false;
		
		if(cks == null || cks.length == 0) {
			response.sendRedirect("/login");
			return false;
		}
		
		for (Cookie cookie : cks) {
			if(cookie.getName().equals("lcookie")) {
				check = true;
				break;
			}
		}
		
		if(check == false) {
			response.sendRedirect("/login");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
	
}
