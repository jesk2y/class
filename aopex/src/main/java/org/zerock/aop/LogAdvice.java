package org.zerock.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect

@Log4j
public class LogAdvice {
	
	@Before("execution(* org.zerock.service.SampleService*.*(String,String)) && args(str1,str2)")
	//pointcut
	public void logBefore(String str1, String str2) {
		log.info("============================" + str1);
		log.info("============================" + str2);
	}
	
	@After("execution(* org.zerock.service.SampleService*.*(..))")
	public void logAfter() {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
}
