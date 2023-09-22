package com.java.springboot.map.SpringBootProject.model;

public class UserForm{
	
	private boolean success;
	private String message;
	
	
	public UserForm(boolean success,String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean getUsername() {
		return success;
	}
	public void setUsername(boolean success) {
		this.success = success;
	}
	public String getPassword() {
		return message;
	}
	public void setPassword(String message) {
		this.message = message;
	}
	
}



