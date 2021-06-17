package com.momtenting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	@GetMapping("accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("accessDenied .... " + auth);
		model.addAttribute("msg", "Acess Denied( 접근거부)");
	}
	
	@GetMapping("customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error :: "+ error);
		log.info("logout :: "+ logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error check your account");
		}
		if(logout != null) {
			model.addAttribute("logout", "logout sss");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGet() {
		log.info("logout.........");
	}
	
	@PostMapping("/customLogout")
	public void logoutPost(HttpServletRequest req) {
		log.warn(" post  logout.........");
		log.warn(req.getHeader("referer"));
	}
}
