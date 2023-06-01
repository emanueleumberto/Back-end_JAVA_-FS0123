package com.example.project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project.model.User;

@Repository
public interface UserDaoRepository {

	public void insert(User user);
	public void update(User user);
	public void delete(Long id);
	public User getById(Long id);
	public List<User> getAll();
	
}
