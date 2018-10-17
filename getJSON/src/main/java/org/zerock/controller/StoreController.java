package org.zerock.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.zerock.domain.StoreVO;

import org.zerock.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/store/*")
@Log4j
@AllArgsConstructor	//자동주입, setter 안써도딤
public class StoreController {

	private StoreService service;
	
	@GetMapping("/stores")
	public @ResponseBody List<StoreVO> getStores(String cat){
		return service.getStores(cat);
	}
	
	@GetMapping("/list") 
	public void list() { 
	log.info("list....page"); 
	} 


}
