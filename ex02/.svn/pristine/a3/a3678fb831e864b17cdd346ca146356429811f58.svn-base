package com.momtenting.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.momtenting.domain.MemberVo;
import com.momtenting.mapper.MemberMapper;
import com.momtenting.security.domain.CustomUser;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
@Data
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn(username);
		
		MemberVo vo = memberMapper.read(username);
		
		log.warn("member mapper`s vo :: " + vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
	
}
