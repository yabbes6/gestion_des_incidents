package com.java.springboot.map.SpringBootProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.springboot.map.SpringBootProject.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
	
	public AppUser findByUsername(String username);
	//boolean existsByUsername(String username);
}
