package com.techno.ecart.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize
@Data
public class ProductDataResponse {
	
	private Long id;
	private String prdName;
	private Double price;

}
