package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.models.Edificio;
import com.example.project.models.Postazione;
import com.example.project.services.PostazioneService;

@RestController
@RequestMapping("/api/postazioni")
public class PostazioneController {
	
	@Autowired private PostazioneService postazioneService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(postazioneService.getAllPostazioni());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(postazioneService.getPostazioneByID(id));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> save(@RequestBody Postazione postazione) {
		return ResponseEntity.ok(postazioneService.createPostazione(postazione));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Postazione postazione) {
		return ResponseEntity.ok(postazioneService.updatePostazione(id, postazione));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return ResponseEntity.ok(postazioneService.removePostazione(id));
	}

}
