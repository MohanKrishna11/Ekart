package com.techno.ecart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.ecart.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
       
	Optional<User> findByEmailId (String emailId);
}
