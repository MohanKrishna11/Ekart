package com.techno.ecart.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonSerialize
public class CartDataResponse {

	private long id;
	private String quantity;
	private long UserId;

}
