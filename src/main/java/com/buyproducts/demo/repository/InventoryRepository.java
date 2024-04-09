package com.buyproducts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Integer>{

}
