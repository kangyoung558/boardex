package com.momtenting.controller;

import java.io.File;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.momtenting.domain.BoardAttachVo;
import com.momtenting.domain.BoardVo;
import com.momtenting.domain.Criteria;
import com.momtenting.domain.PageDTO;
import com.momtenting.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("list")
	public void list(Criteria cri, Model model) {
		log.info("list....");
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping({"get", "modify"})
	public void get(@RequestParam("bno") Long bno ,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get or modify....");
		model.addAttribute("board", service.get(bno));
		model.addAttribute("cri", cri);
	}
	
	@GetMapping("register")
	@PreAuthorize("isAuthenticated()")
	public void register(){
		
	}
	
	@PostMapping("register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVo boardVo, RedirectAttributes rttr) {
		log.info("register....");
		log.info(boardVo);
		boardVo.getAttachList().forEach(log::info); //이거
		service.register(boardVo);
		rttr.addFlashAttribute("result", boardVo.getBno());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("modify")
	@PreAuthorize("principal.username == #boardVo.writer")
	public String modify(BoardVo boardVo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify....");
		log.info(boardVo);
		boardVo.getAttachList().forEach(log::info);
		if(service.modify(boardVo)) {
			rttr.addFlashAttribute("result", "success");	
		}
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("remove")
	@PreAuthorize("principal.username == #writer")
	public String remove(String writer, @RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove....");
		
		List<BoardAttachVo> list = service.getAttachList(bno);
		
		if(service.remove(bno)) {
			deleteFiles(list);
			rttr.addFlashAttribute("result","success");	
		}
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@ResponseBody
	@GetMapping("getAttachList")
	public List<BoardAttachVo> getAttachList(Long bno) {
		log.info("getAttachList..." + bno);
	
		return service.getAttachList(bno);
	}
	
	private void deleteFiles (List<BoardAttachVo> attachList) {
		log.info("deleteFiles........");
		log.info(attachList);
		
		attachList.forEach(attach -> {
			new File(UploadController.UPLOAD_PATH, attach.getDownPath()).delete();
			if(attach.isImage()) {
				new File(UploadController.UPLOAD_PATH, attach.getThumbPath()).delete();
			}
		});
	}
}
