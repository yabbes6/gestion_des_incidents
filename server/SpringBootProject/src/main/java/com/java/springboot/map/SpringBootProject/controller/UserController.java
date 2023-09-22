package com.java.springboot.map.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	/*@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AppUser user) {
	    try {
	        // Validate user input
	        if (user.getUsername() == null || user.getPassword() == null) {
	            return ResponseEntity.badRequest().body("Username and password are required.");
	        }

	        // Check if the username is already in use (You can implement this in your service)
	        if (accountService.usernameExists(user.getUsername())) {
	            return ResponseEntity.badRequest().body("Username already exists.");
	        }

	        // Hash the password
	        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());

	        // Save the user with the hashed password
	        AppUser savedUser = accountService.saveUser(user.getNom(), user.getPrenom(), user.getUsername(), hashedPassword);

	        return ResponseEntity.ok(savedUser);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user.");
	    }
	}*/
	
	/*@PostMapping("/register")
	public ResponseEntity<UserForm> register(@RequestBody AppUser user) {
	    try {
	        // Validate user input
	        if (user.getUsername() == null || user.getPassword() == null) {
	            return ResponseEntity.badRequest()
	                .body(new UserForm(false, "Username and password are required."));
	        }

	        // Check if the username is already in use (You can implement this in your service)
	        if (accountService.usernameExists(user.getUsername())) {
	            return ResponseEntity.badRequest()
	                .body(new UserForm(false, "Username already exists."));
	        }

	        // Hash the password
	        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());

	        // Save the user with the hashed password
	        accountService.saveUser(user.getNom(), user.getPrenom(), user.getUsername(), hashedPassword);

	        // Return a success response
	        return ResponseEntity.ok(new UserForm(true, "Registration successful."));
	    } catch (Exception e) {
	    	e.getMessage();
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(new UserForm(false, "Error registering user."));
	    }
	}*/	

	@GetMapping("/user")
	// @PreAuthorize("hasAuthority('SCOPE_USER')")
	public List<AppUser> list_user() {
		return userRepository.findAll();
	}

}
