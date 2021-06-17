package com.momtenting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.momtenting.domain.BoardAttachVo;
import com.momtenting.domain.BoardVo;
import com.momtenting.domain.Criteria;
import com.momtenting.mapper.BoardAttachMapper;
import com.momtenting.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private BoardAttachMapper boardAttachMapper;
	
	@Override
	@Transactional
	public void register(BoardVo boardVo) {
		log.info("register..." + boardVo);
		boardMapper.insertSelectKey(boardVo);
		boardVo.getAttachList().forEach(a -> {
			a.setBno(boardVo.getBno());
			boardAttachMapper.insert(a);
		});
	}

	@Override
	public BoardVo get(Long bno) {
		log.info("get....." + bno);
		return boardMapper.read(bno);
	}

	@Override
	@Transactional
	public boolean modify(BoardVo boardVo) {
		log.info("modify..."+ boardVo);
		boardAttachMapper.deleteAll(boardVo.getBno());
		boardVo.getAttachList().forEach(a -> {
			a.setBno(boardVo.getBno());
			boardAttachMapper.insert(a);
		});
		return boardMapper.update(boardVo) > 0;
	}

	@Override
	@Transactional
	public boolean remove(Long bno) {
		log.info("remover.."+bno);
		boardAttachMapper.deleteAll(bno);
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVo> getList(Criteria cri) {
		log.info("getList...");
		return boardMapper.getListWithPage(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVo> getAttachList(Long bno) {
		log.info("getAttachList...." + bno);
		return boardAttachMapper.findBy(bno);
	}
 
}
