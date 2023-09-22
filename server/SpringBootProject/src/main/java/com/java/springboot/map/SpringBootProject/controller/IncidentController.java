package com.java.springboot.map.SpringBootProject.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.java.springboot.map.SpringBootProject.exception.RessourceNotFoundException;
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
	
	/*@GetMapping("/incidents/{id}")
	public Incident incident(@PathVariable Long id) {
		Incident incident = incidentRepository.findById(id).orElseThrow();
		return incident;
	}*/
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
	
	@PutMapping("/new-incidents/{id}")
	public Incident updateIncident(@PathVariable Long id, @RequestBody Incident updatedIncident) {
	    // Find the existing incident by ID
	    Optional<Incident> optionalIncident = incidentRepository.findById(id);

	    if (optionalIncident.isPresent()) {
	        // Get the existing incident
	        Incident existingIncident = optionalIncident.get();

	        // Update the fields of the existing incident with values from updatedIncident
	        existingIncident.setDescription(updatedIncident.getDescription());
	        existingIncident.setStatus(updatedIncident.getStatus());
	        existingIncident.setDate_creation(updatedIncident.getDate_creation());
	        existingIncident.setIncidentType(updatedIncident.getIncidentType());
	        // Update other fields as needed

	        // Save the modified incident back to the repository
	        return incidentRepository.save(existingIncident);
	    } else {
	        throw new RessourceNotFoundException("Incident not found with ID: " + id);
	    }
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
	
	/*@PostMapping("/incidents/{id}")
	public void addCommentToIncident(@RequestBody Comment comment,@PathVariable Long id) {
		Incident incident = incidentRepository.findById(id).orElseThrow();
		commentRepository.save(comment);
		incident.getComment().add(comment);
		
		System.out.println(incident.getComment().lastIndexOf(comment));
		//incidentRepository.save(incident);
		
	}*/
	
	@PostMapping("/incidents")
	public ResponseEntity<String> addCommentToIncident(
	    @RequestBody Comment comment,
	    @RequestParam Long id
	) {
	    try {
	        // Find the incident by ID
	        Optional<Incident> optionalIncident = incidentRepository.findById(id);

	        if (optionalIncident.isPresent()) {
	            Incident incident = optionalIncident.get();

	            // Set the incident for the comment
	            comment.setIncident(incident);

	            // Save the comment
	            commentRepository.save(comment);

	            // Add the comment to the incident's list of comments
	            incident.getComment().add(comment);

	            // Save the incident back to the repository
	            incidentRepository.save(incident);

	            return ResponseEntity.ok("Comment added successfully.");
	        } else {
	            return ResponseEntity.notFound().build(); // Incident not found
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("Error adding comment: " + e.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	
}
