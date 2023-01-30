package com.techno.ecart.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String emailId;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Cart> carts ;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> address ;
	
}
