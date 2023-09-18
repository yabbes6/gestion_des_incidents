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
	private IncidentRepository incidentRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public AccountServicesImpl(UserRepository appUserRepository, AppRoleRepository appRoleRepository ,IncidentRepository incidentRepository,BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;
		this.incidentRepository= incidentRepository;
		this.bCryptPasswordEncoder = bcryptPasswordEncoder;
	}

	
	@Override
	public AppUser saveUser(String nom,String prenom,String username, String password) {
		
		AppUser user = appUserRepository.findByUsername(username);
		
		AppUser appUser = new AppUser();
		
		appUser.setNom(nom);
		appUser.setPrenom(prenom);
		appUser.setUsername(username);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		
		appUserRepository.save(appUser);
		addRoleToUser(username,"USER");
		return appUser;
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
		AppUser appUser = appUserRepository.findByUsername(username);
		AppRole appRole = appRoleRepository.findByRolename(rolename); 
		appUser.getRoles().add(appRole);
		
		
	}


}