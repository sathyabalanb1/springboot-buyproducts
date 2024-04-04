package com.buyproducts.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.buyproducts.demo.entity.Customer;
import com.buyproducts.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping("/insertcustomer")
	public String insertCustomer(Customer customer, Model model)
	{
		String message = service.addCustomer(customer);

		if(message == null) {
			model.addAttribute("info",false); 
			return "authentication/register.jsp";

		}
		else {
			model.addAttribute("info", true); 
			return "authentication/register.jsp"; 
		}
		
	}

}
