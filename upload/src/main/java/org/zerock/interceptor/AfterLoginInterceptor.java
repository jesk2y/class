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
public class AfterLoginInterceptor extends HandlerInterceptorAdapter {
	// 쿠키만드는 인터셉터
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		Object result =	modelAndView.getModel().get("member"); // 컨트롤러에서 모델이용해서 보낸 이름
		
		log.info("RESULT: " + result);
		
		if(result == null) {
			return;
		}
		
		MemberVO memberVO = (MemberVO)result;
		
		log.info("MEMBER: " + memberVO);
		
		Cookie loginCookie = new Cookie("lcookie", 
				URLEncoder.encode(memberVO.getName(), "UTF-8"));	
		// 멤버컨틀로서에 설정한 쿠키이름 한글로 하려면 위에처럼 해줘야함

		loginCookie.setMaxAge(60*5); // 초단위
		response.addCookie(loginCookie);
		
	}
		
}
