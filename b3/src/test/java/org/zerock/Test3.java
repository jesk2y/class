package org.zerock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;
import org.zerock.persistence.FreeBoardRepository;
import org.zerock.persistence.FreeReplyRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@Commit
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class Test3 {
	
	@Setter(onMethod_=@Autowired)
	private FreeBoardRepository freeBoardRepository;

	@Setter(onMethod_=@Autowired)
	private FreeReplyRepository freeReplyRepository;
	
	@Test
	public void testListTitleQuery() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		Page<Object[]> result = freeBoardRepository.listByTitleOrContentPage("5", pageable);
		
		log.info(""+result);
		
		result.getContent().forEach(arr -> 
		log.info(""+Arrays.toString(arr))
		);
	}
	
	@Test
	public void testListQuery() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		Page<Object[]> result = freeBoardRepository.listPage(pageable);
		
		log.info(""+result);
		
		result.getContent().forEach(arr -> 
		log.info(""+Arrays.toString(arr))
		);
	}
	
	@Test
	public void testList() {
		List<FreeBoard> list = freeBoardRepository.findList(
									PageRequest.of(0, 10, Sort.Direction.DESC, "bno"));
		
		list.stream().forEach(vo -> {
			log.info(vo.getBno()+" : "+vo.getTitle());
		});
		
	}
	
	@Test
	public void insertReply() {
		FreeReply reply = new FreeReply();
		reply.setReply("댓글댓글,,,");
		reply.setReplyer("사용자");
		
		FreeBoard board = new FreeBoard();
		board.setBno(200L);
		
		reply.setBoard(board);
		
		freeReplyRepository.save(reply);
	}
	
	@Test
	public void test() {
		
		IntStream.range(1, 301).forEach( i -> {
			FreeBoard board = new FreeBoard();
			
			board.setTitle("제목"+i);
			board.setContent("내용"+i);
			board.setWriter("작성자"+(i % 10));
			
			freeBoardRepository.save(board);
			
		});
	}

}
