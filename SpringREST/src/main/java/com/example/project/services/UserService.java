package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.models.User;
import com.example.project.repository.UserRepository;

@Service
public class UserService {
	
	// Inject UserRepository
	@Autowired UserRepository userRepo;
	
	public String registerUser(User user) {
		userRepo.save(user);
		return "User: " + user.getName() + " " + user.getLastname() + " salvato nel DB!!!";
	}
	
	public String loginUser(User user) {
		User u = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return "User: " + u.getName() + " " + u.getLastname() + " Logged!!!";
	}

}
