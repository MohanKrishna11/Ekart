package com.techno.ecart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.ecart.entity.Cart;
import com.techno.ecart.entity.Product;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{
	
	
	List<Cart> findByUserId(long id) throws Exception;
	
	List<Product> findByProductId(long id) throws Exception;

}
