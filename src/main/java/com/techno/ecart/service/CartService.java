package com.techno.ecart.service;


import java.util.List;

import com.techno.ecart.entity.Cart;
import com.techno.ecart.request.CartDataSaveRequest;
import com.techno.ecart.response.CartDataResponse;

public interface CartService {

    void addCart( CartDataSaveRequest request);
    
//    Cart getCart(long id);
    
    List<CartDataResponse> findById(long id) throws Exception;
    
   
}
