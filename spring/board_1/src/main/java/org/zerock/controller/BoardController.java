package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pageObj")PageParam param, Model model) {
		param.setTotal(service.getTotal());
		model.addAttribute("list", service.getList(param));
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	@PostMapping("/register")
	public String registerPOST(BoardVO board, RedirectAttributes rttr) {
		int count = service.register(board);
		rttr.addFlashAttribute("result", count==1?"INSERT":"FAIL");
		return "redirect:/board/list";
	}
	
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("pageObj")PageParam param, Model model) {
		model.addAttribute("board", service.read(param));
	}

	
	@PostMapping("/modify")
	public String modify(PageParam param, BoardVO board, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("result", service.modify(board)==1?"MODIFY":"FAIL");
		
		return param.getLink("redirect:/board/read");
	}
	
	@PostMapping("/remove")
	public String remove(PageParam param, RedirectAttributes rttr) {
		int count = service.remove(param);
		rttr.addFlashAttribute("result", count==1?"REMOVE":"FAIL");
		return "redirect:/board/list?page="+ param.getPage();
	}
}
