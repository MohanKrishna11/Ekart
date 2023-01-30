package com.techno.ecart.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CartDataSaveRequest {
	
	private String quantity;
	private Long userId;
	private long productId;
}
