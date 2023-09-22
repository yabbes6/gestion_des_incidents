package com.java.springboot.map.SpringBootProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.springboot.map.SpringBootProject.exception.RessourceNotFoundException;
import com.java.springboot.map.SpringBootProject.model.AppRole;
import com.java.springboot.map.SpringBootProject.model.AppUser;
import com.java.springboot.map.SpringBootProject.model.Comment;
import com.java.springboot.map.SpringBootProject.model.Incident;
import com.java.springboot.map.SpringBootProject.repository.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional@Slf4j
public class AccountServicesImpl implements AccountServices{

	private UserRepository appUserRepository;
	private AppRoleRepository appRoleRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public AccountServicesImpl(UserRepository appUserRepository, AppRoleRepository appRoleRepository ,BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;
		this.bCryptPasswordEncoder = bcryptPasswordEncoder;
	}

	
	@Override
	public AppUser saveUser(String nom,String prenom,String username, String password) {
		
		AppUser user = appUserRepository.findByUsername(username);
		
		if (user == null) {
			System.out.println(true);
		AppUser appUser = new AppUser();
		
		appUser.setNom(nom);
		appUser.setPrenom(prenom);
		appUser.setUsername(username);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		
		appUserRepository.save(appUser);
		addRoleToUser(username,"USER");
		return appUser;}
		else {
			System.out.println(false);
			return null;
		}
	}
	
	
	@Override
	public AppRole save(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		System.out.println(true);
		AppUser appUser = appUserRepository.findByUsername(username);
		List<AppRole> appRole = appRoleRepository.findAllByRolename(rolename); 
		appUser.getRoles().add(appRole.get(0));
		System.out.println(appRole.size());
	}
	
	 /*public boolean usernameExists(String username) {
	        // Implement logic to check if the username already exists in your UserRepository
	        return appUserRepository.existsByUsername(username);
	   }*/


}