package com.java.springboot.map.SpringBootProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.springboot.map.SpringBootProject.model.*;
import com.java.springboot.map.SpringBootProject.repository.CommentRepository;
import com.java.springboot.map.SpringBootProject.repository.IncidentRepository;
import com.java.springboot.map.SpringBootProject.repository.UserRepository;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

    private final IncidentRepository incidentRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public SpringBootProjectApplication(IncidentRepository incidentRepository,UserRepository userRepository,CommentRepository commentRepository) {
        this.incidentRepository = incidentRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Incident incident = new Incident();
        ;
       
        AppUser user = new AppUser(null,"yassine","abbes","yabbes","abbese1997",null,null,null);
        userRepository.save(user);
        
        incident.setDescription("probleme 1");
        incident.setDate_creation(LocalDate.now());
        incident.setUser(user);
        //incident.setComment(null);
        incident.setIncidentType("fofogo");
        incident.setPriorite("First"); 
        incident.setStatus("En cours"); 

        incidentRepository.save(incident);
        
        Incident incident1 = new Incident();
        
        incident1.setDescription("probleme 1");
        incident1.setDate_creation(LocalDate.now());
        incident1.setUser(user);
        //incident1.setComment(null);
        incident1.setIncidentType("hardware");
        incident1.setPriorite("First"); 
        incident1.setStatus("Terminer"); 

        incidentRepository.save(incident1);
        
        Comment comment1 = new Comment(null,"hello cameras","image",LocalDate.now(),incident,user);
        Comment comment2 = new Comment(null,"hello servers","image2",LocalDate.now(),incident1,user);
        Comment comment3 = new Comment(null,"hello ordinateurs","image4",LocalDate.now(),incident,user);
        Comment comment4 = new Comment(null,"hello switchs","image3",LocalDate.now(),incident1,user);
        
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);

    }
}
