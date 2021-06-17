package com.momtenting.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
	@GetMapping("all")
	public void doAll() {
		
	}
	@GetMapping("member")
	public void doMember() {
		
	}
	@GetMapping("admin")
	public void doAdmin() {
		
	}
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	@GetMapping("annoMember")
	public void doMember2() {
		log.info("domember2().......");
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("annoAdmin")
	public void doAdmin2() {
		log.info("doadmin2().......");
	}
	
	
//	@Autowired
//	private BoardService boardService;
//	
//	@GetMapping(value="getText", produces="text/plain; charset=utf-8")
//	public String getText() {
//		log.info("Mime type :: " + MediaType.TEXT_PLAIN_VALUE);
//		return "안녕";
//	}
//	
//	@GetMapping("getSample")
//	public SampleVo getSample() {
//		return new SampleVo(112, "스타", "로드");		
//	}
//	
//	@GetMapping("listTest")
//	public List<BoardVo> getList() {
//		return boardService.getList(new Criteria());
//	}
//	
//	@GetMapping("listTest2")
//	public List<SampleVo> getList2() {
//		return IntStream.range(1, 10).mapToObj(i -> new SampleVo(i, i+"frist", i+"last")).collect(Collectors.toList());
//	}
//	
//	@GetMapping(value="check", params={"height", "weight"})
//	public ResponseEntity<SampleVo> check(Double height, Double weight){
//		SampleVo vo = new SampleVo(0, ""+height, ""+weight);
//		
//		ResponseEntity<SampleVo> result = null;
//		
//		if(height < 150){
//			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
//		}
//		else{
//			result = ResponseEntity.status(HttpStatus.OK).body(vo);
//		}
//		return result;
//	}
//	
//	@GetMapping("product")
//	public String[] getPath(String cat, Integer pid) {
//		return new String[] {"category :" + cat, "productid : "+ pid};
//	}
//	@GetMapping("product/{cat}/{pid}")
//	public String[] getPath2(@PathVariable String cat, @PathVariable Integer pid) {
//		return new String[] {"category :" + cat, "productid : "+ pid};
//	}
//	@PostMapping("ticket")
//	public Ticket convert(@RequestBody Ticket ticket) {
//		log.info(ticket);
//		return ticket;
//	}
}
