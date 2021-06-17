package com.momtenting.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.momtenting.domain.BoardAttachVo;

public interface BoardAttachMapper {
	void insert(BoardAttachVo vo);
	
	void delete(String uuid);
	
	List<BoardAttachVo> findBy(Long bno);
	
	@Delete("delete tbl_attach where bno = #{bno}")
	void deleteAll(Long bno);
	
	@Delete("delete tbl_attach")
	void deleteAllComplete();
	
	@Select("select * from tbl_attach where uploadpath = to_char(sysdate - 1, 'YYYY/MM/DD')")
	List<BoardAttachVo> getOldFiles();
	
}
