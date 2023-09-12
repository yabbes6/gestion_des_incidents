package com.java.springboot.map.SpringBootProject.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springboot.map.SpringBootProject.model.AppUser;
import com.java.springboot.map.SpringBootProject.services.AccountServices;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountServices accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		
		AppUser user = accountService.loadUserByUsername(username);
				if (user==null)new UsernameNotFoundException("invalid user");
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				user.getRoles().forEach(r->{
					authorities.add(new SimpleGrantedAuthority( r.getRolename()));
				});
		
		return new User(user.getUsername(),user.getPassword(),authorities);
	}
}
