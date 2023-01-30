package com.techno.ecart.serviceImpl;

import static com.techno.ecart.constant.ErrorMessage.USER_ALREADY_PRESENT_EXCEPTION;
import static com.techno.ecart.constant.ErrorMessage.USER_NOT_FOUND_EXCEPTION;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techno.ecart.entity.Address;
import com.techno.ecart.entity.User;
import com.techno.ecart.helper.UserHelper;
import com.techno.ecart.repository.AddressRepo;
import com.techno.ecart.repository.UserRepo;
import com.techno.ecart.request.UserDataRequest;
import com.techno.ecart.request.UserLoginRequest;
import com.techno.ecart.response.UserDataResponse;
import com.techno.ecart.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	private final static BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public UserDataResponse getUserByemailId(String emailId) throws Exception {
		Optional<User> user = null;
		try {
			user = userRepo.findByEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user.isPresent() == true ? UserHelper.UserResponseConverter(user.get()) : null;
	}
	
	private boolean userDedupe(String emailId) {
	      boolean isPresent = Boolean.FALSE;
	        Optional<User> user = userRepo.findByEmailId(emailId);
	        if(user.isPresent()) {
	            isPresent = Boolean.TRUE;
	        }
	        return isPresent;
	    }

	@Override
	public UserDataResponse saveUserDataRequest(UserDataRequest request) throws Exception {
		
		boolean isPresent = userDedupe(request.getEmailId());
	       if (!isPresent) {
	        User user = userRepo.save(UserHelper.UserEntityConverter(request));
	   		Address address =new Address();
			address.setAddresLine1(request.getAddresLine1());
			address.setAddresLine2(request.getAddresLine2());
			address.setPincode(request.getPincode());
			address.setState(request.getState());
			address.setShippingAdddress(request.isShippingAdddress());
			address.setParmanentAddress(request.isParmanentAddress());
			address.setUser(user);
			addressRepo.save(address);
	           return UserHelper.UserResponseConverter(user);
	       } else {
	           throw new Exception(USER_ALREADY_PRESENT_EXCEPTION);
	       }
	}

	@Override
	public boolean loginByEmailId(UserLoginRequest loginRequest) throws Exception {
		 Optional<User> user = null;
		 try {
			user = userRepo.findByEmailId(loginRequest.getEmailId());
			if(user.isPresent()) {
			boolean result = encoder.matches(loginRequest.getPassword(), user.get().getPassword());
			return result;
			}else {
				throw new Exception(USER_NOT_FOUND_EXCEPTION) ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	}

}
