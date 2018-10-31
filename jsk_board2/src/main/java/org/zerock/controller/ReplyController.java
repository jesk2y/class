package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {

	private ReplyService service;
	
	@PostMapping(value="/{rno}",
					produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		int count = service.delete(rno);
		
		return count == 1?
				new ResponseEntity<>("success",HttpStatus.OK):
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/pages/{bno}",
				produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") int bno){
		
		return new ResponseEntity<>(service.getList(bno),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{rno}",
				consumes="application/json",
				produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") int rno){
		
		vo.setRno(rno);
		int count = service.modify(vo);
		
		return count == 1 ?
				new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/new", 
			consumes = "application/json",	//ajax로 온 값을 받아들임
			produces= {MediaType.TEXT_PLAIN_VALUE}) //리턴하는값
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info(vo);
		
		int count = service.insert(vo);
		
		return count == 1 ?
			new ResponseEntity<>("success",HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
