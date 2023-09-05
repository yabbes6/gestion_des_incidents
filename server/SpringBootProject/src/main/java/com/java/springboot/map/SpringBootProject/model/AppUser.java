package com.java.springboot.map.SpringBootProject.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

//import javax.persistence.*;

import jakarta.persistence.*;
import lombok.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "utilisateur")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	
	private String username;
	private String password;
	private Collection<String> roles;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Comment> comments;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Incident> incidents;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Incident> getIncident() {
		return incidents;
	}

	public void setIncident(List<Incident> incident) {
		this.incidents = incident;
	}

	public Collection<String> getRoles() {
		return roles;
	}

	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}

	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}

	public AppUser(Long id, String nom, String prenom, String username, String password, List<Incident> incident,
			List<Comment> comments,Collection<String> roles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.comments = comments;
		this.incidents = incident;
		this.roles=roles;
	}

	public AppUser() {
	}
}
