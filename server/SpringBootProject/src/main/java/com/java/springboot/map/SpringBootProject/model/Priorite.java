package com.java.springboot.map.SpringBootProject.model;

public enum Priorite {
	
	plus_important("Plus important"),
	important("Important"),
	moins_important("Moins important");
	
	private String priorite;
	
	private Priorite(String priorite) {
		this.priorite=priorite;
	}
	
}
