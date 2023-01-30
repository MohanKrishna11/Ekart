package com.techno.ecart.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginRequest {

	private String emailId;
	private String password;
}
