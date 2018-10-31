package org.zerock.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageParam;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	private BoardService service;
	
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("pageObj") PageParam param, Model model) {
		getAttachList(param.getBno());
		model.addAttribute("board", service.read(param));
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("pageObj") PageParam param, @ModelAttribute BoardVO board) {
		return "/board/register";
	}
	
	@PostMapping("/register")
	public String registerPost(RedirectAttributes rttr, @Valid BoardVO vo, BindingResult result) {
		
		log.info(vo);
		
		if(result.hasErrors()) {
			return "/board/register";
		}
		
		rttr.addFlashAttribute("result", service.insert(vo)==1?"INSERT":"FAIL");
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void getList(@ModelAttribute("pageObj") PageParam param, Model model) {
		
		param.setCount(service.total(param));
		model.addAttribute("list", service.getList(param));
	}
	
	@PostMapping("/update")
	public String delete(RedirectAttributes rttr, @Valid BoardVO vo, PageParam param, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/board/update";
		}
		
		rttr.addFlashAttribute("result", service.update(vo)==1?"MODIFY":"FAIL");
		return param.getLink("redirect:/board/read");
	}
	
	@PostMapping("/delete")
	public String delete(RedirectAttributes rttr, PageParam param) {
		
		List<BoardAttachVO> attachList = service.getFileList(param.getBno());
		int count = service.delete(param);
		if(count == 1) {
			log.info(attachList);
			log.info("deleteFile");
			deleteFiles(attachList);
		}
		
		rttr.addFlashAttribute("result", count==1?"REMOVE":"FAIL");
		return param.getLink("redirect:/board/list");
	}
	
	//파일처리
	
	@GetMapping(value="/fileList",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(int bno){
		
		return new ResponseEntity<>(service.getFileList(bno),HttpStatus.OK);
	}
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
		
		if(attachList == null) {return;}
		
		attachList.forEach(attach ->{
			Path file = Paths.get("C:\\upload"+attach.getUploadpath()+"\\"+attach.getUuid()+
					"_"+attach.getFilename());
			
			Path thumbFile = Paths.get("C:\\upload"+attach.getUploadpath()+"\\s_"+attach.getUuid()+
					"_"+attach.getFilename());
			try {
				Files.deleteIfExists(file);
				Files.deleteIfExists(thumbFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
	}
	
}
