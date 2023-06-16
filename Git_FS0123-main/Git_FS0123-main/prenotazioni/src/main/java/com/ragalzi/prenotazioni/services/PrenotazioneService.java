package com.ragalzi.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragalzi.prenotazioni.models.Prenotazione;
import com.ragalzi.prenotazioni.models.PrenotazioneDTO;
import com.ragalzi.prenotazioni.repository.PrenotazioneRepository;
import com.ragalzi.prenotazioni.security.entity.User;
import com.ragalzi.prenotazioni.security.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneDAO;
	@Autowired
	UserRepository userDAO;

//	passiamo PrenotazioniDTO per definire il formato ricevuto dal client
	public Prenotazione savePrenotazione(PrenotazioneDTO p) {
//		check username
		if (!userDAO.existsByUsername(p.getUsername())) {
//			if not exists
			throw new EntityExistsException("Username non esiste");
		}
//		una volta verificata l esistenza dell username recuperiamo USER
		User u = userDAO.findByUsername(p.getUsername()).get();

//		check for DATA and POSTAZIONE
		if (!prenotazioneDAO.findByDataPrenotazioneAndPostazione(p.getDataPrenotazione(), p.getPostazione())
				.isEmpty()) {
//			if exists
			throw new EntityNotFoundException("La postazione e gia occupata per il giorno:" + p.getDataPrenotazione());
		}

//		check for DATA and USER
		if (!prenotazioneDAO.findByDataPrenotazioneAndUser(p.getDataPrenotazione(), u).isEmpty()) {
//			if exists
			throw new EntityNotFoundException(
					"Hai gia una prenotazione in corso per il giorno:" + p.getDataPrenotazione());
		}

//		effetuati tutti i controlli creiamo la prenotazione da salvare diversa da PrenotazioneDTO
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUser(u);
		prenotazione.setDataPrenotazione(p.getDataPrenotazione());
		prenotazione.setPostazione(p.getPostazione());
//		ricordati di mettere l annotation @JsonIgnore nei campi sensibili per non restituirli al client password..email...
		return prenotazioneDAO.save(prenotazione);
	}

	public Prenotazione updatePrenotazione(Long id, Prenotazione p) {
		if (!prenotazioneDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		return prenotazioneDAO.save(p);
	}

	public String deletePrenotazione(Long id) {
		if (!prenotazioneDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		prenotazioneDAO.deleteById(id);
		return "Edifico cancellato";
	}

	public Prenotazione getById(Long id) {
		if (!prenotazioneDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		return prenotazioneDAO.findById(id).get();
	}

	public List<Prenotazione> getAllPrenotazione() {
		return prenotazioneDAO.findAll();
	}
}
