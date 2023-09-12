package com.java.springboot.map.SpringBootProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.map.SpringBootProject.model.Comment;
import com.java.springboot.map.SpringBootProject.model.Incident;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findByIncident(Incident incident);
}
