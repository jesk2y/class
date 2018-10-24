package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class SampleServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleService service;
	
	@Test
	public void testAdd()throws Exception {
		
		log.info("RESULT: "+service.doAdd("30", "20"));
	}
	
	@Test
	public void testMulti() {
		
		String str = "33333파란하늘파란하늘꿈이드리운푸른언덕에아기염소여럿이풀을뜯고놀아요해처럼밝은얼굴로파란하늘파란하늘꿈이드리운푸른언덕에아기염소여럿이풀을뜯고놀아요해처럼밝은얼굴로";
		
		service.addMulti(str);
		
	}
}
