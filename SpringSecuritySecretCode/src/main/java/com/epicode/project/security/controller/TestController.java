package com.epicode.project.security.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.project.security.entity.AuthUser;
import com.epicode.project.security.service.AuthServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired AuthServiceImpl authService;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/all") 
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/auth")
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<AuthUser>> autenticatedAccess() {
		System.out.println("/auth");
		List<AuthUser> lista = authService.getAll();
		//List<AuthUser> lista = authService.getByCreditCard("1234 5678 9999");
		System.out.println(lista);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
