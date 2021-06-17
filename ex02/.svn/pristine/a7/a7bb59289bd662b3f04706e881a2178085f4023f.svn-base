package com.momtenting.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.momtenting.domain.Criteria;
import com.momtenting.domain.ReplyVo;

public interface ReplyMapper {

	int insert(ReplyVo vo);
	
	int insert2(Map<String, Object> vo);
	
	ReplyVo read(Long rno);
	
	int update(ReplyVo vo);
	
	int delete(Long rno);
	
	List<ReplyVo> getListWithPaging(@Param("cri")Criteria cri, @Param("bno") Long bno);
	
	List<Map<String, Object>> getListWithPaging2(@Param("cri")Criteria cri, @Param("bno") Long bno);
	
	int getTotalCount(@Param("cri")Criteria cri, @Param("bno") Long bno);
	
	List<ReplyVo> getListWithShowMore(@Param("rno") Long rno, @Param("bno") Long bno);
	
}
