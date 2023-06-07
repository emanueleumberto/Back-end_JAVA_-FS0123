package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.models.Edificio;
import com.example.project.services.EdificioService;

@RestController
@RequestMapping("/api/edifici")
public class EdificioController {
	
	@Autowired private EdificioService edificioService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(edificioService.getAllEdifici());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(edificioService.getEdificioByID(id));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Edificio edificio) {
		return ResponseEntity.ok(edificioService.createEdificio(edificio));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Edificio edificio) {
		return ResponseEntity.ok(edificioService.updateEdificio(id, edificio));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return ResponseEntity.ok(edificioService.removeEdificio(id));
	}

}
