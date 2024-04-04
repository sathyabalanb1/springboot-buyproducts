package com.buyproducts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String emaill);
}
