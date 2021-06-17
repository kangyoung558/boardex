package com.momtenting.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

@Log4j
@WebAppConfiguration
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(mvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "6")
				.param("amount", "20")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testGet() throws Exception {
		log.info(mvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "412539")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception {
		log.info(mvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "컨트롤러 테스트 제목")
					.param("content", "컨트롤러 테스트 내용")
					.param("writer", "kim")
					)
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
	@Test
	public void testModify() throws Exception {
		log.info(mvc.perform(MockMvcRequestBuilders.post("/board/modify")
					.param("title", "컨트롤러 테스트 제목 수정")
					.param("content", "컨트롤러 테스트 내용 수정")
					.param("writer", "kim")
					.param("bno", "201")
					)
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
	@Test
	public void testRemove() throws Exception {
		log.info(mvc.perform(MockMvcRequestBuilders.post("/board/remove")
					.param("bno", "13")
					)
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
}
