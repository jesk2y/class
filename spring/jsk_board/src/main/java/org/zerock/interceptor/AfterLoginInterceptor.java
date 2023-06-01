package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class AfterLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler,	ModelAndView modelAndView)throws Exception {
		
		log.info(modelAndView.getModel());
		
		Object result = modelAndView.getModel().get("member");
		
		log.info("RESULT: " + result);
		
		if(result == null) {
			return;
		}
		
		MemberVO memberVO = (MemberVO) result;
		
		Cookie loginCookie = new Cookie("lcookie",memberVO.getId());
		
		loginCookie.setMaxAge(60*60*24);
		response.addCookie(loginCookie);
		
		response.sendRedirect("/board/list");
	}
}
