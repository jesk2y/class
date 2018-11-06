package org.zerock.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class LoginController {

	private MemberService service;
	
	@GetMapping("/signup")
	public void signUp(@ModelAttribute("memberVO") MemberVO vo ) {
		
	}
	
	@PostMapping("/signup")
	public String signUpPost(RedirectAttributes rttr, @Valid MemberVO vo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/signup";
		}
		
		List<MemberVO> list = service.getUserList();
		
		for (MemberVO member : list) {
			if(member.getId().equals(vo.getId())) {
				rttr.addFlashAttribute("result","result");
				return "redirect:/signup";
			}
		}
		
		service.signUp(vo);

		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	
	@PostMapping("/login")
	public void loginPost(String id, String pw, Model model) {

		for (MemberVO member : service.getUserList()) {
			log.info(member.getId());
			if(id.equals(member.getId()) && pw.equals(member.getPw())){
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				log.info(vo);
				model.addAttribute("member",vo);
				break;
			}
		}
	}
	
}
