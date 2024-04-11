package com.buyproducts.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buyproducts.demo.entity.Customer;
import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.service.CustomerService;
import com.buyproducts.demo.service.ProductService;

@Controller
public class ViewController {
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	CustomerService customerservice;
	
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
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/createproductform")
	public String displayCreateProductForm()
	{
		return "product/createproduct.jsp";
	}
	
	@GetMapping("/displayorderplacementform")
	public ModelAndView displayOrderPlacementForm(Principal principal)
	{
        ModelAndView model = new ModelAndView();
        
        String email = principal.getName();
        
        Customer cus = customerservice.fetchCustomerDetails(email);
        
        int customerid = cus.getId();
		
		List<Product>products = productservice.getProducts();
		
		model.addObject("products", products);
		model.addObject("customerid", customerid);
		model.setViewName("order/makeorder.jsp");
		
		return model;
	}
	
	

}
