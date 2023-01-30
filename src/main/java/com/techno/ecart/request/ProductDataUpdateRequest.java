package com.techno.ecart.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDataUpdateRequest {

	private Long id;
	private String prdName;
	private Double price;
}
