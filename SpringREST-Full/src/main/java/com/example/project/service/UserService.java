package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.project.model.User;
import com.example.project.repository.UserDAORepository;
import com.example.project.repository.UserPageableRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	// Dependency Injection Repository
	@Autowired private UserDAORepository repo;
	@Autowired private UserPageableRepository repoPage;
	
	// get All Users
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// get All Users Pageable
	public Page<User> getPageableAll(Pageable pageable) {
		return repoPage.findAll(pageable);
	}
	
	// get User By ID
	public User getById(Long id) {
		// Gestione di un errore | id non presente
		if(!repo.existsById(id)) {
			throw new EntityExistsException("User_ID not exists!!");
		}
		return repo.findById(id).get();
	}
	
	// create User
	public User create(User user) {
		// Gestione di un errore | email già presente
		if(repo.existsByEmail(user.getEmail())) {
			throw new EntityNotFoundException("Email exists!!");
		}
		return repo.save(user);
	}
	
	// update User (identico al create, 
	// si differenzia dalla presenza o meno di un paramentro id)
	public User update(User user, Long id) {
		// Gestione di un errore | id non presente
		if(!repo.existsById(id)) {
			throw new EntityExistsException("User_ID not exists!!");
		}
		return repo.save(user);
	}
	
	// delete User
	public String remove(Long id) {
		// Gestione di un errore | id non presente
		if(!repo.existsById(id)) {
			throw new EntityExistsException("User_ID not exists!!");
		}
		repo.deleteById(id);
		return "User deleted!!!";
	}

}
