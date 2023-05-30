package com.example.SpringAppTestJunit.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.SpringAppTestJunit.model.User;

@Configuration
@PropertySource("classpath:application.properties")
public class UserConfiguration {
	
	@Value("${user.admin.name}") private String adminName;
	@Value("${user.admin.lastname}") private String adminLastname;
	@Value("${user.admin.email}") private String adminEmail;
	@Value("${user.admin.password}") private String adminPassword;

	@Bean
	@Scope("singleton")
	public User adminUser() {
		return new User(adminName, adminLastname, adminEmail, adminPassword);
	}
	
	@Bean
	@Scope("prototype")
	public User customUser() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public User newUser(String name, String lastname, String email, String password) {
		return new User(name, lastname, email, password);
	}

}
