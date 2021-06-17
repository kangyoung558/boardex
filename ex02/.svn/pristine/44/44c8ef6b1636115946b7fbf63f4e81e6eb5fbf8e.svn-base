package com.momtenting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.momtenting.mapper.Sample1Mapper;
import com.momtenting.mapper.Sample2Mapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
public class SamplrTxServiceImpl  implements SamplrTxService{
	private Sample1Mapper sampl1eMapper;
	private Sample2Mapper sampl2eMapper;
	
	@Override
	public void addData(String value) {
		log.info("mapper1.............");
		sampl1eMapper.insertCol1(value);
		log.info("mapper2.............");
		sampl2eMapper.insertCol2(value);
		log.info("end.......");
		
		
	}
 
}
