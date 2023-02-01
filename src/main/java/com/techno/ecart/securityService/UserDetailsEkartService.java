package com.techno.ecart.securityService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techno.ecart.entity.User;
import com.techno.ecart.entity.UserDetailsJwtEkart;
import com.techno.ecart.repository.UserRepo;

@Service
public class UserDetailsEkartService  implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.findByEmailId(username);
		if(user.isPresent() && user.get().getEmailId().equals(username)) {
			UserDetailsJwtEkart response = new UserDetailsJwtEkart(username,user.get().getPassword());
			return response;
		}
		
		return null;
	}
	
	

}
