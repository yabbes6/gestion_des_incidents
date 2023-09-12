package com.java.springboot.map.SpringBootProject.services;

import com.java.springboot.map.SpringBootProject.model.AppRole;
import com.java.springboot.map.SpringBootProject.model.AppUser;

public interface AccountServices {
	AppUser saveUser(String nom,String prenom,String username,String password,String confirmedPassword);
	AppRole save(AppRole role);
	AppUser loadUserByUsername(String username);
	void addRoleToUser(String username,String rolename);
}
