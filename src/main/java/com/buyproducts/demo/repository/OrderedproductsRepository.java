package com.buyproducts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Orderedproducts;
import com.buyproducts.demo.entity.Orderplacement;

public interface OrderedproductsRepository extends JpaRepository<Orderedproducts,Integer> {
	
	public List<Orderedproducts> findAllByOrderByIdDesc();
	
	public List<Orderedproducts> findByOrderid(Orderplacement order);

}
