package com.techno.ecart.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.ecart.entity.Product;
import com.techno.ecart.helper.ProductHelper;
import com.techno.ecart.repository.ProductRepo;
import com.techno.ecart.request.ProductDataSaveRequest;
import com.techno.ecart.request.ProductDataUpdateRequest;
import com.techno.ecart.response.ProductDataResponse;
import com.techno.ecart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;
	
//	Update Api
	@Override
	public void updateProduct(ProductDataUpdateRequest request) {
		Product product = ProductHelper.productUpdateConverter(request);
		productRepo.save(product);
	}

//	Add Api
	@Override
	@Transactional
	public void addProduct(ProductDataSaveRequest request) {
		Product product = ProductHelper.productEntityConverter(request);
			 productRepo.save(product);
	}

//	Delete Api
	@Override
	public void deleteProduct(long id) {
		productRepo.deleteById(id);
		
	}

//	GetAll Api
	@Override
	public List<ProductDataResponse> productList() {
		
		List<Product> list = productRepo.findAll();
		List<ProductDataResponse> productList = ProductHelper.productDataConvervter(list);
		return productList;
	}

}
