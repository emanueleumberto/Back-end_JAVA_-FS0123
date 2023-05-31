package com.example.project.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.project.model.User;
import com.example.project.service.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	
	List<User> listaUser = new ArrayList<User>();
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("UserRunner... ");
		
		listaUser.add(userService.createAdminUser());
		listaUser.add(userService.createFakeUser());
		listaUser.add(userService.createFakeUser());
		//User u = userService.createCustomUser().builder().name("Giuseppe").lastname("Verdi").city("Milano").age(29).email("g.verdi@example.com").build();
		User u = userService.createCustomUser();
		u.setName("Giuseppe");
		u.setLastname("Verdi");
		u.setCity("Milano");
		u.setAge(29);
		u.setEmail("g.verdi@example.com");
		listaUser.add(u);
		
		listaUser.forEach(utente -> System.out.println(utente));
		

	}

}
