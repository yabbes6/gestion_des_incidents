package com.java.springboot.map.SpringBootProject.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.springboot.map.SpringBootProject.model.AppUser;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	@Value("${jwt.secretkey}")
	private String secretkey ;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager=authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,HttpServletResponse response) {
		 
		try {
			AppUser appUser = new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
			
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(appUser.getUsername(),appUser.getPassword()));

		} catch (IOException e) {
			e.printStackTrace();
			throw  new RuntimeException(e);
		}
	}	
	
	@Override
	public void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,FilterChain chain,Authentication authResult)throws IOException, ServletException {
		User user = (User)authResult.getPrincipal();
		List<String> roles = new ArrayList<>();
		authResult.getAuthorities().forEach(a->{
			roles.add(a.getAuthority());
		});
		String jwt = JWT.create()
				.withIssuer(request.getRequestURI().toString())
				.withSubject(user.getUsername())
				.withArrayClaim("roles",roles.toArray(new String[roles.size()]))
				.withExpiresAt(new Date(System.currentTimeMillis()+SecurityParams.ExPIRATION))
				.sign(Algorithm.HMAC256(SecurityParams.SECRET));
		response.addHeader(SecurityParams.JWT_HEADER_NAME,jwt);
		
	}
	
}
