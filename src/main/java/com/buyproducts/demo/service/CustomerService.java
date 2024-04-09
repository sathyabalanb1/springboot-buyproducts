package com.buyproducts.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.buyproducts.demo.entity.Customer;
import com.buyproducts.demo.entity.Role;
import com.buyproducts.demo.repository.CustomerRepository;
import com.buyproducts.demo.repository.RoleRepository;

@Service
public class CustomerService {
	
	@Autowired
	private RoleRepository rolerepository;
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	public String addCustomer(Customer cus)
	{
		Role role = rolerepository.findByRolename("Customer").get(0);
		cus.setRoleid(role);
		
		String inputemail = cus.getEmail();
		Customer existingcustomer = customerrepository.findByEmail(inputemail);
		
		if (existingcustomer != null) {
			return null; 
		} else { 	
		 String encryptedpassword = passwordEncoder.encode(cus.getPassword());
		 cus.setPassword(encryptedpassword);
		   customerrepository.save(cus);

			return "User Registered Successfully";

		}
		
	}
	*/
	public Customer addCustomer(Customer cus)
	{
		Role role = rolerepository.findByRolename("Customer").get(0);
		cus.setRoleid(role);
		
		String inputemail = cus.getEmail();
		Customer existingcustomer = customerrepository.findByEmail(inputemail);
		
		if (existingcustomer != null) {
			return null; 
		} else { 	
		 String encryptedpassword = passwordEncoder.encode(cus.getPassword());
		 cus.setPassword(encryptedpassword);
		 Customer c = customerrepository.save(cus);

			return c;

		}
		
	}
	
	

}
