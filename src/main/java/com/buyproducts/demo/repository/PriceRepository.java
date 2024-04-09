package com.buyproducts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Price;

public interface PriceRepository extends JpaRepository<Price,Integer>{

}
