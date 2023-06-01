package com.example.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.project.model.User;
import com.example.project.service.UserSevice;

@Component
public class UserRunner implements ApplicationRunner {
	
	//private UserSevice userService = new UserSevice();
	@Autowired private UserSevice userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("UserRunner...");
		
		User u1 = userService.createAdminUser();
		User u2 = userService.createFakeUser();
		User u3 = userService.createFakeUser();
		
		User u4 = userService.createCustomUser();
		u4.setName("Giuseppe");
		u4.setLastname("Verdi");
		u4.setCity("Milano");
		u4.setAge(29);
		u4.setEmail("g.verdi@example.com");
		
//		userService.insertUser(u1);
//		userService.insertUser(u2);
//		userService.insertUser(u3);
//		userService.insertUser(u4);
		
//		User editUser = userService.getByID(4);
//		editUser.setAge(99);
//		
//		userService.updateUser(editUser);
		
//		User editUser = userService.getByID(6);
//		userService.deleteUser(editUser);
		
		userService.getAll().forEach(u -> System.out.println(u));
		
		
	}

}
