package com.buyproducts.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyproducts.demo.dto.ProductDTO;
import com.buyproducts.demo.entity.Price;
import com.buyproducts.demo.repository.PriceRepository;

@Service
public class PriceService {
	
	@Autowired
	PriceRepository pricerepository;
	
	public Price insertPrice(ProductDTO prod)
	{
		Price price = new Price();
		price.setPrice(prod.getPrice());
		
		BigDecimal pr = price.getPrice();
		//price.setProductid(pr);
		Price p = pricerepository.save(price);
		return p;
	}

}
