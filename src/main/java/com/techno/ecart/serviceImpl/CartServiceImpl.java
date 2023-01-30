package com.techno.ecart.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.ecart.entity.Cart;
import com.techno.ecart.entity.Product;
import com.techno.ecart.entity.User;
import com.techno.ecart.helper.CartHelper;
import com.techno.ecart.repository.CartRepo;
import com.techno.ecart.repository.ProductRepo;
import com.techno.ecart.repository.UserRepo;
import com.techno.ecart.request.CartDataSaveRequest;
import com.techno.ecart.response.CartDataResponse;
import com.techno.ecart.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public void addCart(CartDataSaveRequest request ) {
//		Cart cart = CartHelper.carttEntityConverter(request);
		
		Optional<Product> product = productRepo.findById(request.getProductId());
		Optional<User> user = userRepo.findById(request.getUserId());
		Cart cart = new Cart();
		cart.setProduct(Arrays.asList(product.get()));
		cart.setUser(user.get());
		cart.setQuantity(request.getQuantity());
		cartRepo.save(cart);
	}

	@Override
	public List<CartDataResponse> findById(long id) throws Exception {
		List<Cart> cart = null;
		try {
			cart = cartRepo.findByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart != null ? CartHelper.cartDataConverter(cart) :  null;
	}

	

}
