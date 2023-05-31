package com.example.project.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.project.model.User;
import com.github.javafaker.Faker;

@Configuration
public class UserConfiguration {
	
	@Value("${user.admin.name}") private String adminName;
	@Value("${user.admin.lastname}") private String adminLastname;
	@Value("${user.admin.city}") private String adminCity;
	@Value("${user.admin.age}") private Integer adminAge;
	@Value("${user.admin.email}") private String adminEmail;
	
	@Bean("AdminUserBean")
	@Scope("singleton")
	public User adminUser() {
		return new User(adminName, adminLastname, adminCity, adminAge, adminEmail);
	}
	
	@Bean("CustomUserBean")
	@Scope("prototype")
	public User customUser() {
		return new User();
	}
	
	@Bean("FakeUserBean")
	@Scope("prototype")
	public User fakeUser() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		User userFake = new User();
		userFake.setName(fake.name().firstName());
		userFake.setLastname(fake.name().lastName());
		userFake.setCity(fake.address().cityName());
		userFake.setAge(fake.number().numberBetween(16, 60));
		userFake.setEmail(userFake.getName() + "." + userFake.getLastname() + "@example.com");
		
//		User userFake = User.builder()
//								.name(fake.name().firstName())
//								.lastname(fake.name().lastName())
//								.city(fake.address().cityName())
//								.age(fake.number().numberBetween(16, 60))
//								.build();
//		userFake.setEmail(userFake.getName() + "." + userFake.getLastname() + "@example.com");
//		
		return userFake;
	}
	
	
}
