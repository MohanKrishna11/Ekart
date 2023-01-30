package com.techno.ecart.helper;

import java.util.ArrayList;
import java.util.List;

import com.techno.ecart.entity.Product;
import com.techno.ecart.request.ProductDataSaveRequest;
import com.techno.ecart.request.ProductDataUpdateRequest;
import com.techno.ecart.response.ProductDataResponse;

public class ProductHelper {
	
	public static Product productEntityConverter(ProductDataSaveRequest request) {
		Product product = new Product();
		product.setPrdName(request.getPrdName());
		product.setPrice(request.getPrice());
		return product;
		
	}
	
	public static Product productUpdateConverter(ProductDataUpdateRequest request) {
		Product product = new Product();
		product.setId(request.getId());
		product.setPrdName(request.getPrdName());
		product.setPrice(request.getPrice());
		return product;
	}
	
	public static List<ProductDataResponse>productDataConvervter(List<Product> product) {
		List<ProductDataResponse> list = new ArrayList<>();
		for(Product response : product) {
			ProductDataResponse dataResponse = new ProductDataResponse();
		dataResponse.setId(response.getId());
		dataResponse.setPrdName(response.getPrdName());
		dataResponse.setPrice(response.getPrice());
		list.add(dataResponse);
		}
		return list;
	}
}
