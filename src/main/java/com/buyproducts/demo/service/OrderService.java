package com.buyproducts.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyproducts.demo.dto.ProductData;
import com.buyproducts.demo.entity.Customer;
import com.buyproducts.demo.entity.Orderedproducts;
import com.buyproducts.demo.entity.Orderplacement;
import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.repository.CustomerRepository;
import com.buyproducts.demo.repository.OrderedproductsRepository;
import com.buyproducts.demo.repository.OrderplacementRepository;
import com.buyproducts.demo.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	OrderplacementRepository orderplacementrepository;
	
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	OrderedproductsRepository orderedproductsrepository;
	
	public String  processOrder (List<ProductData>pd)
	{
		int i=0;
		
		Orderplacement op = new Orderplacement();
		
		while(i<pd.size())
		{
			int customerid = pd.get(i).getCustomerid();
					
			Customer cus = customerrepository.findById(customerid).orElse(null);
			op.setCustomerid(cus);
			Orderplacement confirmorder = orderplacementrepository.save(op);
			
			int productid = pd.get(i).getProductid();
			
			Product product = productrepository.findById(productid).orElse(null);
			
			int quantity = pd.get(i).getRequiredquantity();
			
			insertOrder(quantity,product,confirmorder);
			
			i++;
			
		}
		
		return "Order placement successfully completed";
		
	}
	
	public void insertOrder(int quantity,Product product, Orderplacement confirmorder)
	{
		Orderedproducts orderedproducts = new Orderedproducts();
		orderedproducts.setQuantity(quantity);
		orderedproducts.setProductid(product);
		orderedproducts.setOrderid(confirmorder);
		
		orderedproductsrepository.save(orderedproducts);
	}
	/*
	public List<Orderedproducts> getOrderedProducts()
	{
		 return orderedproductsrepository.findAllByOrderByIdDesc();
	}
	*/
	public List<Orderplacement> getOrderedProducts()
	{
		return orderplacementrepository.findAllByOrderByIdDesc();
	}
	
	public List<Orderedproducts> getOrderedProductsByOrderId(int orderid)
	{
		Orderplacement order = orderplacementrepository.findById(orderid).orElse(null);
		return orderedproductsrepository.findByOrderid(order);
	}
	
	/*
	public List<Orderedproducts> getOrderedProductsByOrderId(int orderid)
	{
		
		Orderplacement order = orderplacementrepository.findById(orderid).orElse(null);
		return orderedproductsrepository.findByOrderid(order);
	}
	*/
	
	public void processOrderApproval(int orderid)
	{
		Orderplacement order = orderplacementrepository.findById(orderid).orElse(null);
		order.setEnabled(true);
		orderplacementrepository.save(order);
	}
	
	public List<Orderplacement> getApprovedOrders()
	{
		List<Orderplacement>approvedorders = orderplacementrepository.findApprovedOrders();
		System.out.println(approvedorders.size());
		System.out.println("sathyadev ips");
		return approvedorders;
	}
	

}
