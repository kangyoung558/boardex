package com.momtenting.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyPageDTO extends PageDTO{
	private List<ReplyVo> list;
	
	public ReplyPageDTO(Criteria cri, int total) {
		super(cri, total);
	}
	
	public ReplyPageDTO(Criteria cri, int total, List<ReplyVo> list) {
		super(cri, total);
		this.list = list;
	}
	
}
