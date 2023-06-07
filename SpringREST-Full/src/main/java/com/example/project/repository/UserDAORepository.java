package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.User;

@Repository
public interface UserDAORepository extends JpaRepository<User, Long> {
	
	// exists id
	public boolean existsById(Long id);
	// exists email
	public boolean existsByEmail(String email);
	
}
