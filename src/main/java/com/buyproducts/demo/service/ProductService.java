package com.buyproducts.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyproducts.demo.dto.ProductDTO;
import com.buyproducts.demo.entity.Inventory;
import com.buyproducts.demo.entity.Price;
import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	PriceService priceservice;
	
	@Autowired
	InventoryService inventoryservice;
	
	public Product insertProduct(ProductDTO prod)
	{
		Price price = priceservice.insertPrice(prod);
		
		BigDecimal pr = price.getPrice();
		
		Inventory inventory = inventoryservice.insertInventory(prod);
		
		Product pd = new Product();
		pd.setProductname(prod.getProductname());
		pd.setPriceid(price);
		pd.setInventoryid(inventory);
		Product resultproduct = productrepository.save(pd);
		
	//	priceservice.insertPrice(prod,resultproduct);
		
	//	inventoryservice.insertInventory(prod,resultproduct);
		
		return resultproduct;
		
	}
	
	/*
	public List<Object[]> getProducts()
	{
		System.out.println("Now we are in product service");
		System.out.println(productrepository.fetchAllProducts().get(0).toString());
		return productrepository.fetchAllProducts();
	}
	*/
	
	
	
	public List<Product> getProducts()
	{
		return productrepository.findAll();
	}
	

}
