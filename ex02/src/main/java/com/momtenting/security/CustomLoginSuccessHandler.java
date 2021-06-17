package com.momtenting.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.warn("login success");

		List<String> roleName = new ArrayList<String>();

		authentication.getAuthorities().forEach(a -> {
			roleName.add(a.getAuthority());
		});

		log.warn("ROLENAME :: " + roleName);

//		if (roleName.contains("ROLE_ADMIN")) {
//			response.sendRedirect("/sample/admin");
//			return;
//		}
//		if (roleName.contains("ROLE_MEMBER")) {
//			response.sendRedirect("/sample/member");
//			return;
//		}
		response.sendRedirect("/");
	}

}
