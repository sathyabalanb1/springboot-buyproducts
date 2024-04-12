package com.buyproducts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Orderedproducts;

public interface OrderedproductsRepository extends JpaRepository<Orderedproducts,Integer> {

}
