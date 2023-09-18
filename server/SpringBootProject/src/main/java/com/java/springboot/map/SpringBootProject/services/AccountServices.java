package com.java.springboot.map.SpringBootProject.services;

import java.util.List;
import java.util.Optional;

import com.java.springboot.map.SpringBootProject.model.AppRole;
import com.java.springboot.map.SpringBootProject.model.AppUser;
import com.java.springboot.map.SpringBootProject.model.Comment;
import com.java.springboot.map.SpringBootProject.model.Incident;

public interface AccountServices {
	AppUser saveUser(String nom,String prenom,String username,String password);

	AppRole save(AppRole role);
	AppUser loadUserByUsername(String username);
	void addRoleToUser(String username,String rolename);
	
}
