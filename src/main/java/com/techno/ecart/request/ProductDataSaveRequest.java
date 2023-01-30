package com.techno.ecart.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDataSaveRequest {

	private String prdName;
	private Double price;
}
