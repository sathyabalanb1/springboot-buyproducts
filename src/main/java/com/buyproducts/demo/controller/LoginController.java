package com.buyproducts.demo.controller;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	@GetMapping("/success")
	public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
		
		System.out.println("Now we are in loginpageRedirect method");
		
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			if (authority.getAuthority().equals("Dealer")) {
				response.sendRedirect("/dealerfrontpage");
				return;
			} else {
				response.sendRedirect("/customerfrontpage");
				
			}
		}
	
	}

}
