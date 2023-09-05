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


@RestController
@RequestMapping
//@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {
	
	private final IncidentRepository incidentRepository;
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	
	public IncidentController(IncidentRepository incidentRepository, CommentRepository commentRepository, UserRepository userRepository) {
		this.incidentRepository = incidentRepository;
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
		
	}
	
	
	@GetMapping("/incidents")
	@PreAuthorize("hasAuthority('USER')")
	public List<Incident> list_incident(){
		return incidentRepository.findAll();
	}
	@GetMapping("/comments")
	@PreAuthorize("hasAuthority('USER')")
	public List<Comment> list_comment(){
		return commentRepository.findAll();
	}
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('USER')")
	public List<AppUser> list_user(){
		return userRepository.findAll();
	}
	
	@PostMapping("/incidents")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Incident createIncident(@RequestBody Incident incident) {
		return incidentRepository.save(incident);
	}
	
	@GetMapping("/recherche")
	public List<Incident> chercherIncident(@RequestParam String nickname) {
		
		return incidentRepository.searchByNickname(nickname);
	}
	
	/*@GetMapping("/modify")
	public Incident modify(Long id) {
		Optional<Incident> incident = incidentRepository.findById(id);
		
		return incidentRepository.saveAll(incident);
	}*/
	
}
