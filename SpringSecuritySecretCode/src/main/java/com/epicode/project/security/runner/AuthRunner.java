package com.epicode.project.security.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.project.security.entity.AuthUser;
import com.epicode.project.security.entity.ERole;
import com.epicode.project.security.entity.Role;
import com.epicode.project.security.payload.RegisterDto;
import com.epicode.project.security.repository.RoleRepository;
import com.epicode.project.security.repository.UserRepository;
import com.epicode.project.security.service.AuthService;


@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Metodo da lanciare solo la prima volta
		// Serve per salvare i ruoli nel DB
		setRoleDefault();
		saveUser();
		//getAllRole();
		
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
//		adminRole = new HashSet<Role>();
//		adminRole.add(admin);
//		adminRole.add(moderator);
//		adminRole.add(user);
//		
//		moderatorRole = new HashSet<Role>();
//		moderatorRole.add(moderator);
//		moderatorRole.add(user);
//		
//		userRole = new HashSet<Role>();
//		userRole.add(user);
	}
	
	private void saveUser() {
		RegisterDto u = new RegisterDto(); 
		u.setName("Mario");
		u.setLastname("Rossi");
		u.setUsername("marros");
		u.setEmail("m.rossi@example.com");
		u.setCreditCard("1234 5678 9999");
		u.setSecretCode("1983");
		u.setPassword("qwerty");
		u.setAlfaCode("A1b2-!Z");
		authService.register(u);
	}
	
	private void getAllRole() {
		List<Role> listaRuoli = roleRepository.findAll();
		listaRuoli.forEach(r -> System.out.println(r));
	}
	

}
