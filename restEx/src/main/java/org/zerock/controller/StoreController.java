package org.zerock.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.StoreVO;
import org.zerock.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins="*")
@RestController
@Log4j
@RequestMapping("/store/*")
@AllArgsConstructor
public class StoreController {
	
	private StoreService service;
	
	/*@GetMapping("/{idx}")
	public StoreVO get(@PathVariable("idx") int idx) {
		
		return service.get(idx);
	}*/
	
	@GetMapping("/{idx}")
	public StoreVO getStore(@PathVariable("idx") int idx) {
		return service.get(idx);
	}
	
	/*@DeleteMapping("/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		
		;log.info("remove......"+idx);
		service.remove(idx);
		
		return "success";
	}*/
	
	@DeleteMapping("{idx}")
	public String remove(@PathVariable("idx") int idx) {
		
		log.info(idx);
		service.remove(idx);
		
		return "success";
	}
	
	@PostMapping("/new")
	public String add(@RequestBody StoreVO vo) {
		
		log.info("-------------");
		log.info(vo);
		
		return "success";
	}
	
	@GetMapping("/sample")
	public StoreVO get() {
		StoreVO vo = new StoreVO();
		vo.setSno(1);
		vo.setSname("김밥천국");
		vo.setLat(121.1234);
		vo.setLat(37.5642);
		
		return vo;
	}
}
