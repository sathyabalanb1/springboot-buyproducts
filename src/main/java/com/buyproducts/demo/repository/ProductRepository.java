package com.buyproducts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.buyproducts.demo.entity.Product;
import com.buyproducts.demo.entity.Price;
import com.buyproducts.demo.entity.Inventory;



@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	
//	@Query(value="select product.id, product.productname, price.price, inventory.quantity from product left join price on product.id=price.product_id left join inventory on price.product_id = inventory.product_id", nativeQuery = true)
//	public List<Product> fetchAllProducts();
	
//	@Query(value="select product.id, product.productname, price.price, inventory.quantity from product left join price on product.id=price.product_id left join inventory on price.product_id = inventory.product_id", nativeQuery = true)
//	public List<Object[]> fetchAllProducts();
	   

}
