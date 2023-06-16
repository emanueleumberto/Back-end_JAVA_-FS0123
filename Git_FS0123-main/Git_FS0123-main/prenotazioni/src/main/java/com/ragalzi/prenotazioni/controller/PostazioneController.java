package com.ragalzi.prenotazioni.controller;

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

import com.ragalzi.prenotazioni.models.Edificio;
import com.ragalzi.prenotazioni.models.Postazione;
import com.ragalzi.prenotazioni.services.PostazioneService;

@RestController
@RequestMapping("/api/postazione")
public class PostazioneController {
	
	@Autowired PostazioneService postazioneService;

	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(postazioneService.getAllPostazioni());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		return ResponseEntity.ok(postazioneService.getById(id));
	}
	@PostMapping
	public ResponseEntity<?> creaPrenotazione(@RequestBody Postazione p){
		return ResponseEntity.ok(postazioneService.savePostazione(p));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificaPrenotazione(@PathVariable Long id,@RequestBody Postazione p){
		return ResponseEntity.ok(postazioneService.updatePostazione(id, p));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaPrenotazione(@PathVariable Long id){
		return ResponseEntity.ok(postazioneService.deletePostazione(id));
	}
}
