package com.momtenting.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	@Insert("INSERT INTO tbl_sample1 VALUES(#{data})")
	public void insertCol1(String data);
}
