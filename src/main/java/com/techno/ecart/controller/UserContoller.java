package com.techno.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ecart.request.UserDataRequest;
import com.techno.ecart.request.UserLoginRequest;
import com.techno.ecart.response.UserDataResponse;
import com.techno.ecart.service.UserService;



@RestController
public class UserContoller {
	
	@Autowired
	private UserService service;
	
//	getUser
	@GetMapping("/getUser")
	public UserDataResponse getUser(@RequestParam String emailId) throws Exception {
		return service.getUserByemailId(emailId);
	}
	
//	addUser
	@PostMapping("/signUp")
	public UserDataResponse singUp(@RequestBody UserDataRequest request) throws Exception {
		return service.saveUserDataRequest(request);
	}
		
	
//	login
	@PostMapping("/login")
	public boolean logIn(@RequestBody UserLoginRequest request) throws Exception {
		return service.loginByEmailId(request);
		
	}
	

}
