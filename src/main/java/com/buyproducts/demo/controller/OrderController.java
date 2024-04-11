package com.buyproducts.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.buyproducts.demo.dto.ProductData;

@Controller
public class OrderController {
	
	@PostMapping("/makeorder")
	public void makeOrder (@RequestBody List<ProductData> selectedProducts)
	{
		int x = 55;
		System.out.println("Now we are in makeOrder method");
		return;
	}

}
