package com.techno.ecart.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.techno.ecart.entity.Address;

@Service
public interface AddressService extends JpaRepository<Address, Long>{

}
