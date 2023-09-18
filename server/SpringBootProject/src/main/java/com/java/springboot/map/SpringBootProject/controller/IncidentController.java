package com.java.springboot.map.SpringBootProject.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.java.springboot.map.SpringBootProject.model.AppUser;
import com.java.springboot.map.SpringBootProject.model.Comment;
import com.java.springboot.map.SpringBootProject.model.Incident;
import com.java.springboot.map.SpringBootProject.repository.CommentRepository;
import com.java.springboot.map.SpringBootProject.repository.IncidentRepository;
import com.java.springboot.map.SpringBootProject.repository.UserRepository;
import com.java.springboot.map.SpringBootProject.services.AccountServices;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {
	
	private final IncidentRepository incidentRepository;
	private final CommentRepository commentRepository;
	private final AccountServices accountService;
	private final UserRepository userRepository;
	
	public IncidentController(IncidentRepository incidentRepository, CommentRepository commentRepository, UserRepository userRepository,AccountServices accountService){
		this.incidentRepository = incidentRepository;
		this.commentRepository = commentRepository;
		this.accountService = accountService;
		this.userRepository = userRepository;
		
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
	
	@PostMapping("/new-incidents")
	public Incident createIncident(@RequestBody Incident incident) {
		try {
			System.out.println(incident.getUser());
			return incidentRepository.save(incident);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@GetMapping("/incidents/{id}")
	public List<Comment> commentsList(@PathVariable Long id){
        Incident incident = incidentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid patient ID"));
        List<Comment> commentList = commentRepository.findByIncident(incident);

        return commentList;
    }
	
	@GetMapping("/recherche")
	public List<Incident> chercherIncident(@RequestParam String nickname) {
		return incidentRepository.searchByNickname(nickname);
	}
	
	@PostMapping("/incidents")
	public Comment addCommentToIncident(@RequestBody Comment comment,@RequestParam Long id) {
		Incident incident = incidentRepository.findById(id).orElseThrow();
		incident.getComment().add(comment);
		incidentRepository.save(incident);
		
		return commentRepository.save(comment);
	}
	
	
	
	
	
	
	
	
	
}
