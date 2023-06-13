package com.epicode.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/microcontroller")
public class MicroCrontroller_2 {
	
	@GetMapping("/test")
	public String test() {
		// Oggetto capace di effettuare chiamate ad un microservizio lato server
		RestTemplate rt = new RestTemplate();
		// Url del microservizio lato server
		String url = "http://localhost:8082/api/be/data1";
		// Effettuo la chiamata e prendo il dato
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		// Restituisco tramite Response al client
		return "Public Content: " + response.getBody();
	}

	@GetMapping("/usersApi")
	public Object users() {
		// Oggetto capace di effettuare chiamate ad un microservizio lato server
		RestTemplate rt = new RestTemplate();
		// Url del microservizio lato server
		String url = "http://localhost:8082/api/be/data2";
		// Effettuo la chiamata e prendo il dato di tipo Object (List<Users)
		Object response = rt.getForObject(url, Object.class);
		return response;
	}
}
