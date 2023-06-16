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

import com.ragalzi.prenotazioni.models.Prenotazione;
import com.ragalzi.prenotazioni.models.PrenotazioneDTO;
import com.ragalzi.prenotazioni.services.PrenotazioneService;

@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(prenotazioneService.getAllPrenotazione());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(prenotazioneService.getById(id));
	}

	@PostMapping
	public ResponseEntity<?> creaPrenotazione(@RequestBody PrenotazioneDTO p) {

		return ResponseEntity.ok(prenotazioneService.savePrenotazione(p));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificaPrenotazione(@PathVariable Long id, @RequestBody Prenotazione p) {
		return ResponseEntity.ok(prenotazioneService.updatePrenotazione(id, p));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaPrenotazione(@PathVariable Long id) {
		return ResponseEntity.ok(prenotazioneService.deletePrenotazione(id));
	}
}
