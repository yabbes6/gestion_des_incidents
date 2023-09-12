package com.java.springboot.map.SpringBootProject.security;

public interface SecurityParams {
	public static final String JWT_HEADER_NAME = "Authorization";
	public static final String SECRET="secret";
	public static final long ExPIRATION =10*24*3600*1000;
	public static final String HEADER_PREFIX="Bearer ";
	
}
