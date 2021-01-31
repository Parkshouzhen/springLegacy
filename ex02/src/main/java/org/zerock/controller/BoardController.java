package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
@Log4j
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) { //Model: db통해서 가져올 때 필요
		
		log.info("list---------------");
		
		model.addAttribute("list", service.getList());
		
	}
	@GetMapping("/register")
	public void registerGET() {
		
		
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("board: " + board);
		
		Long bno = service.register(board);
		
		log.info("BNO: " + bno);
		
		rttr.addFlashAttribute("result", bno); // 브라우저 주소창에 남지 않음
		// addAttribute 브라우저에 링크와 같이 연결
		return "redirect:/board/list";
				
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		int count = service.modify(board);
		
		if (count==1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		//@RequestParam("bno") 없어도 되는데 구분해주기 위해 명시
		int count = service.remove(bno);
		
		if (count==1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
