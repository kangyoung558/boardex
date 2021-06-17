package com.momtenting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.momtenting.domain.Criteria;
import com.momtenting.domain.ReplyPageDTO;
import com.momtenting.domain.ReplyVo;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

@Log4j
@WebAppConfiguration
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService replyService;
	
	@Test
	public void testService() {
		log.info(replyService);
	}
	
	@Test
	public void testRegister() {
		ReplyVo vo = new ReplyVo();
		vo.setBno(413744L);
		vo.setReply("서비스 작성글");
		vo.setReplyer("작성자");
		log.info("register..." + replyService.register(vo));
	}

	@Test
	public void testGet() {
		Long rno = 68L;
		log.info("get..." + replyService.get(rno));
	}

	@Test
	public void testModify() {
		ReplyVo vo = new ReplyVo();
		vo.setRno(68L);
		vo.setReply("서비스 작성글");
		log.info("modify..." + replyService.modify(vo));
	}

	@Test
	public void testRemove() {
		Long rno = 81L;
		log.info("remove..." + replyService.remove(rno));
	}

	@Test
	public void testGetList() {
		replyService.getList(new Criteria(), 413744L).forEach(log::info);
	}
	
	@Test
	public void testGetListPage() {
		ReplyPageDTO dto = replyService.getListPage(new Criteria(4, 10), 413744L);
		log.info(dto);
		log.info(dto.getCri());
		log.info(dto.getStartPage());
		log.info(dto.getEndPage());
		log.info(dto.getTotal());
		log.info(dto.isPrev());
		log.info(dto.isNext());
		dto.getList().forEach(log::info);
	}
	
	
	
	
}
