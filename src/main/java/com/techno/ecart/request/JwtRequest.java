package com.techno.ecart.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {

	private String username;
	private String password;
}
