package com.momtenting.service;

import java.util.List;

import com.momtenting.domain.BoardAttachVo;
import com.momtenting.domain.BoardVo;
import com.momtenting.domain.Criteria;

public interface BoardService {
	
	void register(BoardVo boardVo); //글 등로
	
	BoardVo get(Long bno); //상세 조회
	
	boolean modify(BoardVo boardVo); //글 수정
	
	boolean remove(Long bno); //글 삭제
	
//	List<BoardVo> getList(); //목록 조회
	List<BoardVo> getList(Criteria cri); //페이징 처리된목록 조회
	
	
	int getTotal(Criteria cri);
	
	List<BoardAttachVo> getAttachList(Long bno);
}
