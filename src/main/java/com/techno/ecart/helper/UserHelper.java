package com.techno.ecart.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.techno.ecart.entity.User;
import com.techno.ecart.request.UserDataRequest;
import com.techno.ecart.response.UserDataResponse;

public class UserHelper {
	
private final static BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();

	public static UserDataResponse 	UserResponseConverter(User user) {
		UserDataResponse dataResponse = new UserDataResponse();
		dataResponse.setId(user.getId());
		dataResponse.setUserName(user.getUserName());
		dataResponse.setEmailId(user.getEmailId());
		dataResponse.setPassword(user.getPassword());
		return dataResponse;
		
	}
	
	public static User UserEntityConverter(UserDataRequest request) {
		User user = new User();
		user.setEmailId(request.getEmailId());
		user.setUserName(request.getUserName());
		user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		return user;
		
	}

}
