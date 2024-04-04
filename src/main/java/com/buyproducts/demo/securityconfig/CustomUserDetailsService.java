package com.buyproducts.demo.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.buyproducts.demo.entity.Customer;
import com.buyproducts.demo.repository.CustomerRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private  CustomerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer cusdeal = repository.findByEmail(username);
		
		if (cusdeal == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			UserDetails usd= User.withUsername(cusdeal.getEmail())
                    .password(cusdeal.getPassword())
                    .authorities(cusdeal.getRoleid().getRolename()).build();
			return usd;
		}
	}
}
