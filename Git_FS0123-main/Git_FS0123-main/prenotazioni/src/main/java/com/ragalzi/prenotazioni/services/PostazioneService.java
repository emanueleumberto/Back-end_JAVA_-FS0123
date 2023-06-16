package com.ragalzi.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragalzi.prenotazioni.models.Edificio;
import com.ragalzi.prenotazioni.models.Postazione;
import com.ragalzi.prenotazioni.repository.PostazioneRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class PostazioneService {

	@Autowired PostazioneRepository postazioneDAO;
	
	
	public Postazione savePostazione(Postazione p) {
		return postazioneDAO.save(p);
	}
	
	
	public Postazione updatePostazione(Long id,Postazione p) {
		if(!postazioneDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		return postazioneDAO.save(p);
	}
	
	
	public String deletePostazione(Long id) {
		if(!postazioneDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		postazioneDAO.deleteById(id);
		 return "Edifico cancellato";
	}
	
	
	public Postazione getById(Long id) {
		if(!postazioneDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		return postazioneDAO.findById(id).get();
	}
	
	
	public List<Postazione> getAllPostazioni(){
		return postazioneDAO.findAll();
		}
}
