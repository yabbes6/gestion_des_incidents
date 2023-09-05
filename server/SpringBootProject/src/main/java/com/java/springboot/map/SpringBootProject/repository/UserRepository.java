package com.java.springboot.map.SpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.map.SpringBootProject.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

}