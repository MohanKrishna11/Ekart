package com.techno.ecart.helper;


import java.util.ArrayList;
import java.util.List;

import com.techno.ecart.entity.Cart;
import com.techno.ecart.response.CartDataResponse;

public class CartHelper {

	public static List<CartDataResponse> cartDataConverter(List<Cart> carts) {
		List<CartDataResponse> list = new ArrayList<>();
		for(Cart request : carts) {
			CartDataResponse response = new CartDataResponse();
			response.setId(request.getId());
			response.setQuantity(request.getQuantity());
			response.setUserId(request.getUser().getId());
			list.add(response);
		}
		return list;
	}
		
	 
 }

