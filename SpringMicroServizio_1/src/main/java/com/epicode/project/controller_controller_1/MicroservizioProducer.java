package com.epicode.project.controller_controller_1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.project.model.Users;

@RestController
@RequestMapping("/api/be")
public class MicroservizioProducer {
	
	@GetMapping("/data1")
	public String data1() {
		return "BE String Content";
	}
	
	@GetMapping("/data2")
	public ResponseEntity<List<Users>> data2() {
		List<Users> lista = new ArrayList<Users>(
				Arrays.asList(
						new Users("Mario", "Rossi", "Roma"),
						new Users("Giuseppe", "Verdi", "Milano"),
						new Users("Francesca", "Neri", "Napoli")
						));
//		lista.add(new Users("Mario", "Rossi", "Roma"));
//		lista.add(new Users("Giuseppe", "Verdi", "Milano"));
//		lista.add(new Users("Francesca", "Neri", "Napoli"));
		
		//Il mio Endpoint risponde ad un eventuale microservizio una lista di Users 
		//return new ResponseEntity<List<Users>>(lista, HttpStatus.OK);
		return ResponseEntity.ok(lista);
	}
	
}
