package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.project.model.User;
import com.example.project.repository.UserDaoRepository;

@Service
public class UserSevice {
	
	@Autowired UserDaoRepository db;
	
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
	
	// JDBC method
	
	public void insertUser(User u) {
		db.save(u);
		System.out.println("User " + u.getName() + " " + u.getLastname() + " inserito nel DB!!!");
	}
	
	public void updateUser(User u) {
		db.save(u);
		System.out.println("User " + u.getName() + " " + u.getLastname() + " modificato nel DB!!!");
	}
	
	public void deleteUser(User u) {
		db.delete(u);
		//db.deleteById(u.getId());
		System.out.println("User " + u.getName() + " " + u.getLastname() + " eliminato nel DB!!!");
	}
	
	public User getByID(long id) {
		return db.findById(id).get();
	}
	
	public List<User> getAll() {
		return db.findAll();
	}
	
	// Metodi Custom
	
	public List<User> getByCity(String city) {
		return db.findByCity(city);
	}
	
	public List<User> getByAgeBetween(Integer min, Integer max) {
		return db.findByAgeBetween(min, max);
	}
	
	public List<User> getAllUserRM_MI_NA() {
		return db.findAllUserRM_MI_NA();
	}
	
	public List<User> getUserGTAge(int age) {
		return db.findUserGTAge(age);
	}

}
