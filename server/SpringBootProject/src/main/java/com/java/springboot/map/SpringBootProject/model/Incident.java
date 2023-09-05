package com.java.springboot.map.SpringBootProject.model;

import java.io.Serializable;
import java.time.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String description;
	private LocalDate date_creation;
	
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
	private List<Comment> comment;
    
    @ManyToOne // Many comments can be associated with one incident
    @JoinColumn(name = "user_id")
    @JsonBackReference
	private AppUser user;

	private String incidentType;
	private String priorite;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	public String getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Incident(Long id, String description, LocalDate date_creation, 
			String incidentType,List<Comment> comment, String priorite, String status,AppUser user) {
		super();
		this.id = id;
		this.description = description;
		this.date_creation = date_creation;
		this.comment = comment;
		this.incidentType = incidentType;
		this.priorite = priorite;
		this.status = status;
		this.user=user;
	}
	public Incident() {
		// TODO Auto-generated constructor stub
	}
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	

}
