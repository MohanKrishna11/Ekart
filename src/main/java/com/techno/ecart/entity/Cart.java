package com.techno.ecart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import lombok.Data;

@Entity
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "product_cart",joinColumns = @JoinColumn(name ="product_id"),
	inverseJoinColumns = @JoinColumn(name ="cart_id"))
	private List<Product> product;
	
}
