package com.java.springboot.map.SpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.map.SpringBootProject.model.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
	public AppRole findByRolename(String rolename);
}
