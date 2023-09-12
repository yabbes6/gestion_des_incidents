package com.java.springboot.map.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.map.SpringBootProject.model.AppUser;
import com.java.springboot.map.SpringBootProject.model.UserForm;
import com.java.springboot.map.SpringBootProject.repository.UserRepository;
import com.java.springboot.map.SpringBootProject.services.AccountServices;

import lombok.Data;
import lombok.extern.java.Log;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private final AccountServices accountService;
	private final UserRepository userRepository;

	@Autowired
	public UserController(AccountServices accountService, UserRepository userRepository) {
		super();
		this.accountService = accountService;
		this.userRepository = userRepository;
	}
	@PostMapping("/register")
	public AppUser register(@RequestBody UserForm userForm) {
		if(userForm.getPassword()==null)
			System.out.println(userForm.getNom());
		return accountService.saveUser(userForm.getNom(), userForm.getPrenom(), userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	}
	@GetMapping("/user")
	//@PreAuthorize("hasAuthority('SCOPE_USER')")
	public List<AppUser> list_user(){
		return userRepository.findAll();
	}
}
