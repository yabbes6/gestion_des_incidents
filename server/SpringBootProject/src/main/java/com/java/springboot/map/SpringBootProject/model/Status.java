package com.java.springboot.map.SpringBootProject.model;

public enum Status {
	ouvert("Ouvert"),
	en_cours("En cours"),
	termine("Terminé");
	
	private final String status;
	
	private Status(String status) {
		this.status = status;
	}

}
