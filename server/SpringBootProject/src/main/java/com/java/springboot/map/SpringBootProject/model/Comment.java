package com.java.springboot.map.SpringBootProject.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comment;
	private LocalDate date_comment;

	private String urlImage;

	@ManyToOne
	@JoinColumn(name = "incident_id")
	@JsonBackReference
	private Incident incident;


	private String user;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LocalDate getDate_comment() {
		return date_comment;
	}

	public void setDate_comment(LocalDate date_comment) {
		this.date_comment = date_comment;
	}

	public Comment(Long id, String comment, String urlImage,LocalDate date_comment, Incident incident,String user) {
		super();
		this.id = id;
		this.comment = comment;
		this.date_comment = date_comment;
		this.urlImage = urlImage;
		this.incident = incident;
		this.user = user;
	}

	public Comment() {
	}
}
