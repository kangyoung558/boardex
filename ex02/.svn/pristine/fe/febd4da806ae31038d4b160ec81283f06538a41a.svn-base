package com.momtenting.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.momtenting.domain.Criteria;
import com.momtenting.domain.ReplyVo;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

@Log4j
@WebAppConfiguration
public class ReplyMapperTests {
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test 
	public void testExist() {
		log.info(replyMapper);
	}
	@Test
	public void testInsert() {
		IntStream.range(1, 21).forEach(i -> {
			ReplyVo vo = new ReplyVo();
			vo.setBno(397312L);
			vo.setReply("제이유닛 작성 댓글");
			vo.setReplyer(i + "번째댓글러");
			
			replyMapper.insert(vo);
		});
	}
	@Test
	public void testInsert2() {
			Map<String, Object> vo = new HashMap<String, Object>();
			vo.put("bno", 413744L);
			vo.put("reply", "맴으로 작성한 댓글");
			vo.put("replyer", "맵생성자");
			replyMapper.insert2(vo);
	
	}
	
	@Test
	public void testGetList(){
		replyMapper.getListWithPaging(new Criteria(2, 10), 413744L).forEach(log::info);
	}
	@Test
	public void testGetList2(){
		replyMapper.getListWithPaging2(new Criteria(), 413744L).forEach(log::info);
	}
	
	@Test
	public void testGetListWithShowMore() {
		replyMapper.getListWithShowMore(72L, 413744L).forEach(log::info);
	}
	
	@Test
	public void testUpdate() {
		ReplyVo vo = new ReplyVo();
		vo.setBno(413744L);
		vo.setReply("제이유닛 수정 댓글");
		vo.setRno(62L);
		log.info(replyMapper.update(vo));
	}
	@Test
	public void testRead() {
		log.info(replyMapper.read(62L));
	}
	@Test
	public void testDelete() {
		log.info(replyMapper.delete(63L));
	}
	
}
