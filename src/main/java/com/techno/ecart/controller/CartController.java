package com.techno.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ecart.entity.Cart;
import com.techno.ecart.request.CartDataSaveRequest;
import com.techno.ecart.response.CartDataResponse;
import com.techno.ecart.service.CartService;

@RestController
public class CartController {
    @Autowired
	private CartService cartService;

//	getUser
	@GetMapping("/get")
	public List<CartDataResponse> getCart(@RequestParam long id) throws Exception {
		return cartService.findById(id);
	}

//	addCart
	@PostMapping("/addCart")
	public ResponseEntity<?> addCartt(@RequestBody CartDataSaveRequest request) {
		System.out.println(request);
		cartService.addCart(request);
		return ResponseEntity.ok("Cart is Added");

	}

}
