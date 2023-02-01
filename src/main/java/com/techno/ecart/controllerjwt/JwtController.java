package com.techno.ecart.controllerjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ecart.entity.UserDetailsJwtEkart;
import com.techno.ecart.helperjwt.JwtUtil;
import com.techno.ecart.request.JwtRequest;
import com.techno.ecart.response.JwtResponse;
import com.techno.ecart.securityService.UserDetailsEkartService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsEkartService ekartService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception{
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (UsernameNotFoundException e) {
			 e.printStackTrace();
	            throw new Exception("Bad Credentials");
		}catch (BadCredentialsException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
		
		UserDetails userDetails = this.ekartService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtutil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	

}
