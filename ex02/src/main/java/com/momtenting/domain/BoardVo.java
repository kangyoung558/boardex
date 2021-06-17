package com.momtenting.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVo {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	private int replyCnt;

	
	private List<BoardAttachVo> attachList = new ArrayList<BoardAttachVo>();
}
