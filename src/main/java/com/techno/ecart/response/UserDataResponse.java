package com.techno.ecart.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
public class UserDataResponse {
	
	private long id;
	private String emailId;
	private String userName;
	private String password;

}
