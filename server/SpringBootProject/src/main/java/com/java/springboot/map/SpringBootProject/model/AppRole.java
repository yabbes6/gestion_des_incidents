package com.java.springboot.map.SpringBootProject.model;

import javax.persistence.*;

@Entity
public class AppRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String rolename;
	
	
	public AppRole(Long id , String rolename) {
		this.id=id;
		this.rolename=rolename;
	}
	
	public AppRole(){}
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
