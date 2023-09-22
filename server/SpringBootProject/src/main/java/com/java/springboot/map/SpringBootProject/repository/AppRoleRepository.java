package com.java.springboot.map.SpringBootProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.map.SpringBootProject.model.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
	
	List<AppRole> findAllByRolename(String rolename);
}
