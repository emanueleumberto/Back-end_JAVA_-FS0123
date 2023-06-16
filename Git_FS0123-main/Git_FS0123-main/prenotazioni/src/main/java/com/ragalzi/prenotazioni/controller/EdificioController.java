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
import com.ragalzi.prenotazioni.models.Prenotazione;
import com.ragalzi.prenotazioni.repository.EdificioRepository;
import com.ragalzi.prenotazioni.services.EdificioService;

@RestController
@RequestMapping("/api/edifici")
public class EdificioController {

	@Autowired EdificioService edificioService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(edificioService.getAllEdifici());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		return ResponseEntity.ok(edificioService.getById(id));
	}
	@PostMapping
	public ResponseEntity<?> creaPrenotazione(@RequestBody Edificio e){
		return ResponseEntity.ok(edificioService.saveEdificio(e));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificaPrenotazione(@PathVariable Long id,@RequestBody Edificio e){
		return ResponseEntity.ok(edificioService.updateEdificio(id, e));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaPrenotazione(@PathVariable Long id){
		return ResponseEntity.ok(edificioService.deleteEdificio(id));
	}
}
