package com.java.springboot.map.SpringBootProject.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.map.SpringBootProject.exception.RessourceNotFoundException;
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
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserController(AccountServices accountService,BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
		super();
		this.accountService = accountService;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/register")
	public AppUser register(@RequestBody AppUser user) {
		try {
			if (user.getPassword() == null)
				System.out.println(user.getNom());
			return accountService.saveUser(user.getNom(), user.getPrenom(), user.getUsername(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

		
	}
	

	@GetMapping("/user")
	// @PreAuthorize("hasAuthority('SCOPE_USER')")
	public List<AppUser> list_user() {
		return userRepository.findAll();
	}
	
	@DeleteMapping("/user/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable String username) {
	    // Find the user by username
	    AppUser user = userRepository.findByUsername(username);

	    if (user == null) {
	        // User not found, return a response with status code 404 (Not Found)
	        return ResponseEntity.notFound().build();
	    }

	    // Delete the user from the repository
	    userRepository.delete(user);

	    // Return a response with status code 204 (No Content) to indicate successful deletion
	    return ResponseEntity.noContent().build();
	}

}
