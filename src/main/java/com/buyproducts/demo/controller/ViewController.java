package com.buyproducts.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
	
	@GetMapping("/registerform")
	public String displayCustomerRegisterForm()
	{
		return "/authentication/register.jsp";
	}
	
	@GetMapping("/loginform")
		public String displayHomepage()
	{
		return "/authentication/loginform.jsp";
		//return "hi";
	}
	
	@GetMapping("/customerfrontpage")
	public String displayCustomerpage()
	{
		return "customer/customerfrontpage.jsp";
	}
	
	@GetMapping("/dealerfrontpage")
	public String displayDealerpage()
	{
		return "dealer/dealerfrontpage.jsp";
	}
	@GetMapping("/home")
	@ResponseBody
	public String home()
	{
		return "home";
	}
	
	

}
