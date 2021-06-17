package com.momtenting.security.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.momtenting.domain.AuthVo;
import com.momtenting.domain.MemberVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@ToString
@Log4j
public class CustomUser extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberVo vo;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberVo vo) {
//		super(vo.getUserid(), vo.getUserpw(), getList(vo));
		super(vo.getUserid(), vo.getUserpw(), vo.getAuthList().stream().map(
				a -> {
				log.info(a);
				log.info(a.getAuth());
				return new SimpleGrantedAuthority(a.getAuth());
				}).collect(Collectors.toList()));
		this.vo = vo;
	}
	
	public static List<GrantedAuthority> getList(MemberVo vo) {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		List<AuthVo> authList =  vo.getAuthList();
		for(int i=0; i <authList.size(); i++) {
			String auth = authList.get(i).getAuth();
			GrantedAuthority ga = new SimpleGrantedAuthority(auth);
			list.add(ga);
		}
		return list;
	}
}
