package com.momtenting.service;

import java.util.List;

import com.momtenting.domain.Criteria;
import com.momtenting.domain.ReplyPageDTO;
import com.momtenting.domain.ReplyVo;

public interface ReplyService {
	int register(ReplyVo vo);
	
	ReplyVo get(Long rno);
	
	int modify(ReplyVo vo);
	
	int remove(Long rno);
	
	List<ReplyVo> getList(Criteria cri, Long bno);
	
	ReplyPageDTO getListPage(Criteria cri, Long bno);
	
	List<ReplyVo> getListMore(Long rno, Long bno);
}
