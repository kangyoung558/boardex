package com.momtenting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.momtenting.domain.Criteria;
import com.momtenting.domain.ReplyPageDTO;
import com.momtenting.domain.ReplyVo;
import com.momtenting.mapper.BoardMapper;
import com.momtenting.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
@Transactional
public class ReplyServiceImpl implements ReplyService{
	

	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int register(ReplyVo vo) {
		log.info("register..." + vo);
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVo get(Long rno) {
		log.info("get..." + rno);
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVo vo) {
		log.info("modify..." + vo);
		return replyMapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove..." + rno);
		boardMapper.updateReplyCnt(get(rno).getBno(), -1);
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVo> getList(Criteria cri, Long bno) {
		log.info("getList..{"+ bno +"}...{" + cri + "}");
		return replyMapper.getListWithPaging(cri, bno);
	}
	
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(cri, replyMapper.getTotalCount(cri, bno), replyMapper.getListWithPaging(cri, bno));
	}

	@Override
	public List<ReplyVo> getListMore(Long rno, Long bno) {
		return replyMapper.getListWithShowMore(rno, bno);
	}
}
