package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.project.model.User;

@Repository
public interface UserDaoRepository extends JpaRepository<User, Long> {
	
	public List<User> findByCity(String city);
	public List<User> findByNameAndLastname(String name, String lastname);
	public List<User> findByAgeBetween(Integer min, Integer max);
	
	@Query("SELECT u FROM User u WHERE u.city IN ('Roma', 'Milano', 'Napoli')")
	public List<User> findAllUserRM_MI_NA();
	
	@Query("SELECT u FROM User u WHERE u.age > :age")
	public List<User> findUserGTAge(Integer age);


}
