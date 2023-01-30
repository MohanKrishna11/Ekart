package com.techno.ecart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.ecart.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	
	
}
