package com.techno.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.ecart.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
