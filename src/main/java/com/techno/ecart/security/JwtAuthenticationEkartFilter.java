package com.techno.ecart.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.techno.ecart.helperjwt.JwtUtil;
import com.techno.ecart.securityService.UserDetailsEkartService;

@Component
public class JwtAuthenticationEkartFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsEkartService ekartService; 
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
//		get jwt
//		Bearer
//		validate
		
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
//		null and format 
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = this.jwtUtil.getUsernameFromToken(jwtToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UserDetails userDetails = this.ekartService.loadUserByUsername(username);
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			
			}else {
				System.err.println("Token is not Validate.....");
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
