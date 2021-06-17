package com.momtenting.service;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momtenting.domain.BoardVo;
import com.momtenting.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
		log.info(service);
	}
	
	@Test
	public void testRegister() {
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("단위 테스트 작성 제목 in Service");
		boardVo.setContent("단위 테스트 작성 내용 in Service");
		boardVo.setWriter("kang");
		
		service.register(boardVo);
		
		log.info("생성된 게시글의 번호 :" + boardVo.getBno());
	}
	
	@Test
	public void testGetList(){
		service.getList(new Criteria()).forEach(log::info);
	}
	
	@Test
	public void testGet() {
		log.info(service.get(413733L));
	}
	@Test
	public void testRemove() {
		log.info("remove result :" + service.remove(413743L));
	}
	
	@Test
	public void testUpdate() {
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("수정된 단위 테스트 작성 in service");
		boardVo.setContent("수정된 단위 테스트 작성 in service");
		boardVo.setWriter("kang");
		boardVo.setBno(5L);
		
		log.info(service.modify(boardVo));
	}
	
	@Test
	public void testGetTotal() {
		log.info(service.getTotal(new Criteria()));
	}
}
