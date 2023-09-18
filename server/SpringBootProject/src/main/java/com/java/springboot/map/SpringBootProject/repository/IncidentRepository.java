package com.java.springboot.map.SpringBootProject.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.springboot.map.SpringBootProject.model.Incident;


@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {

	//@Query("SELECT In FROM Incident In WHERE In.description LIKE %:nickname% OR In.incidentType LIKE %:nickname%")
	@Query(value = "SELECT * FROM incident WHERE description LIKE %:nickname% OR incident_type LIKE %:nickname%", nativeQuery = true)
	List<Incident> searchByNickname(@Param("nickname") String nickname);
	
	

}
