package com.techno.ecart.service;

import org.springframework.stereotype.Service;

import com.techno.ecart.request.UserDataRequest;
import com.techno.ecart.request.UserLoginRequest;
import com.techno.ecart.response.UserDataResponse;

@Service
public interface UserService {
	
	UserDataResponse getUserByemailId(String emailid) throws Exception;
	UserDataResponse saveUserDataRequest(UserDataRequest emailid) throws Exception;
    boolean loginByEmailId(UserLoginRequest loginRequest) throws Exception;
}
