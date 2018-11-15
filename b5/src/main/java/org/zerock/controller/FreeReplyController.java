package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;
import org.zerock.persistence.FreeReplyRepository;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
//ajax
@RequestMapping("/replies/*")
@Log
@AllArgsConstructor
public class FreeReplyController {

	private FreeReplyRepository repository;
	
	@GetMapping("/{bno}")
	public ResponseEntity<List<FreeReply>> getList(@PathVariable("bno") FreeBoard board){
		
		log.info(board+"");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
