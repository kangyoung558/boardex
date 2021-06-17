package com.momtenting.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class BoardAttachVo extends AttachFileDTO{
	private Long bno;
}
