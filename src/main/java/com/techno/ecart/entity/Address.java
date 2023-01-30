package com.techno.ecart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String addresLine1;
	private String addresLine2;
	private int pincode;
	private String state;
	private boolean shippingAdddress;
	private boolean parmanentAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

}
