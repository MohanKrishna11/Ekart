package com.techno.ecart.request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDataRequest {

	private String emailId;
	private String role;
	private String password;
	private String userName;
	private String addresLine1;
	private String addresLine2;
	private int pincode;
	private String state;
	private boolean shippingAdddress;
	private boolean parmanentAddress;
	
}
