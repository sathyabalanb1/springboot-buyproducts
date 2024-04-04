package com.buyproducts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyproducts.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
	
	public List<Role> findByRolename(String rolename);
}
