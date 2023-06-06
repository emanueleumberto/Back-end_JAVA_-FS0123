package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.models.User;
import com.example.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository userRepo;
	
	public String registerUser(User user) {
		userRepo.save(user);
		return "User: " + user.getName() + " " + user.getLastname() + " salvato nel DB!!!";
	}

}
