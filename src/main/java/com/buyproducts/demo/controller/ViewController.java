package com.buyproducts.demo.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buyproducts.demo.entity.Customer;
import com.buyproducts.demo.entity.Orderedproducts;
import com.buyproducts.demo.entity.Orderplacement;
import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.service.CustomerService;
import com.buyproducts.demo.service.OrderService;
import com.buyproducts.demo.service.ProductService;

@Controller
public class ViewController {
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	OrderService orderservice;
	
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
	
	@GetMapping("/orderdetails")
	public ModelAndView displayOrderDetails ()
	{
		ModelAndView model = new ModelAndView();
		
	//	List<Orderedproducts>ordereditems = orderservice.getOrderedProducts();
		
		List<Orderplacement>ordereditems = orderservice.getOrderedProducts();
		
		model.addObject("ordereditems", ordereditems);
		model.setViewName("order/orderlist.jsp");
		return model;
	}
	
	@GetMapping("/individualorderdetails")
	public ModelAndView displayIndividualOrderDetails(@RequestParam("oid") int orderid)
	{
		ModelAndView model = new ModelAndView();
		
		List<Orderedproducts>orderedproducts = orderservice.getOrderedProductsByOrderId(orderid);
		
	//	List<Orderedproducts>orderedproducts = orderservice.getOrderedProductsByOrderId(orderid);
		
		String customername = orderedproducts.get(0).getOrderid().getCustomerid().getName();
		
		LocalDateTime ordereddate =orderedproducts.get(0).getCreationtime();
		
		boolean orderstatus = orderedproducts.get(0).getOrderid().isEnabled();
		
		LocalDateTime orderupdatedtime = orderedproducts.get(0).getOrderid().getUpdatetime();
		
		if(orderstatus == true)
		{
			model.addObject("orderstatus", "Approved");
		}
		else if(orderstatus == false && orderupdatedtime == null)
		{
			model.addObject("orderstatus","Waiting for Approval");
		}
		else
		{
			model.addObject("orderstatus","Rejected");
		}
		
		
		int quantity = orderedproducts.get(0).getQuantity();
		
		model.addObject("orderid",orderid);
		model.addObject("quantity", quantity);
		model.addObject("orderedproducts", orderedproducts);
		model.addObject("customername", customername);
		model.addObject("ordereddate", ordereddate);
	//	model.addObject("orderstatus", orderstatus);
		model.setViewName("order/orderviewpage.jsp");
		
		return model;
		
	}
	
	@GetMapping("/approvedorderlist")
	public ModelAndView displayApprovedOrders()
	{
		ModelAndView model = new ModelAndView();
		List<Orderplacement>approvedorders = orderservice.getApprovedOrders();
		
		model.addObject("approveditems", approvedorders);
		model.setViewName("order/approvedorderlist.jsp");
		return model;
	}
	
	
	

}
