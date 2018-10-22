package org.zerock.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testCount() {
		PageParam param = new PageParam();
		
		log.info(mapper.count(param));
	}

	
	@Test
	public void getListAll() {
		
		PageParam param = new PageParam();
	
		log.info(mapper.getList(param));
		
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트");
		board.setContent("내용");
		board.setWriter("익명");
		
		log.info(mapper.insert(board));
	}
	
	@Test
	public void testRead() {
		PageParam param = new PageParam();
		log.info(mapper.read(param));
	}
	
	@Test
	public void testmodify() {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("테스트");
		board.setContent("내용");
		board.setWriter("익명");
		log.info(mapper.update(board));
	}
}
