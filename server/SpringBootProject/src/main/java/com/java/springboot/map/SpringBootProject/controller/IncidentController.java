package com.java.springboot.map.SpringBootProject.controller;

import java.util.List;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.java.springboot.map.SpringBootProject.model.AppUser;
import com.java.springboot.map.SpringBootProject.model.Comment;
import com.java.springboot.map.SpringBootProject.model.Incident;
import com.java.springboot.map.SpringBootProject.repository.CommentRepository;
import com.java.springboot.map.SpringBootProject.repository.IncidentRepository;
import com.java.springboot.map.SpringBootProject.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {
	
	private final IncidentRepository incidentRepository;
	private final CommentRepository commentRepository;
	
	public IncidentController(IncidentRepository incidentRepository, CommentRepository commentRepository, UserRepository userRepository) {
		this.incidentRepository = incidentRepository;
		this.commentRepository = commentRepository;
		
	}
	
	
	@GetMapping("/incidents")
	//@PreAuthorize("hasAuthority('SCOPE_USER')")
	public List<Incident> list_incident(){
		return incidentRepository.findAll();
	}
	@GetMapping("/comments")
	//@PreAuthorize("hasAuthority('SCOPE_USER')")
	public List<Comment> list_comment(){
		return commentRepository.findAll();
	}
	
	@PostMapping("/incidents")
	//@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	public Incident createIncident(@RequestBody Incident incident) {
		
		return incidentRepository.save(incident);
	}
	
	@GetMapping("/incidents/{id}")
	public List<Comment> appointmentList(@PathVariable Long id){
        Incident incident = incidentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid patient ID"));
        List<Comment> commentList = commentRepository.findByIncident(incident);

        return commentList;
    }
	
	@GetMapping("/recherche")
	public List<Incident> chercherIncident(@RequestParam String nickname) {
		return incidentRepository.searchByNickname(nickname);
	}
	
	/*@PostMapping("/users")
	public Incident createUser(@RequestBody String username,@RequestBody Incident incident) {
		AppUser user = userRepository.findByName(username);
		
		Incident savedUser = incidentRepository.save(incident);
		return savedUser;
	}*/
	
	/*@GetMapping("/modify")
	public Incident modify(Long id) {
		Optional<Incident> incident = incidentRepository.findById(id);
		
		return incidentRepository.saveAll(incident);
	}*/
	
}
