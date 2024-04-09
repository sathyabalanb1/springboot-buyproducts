package com.buyproducts.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyproducts.demo.dto.ProductDTO;
import com.buyproducts.demo.entity.Inventory;
import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryrepository;
	
	public Inventory insertInventory(ProductDTO prod)
	{
		Inventory inventory = new Inventory();
		inventory.setQuantity(prod.getProductquantity());
		Inventory invent = inventoryrepository.save(inventory);
		return invent;
	}

}
