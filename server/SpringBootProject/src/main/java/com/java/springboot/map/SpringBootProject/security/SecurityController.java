/*package com.java.springboot.map.SpringBootProject.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController 
public class SecurityController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtEncoder jwtEncoder;
	
	@GetMapping("/users")
	public Authentication authentication(Authentication authentication) {
		return authentication;
	}
	
	@PostMapping("/login")
	public Map<String,String> login(String username,String password) throws Exception{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		
		Instant instant =Instant.now();
		String scope = authentication
				.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		JwtClaimsSet jwtClaimSet = JwtClaimsSet.builder()
				.issuedAt(instant)
				.expiresAt(instant.plus(10,ChronoUnit.MINUTES))
				.subject(username)
				.claim("scope",scope)
				.build();
		JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters
				.from(JwsHeader.with(MacAlgorithm.HS384).build(),jwtClaimSet);
		String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
		
		return Map.of("access-token",jwt);
	}
}*/
