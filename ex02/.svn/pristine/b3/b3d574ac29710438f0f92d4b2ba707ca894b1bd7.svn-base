package com.momtenting.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.momtenting.domain.BoardVo;
import com.momtenting.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVo> getList();
	
	public List<BoardVo> getListWithPage(Criteria cri);
	
	public void insert(BoardVo boardVo);
	
	public void insertSelectKey(BoardVo boardVo);
	
	public BoardVo read(Long bno);

	public int delete(Long bno);
	
	public int update(BoardVo boardVo);
	
	public int getTotalCount(Criteria cri);
	
	@Update("update tbl_board set replycnt = replycnt + #{amount} where bno = #{bno}")
	void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
