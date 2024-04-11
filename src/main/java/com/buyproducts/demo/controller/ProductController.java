package com.buyproducts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buyproducts.demo.dto.ProductDTO;
import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/addproduct")
	public String addProduct (ProductDTO prod,Model model)
	{
		Product pr = productservice.insertProduct(prod);
		
		if(pr != null)
		{
			model.addAttribute("insertinfo", true);
		}
		
		return "product/createproduct.jsp";
		
		
	}
	
	
	
	@GetMapping("/productlist")
	public ModelAndView listProducts ()
	{
		ModelAndView model = new ModelAndView();
		
		List<Product>products = productservice.getProducts();
		
		model.addObject("products", products);
		model.setViewName("product/productlist.jsp");
		
		return model;
	}
	
	
	

}
