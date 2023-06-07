package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.User;

public interface UserDAORepository extends JpaRepository<User, Long> {
	
	// find id
	
	// exists email

}
