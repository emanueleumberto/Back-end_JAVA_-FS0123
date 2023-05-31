package com.example.project.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.project.model.User;

@Service
public class UserService {

	@Autowired @Qualifier("FakeUserBean") ObjectProvider<User> userFakeProvider;
	@Autowired @Qualifier("AdminUserBean") ObjectProvider<User> adminUserProvider;
	@Autowired @Qualifier("CustomUserBean") ObjectProvider<User> customUserProvider;
	
	public User createFakeUser() {
		return userFakeProvider.getObject();
	}
	
	public User createAdminUser() {
		return adminUserProvider.getObject();
	}
	
	public User createCustomUser() {
		return customUserProvider.getObject();
	}

}
