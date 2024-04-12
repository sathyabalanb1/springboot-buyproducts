package com.buyproducts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Orderplacement;

public interface OrderplacementRepository extends JpaRepository<Orderplacement,Integer> {

}
