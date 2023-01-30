package com.techno.ecart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techno.ecart.entity.Product;
import com.techno.ecart.request.ProductDataSaveRequest;
import com.techno.ecart.request.ProductDataUpdateRequest;
import com.techno.ecart.response.ProductDataResponse;

@Service
public interface ProductService {
	
      void updateProduct(ProductDataUpdateRequest request);
      void addProduct(ProductDataSaveRequest request);
      void deleteProduct(long id);
      List<ProductDataResponse> productList ();
}
