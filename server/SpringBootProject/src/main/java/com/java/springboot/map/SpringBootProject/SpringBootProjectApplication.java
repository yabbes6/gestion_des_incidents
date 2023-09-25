package com.java.springboot.map.SpringBootProject;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.java.springboot.map.SpringBootProject.model.*;
import com.java.springboot.map.SpringBootProject.repository.CommentRepository;
import com.java.springboot.map.SpringBootProject.repository.IncidentRepository;
import com.java.springboot.map.SpringBootProject.services.AccountServices;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

	@Autowired
	private AccountServices accountServices;

	@Autowired
	private IncidentRepository incidentRepository;

	@Autowired
	private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(accountServices.loadUserByUsername("ADMIN")==null) {
		
			accountServices.saveUser("yassine", "abbes", "ADMIN", "12345");
			
			accountServices.addRoleToUser("admin", "ADMIN");
		}

		/*accountServices.save(new AppRole(null, "USER"));
		accountServices.save(new AppRole(null, "ADMIN"));
		// accountServices.saveUser("yassine", "abbes", "yabbes", "12345", "12345");
		/*Stream.of("user1", "user2", "user3", "admin").forEach(un -> {
			accountServices.saveUser("abbes", "yassine", un, "1234", "1234");
		});
		accountServices.addRoleToUser("admin", "ADMIN");*/
		
		
		/*accountServices.saveUser("yassine", "abbes", "yabbes", "12345");
		

		Incident incident = new Incident();

		incident.setDescription("probleme 1");
		incident.setDate_creation(LocalDate.now());
		// incident.setUser(user);
		// incident.setComment(null);
		incident.setIncidentType("fofogo");
		
		incident.setStatus("En cours");

		incidentRepository.save(incident);

		Incident incident1 = new Incident();

		incident1.setDescription("brobleme 1");
		incident1.setDate_creation(LocalDate.now());
		// incident1.setUser(user);
		// incident1.setComment(null);
		incident1.setIncidentType("hardware");
		
		incident1.setStatus("Terminer");

		incidentRepository.save(incident1);

		Incident incident2 = new Incident();

		incident2.setDescription("brobleme 222");
		incident2.setDate_creation(LocalDate.now());
		// incident2.setUser(user);
		// incident1.setComment(null);
		incident2.setIncidentType("hardware");
		
		incident2.setStatus("Terminer");

		incidentRepository.save(incident2);

		Comment comment1 = new Comment(null, "hello cameras", "image", LocalDate.now(), incident);
		Comment comment2 = new Comment(null, "hello servers", "image2", LocalDate.now(), incident1);
		Comment comment3 = new Comment(null, "hello ordinateurs", "image4", LocalDate.now(), incident);
		Comment comment4 = new Comment(null, "hello switchs", "image3", LocalDate.now(), incident1);

		commentRepository.save(comment1);
		commentRepository.save(comment2);
		commentRepository.save(comment3);
		commentRepository.save(comment4);
		
		accountServices.addIncidentToUser("admin",incident);
		accountServices.addIncidentToUser("admin",incident2);
		accountServices.addIncidentToUser("yabbes",incident1);
		
		accountServices.addCommentToUser("yabbes", comment4);
		accountServices.addCommentToUser("yabbes", comment3);
		accountServices.addCommentToUser("yabbes", comment2);
		accountServices.addCommentToUser("admin", comment1);*/
		
		
		
		

	}

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
