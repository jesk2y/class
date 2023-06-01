package org.zerock.aop;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Before; 

@Aspect
@Component
@Log4j
public class LogAdvice {
	
	@Before("execution(* org.zerock.service.*.*(..))")
	public void logBefore() {
		log.info("--------------");
	}
}
