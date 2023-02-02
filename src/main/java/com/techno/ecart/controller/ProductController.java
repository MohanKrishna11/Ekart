package com.techno.ecart.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ecart.request.ProductDataSaveRequest;
import com.techno.ecart.request.ProductDataUpdateRequest;
import com.techno.ecart.response.ProductDataResponse;
import com.techno.ecart.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("addProduct")
	public ResponseEntity<?>  addProducts(@RequestBody ProductDataSaveRequest request){
		productService.addProduct(request);
		return ResponseEntity.ok("Product is Added");
		
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<?> updateProduct(@RequestBody ProductDataUpdateRequest request) {
		productService.updateProduct(request);
		return ResponseEntity.ok("Product is Updated");
		
	}
	
//	@DeleteMapping("/deleteProduct/{id}")
//	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
//		productService.deleteProduct(id);
//		return ResponseEntity.ok("Product is Delete");
//		
//	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<?> deleteProduct(@RequestParam long id) throws Exception {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product is Delete");
		
	}
	
	@GetMapping("/getList")
	public List<ProductDataResponse> getProductlist() throws Exception{
	return productService.productList();
	}
	
	

}
