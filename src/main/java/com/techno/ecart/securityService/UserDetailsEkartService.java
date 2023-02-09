package com.techno.ecart.securityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+user.get().getRole());
			authorities.add(simpleGrantedAuthority);
			UserDetailsJwtEkart response = new UserDetailsJwtEkart(username,user.get().getPassword(),authorities);
			
			return response;
		}
		
		return null;
	}
	
	

}
