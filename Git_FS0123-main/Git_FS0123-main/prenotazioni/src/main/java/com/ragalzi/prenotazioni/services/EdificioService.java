package com.ragalzi.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragalzi.prenotazioni.models.Edificio;
import com.ragalzi.prenotazioni.repository.EdificioRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class EdificioService {

	
	@Autowired EdificioRepository edificioDAO;
	
	public Edificio saveEdificio(Edificio e) {
		return edificioDAO.save(e);
	}
	
	
	public Edificio updateEdificio(Long id,Edificio e) {
		if(!edificioDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		return edificioDAO.save(e);
	}
	
	
	public String deleteEdificio(Long id) {
		if(!edificioDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		 edificioDAO.deleteById(id);
		 return "Edifico cancellato";
	}
	
	
	public Edificio getById(Long id) {
		if(!edificioDAO.existsById(id)) {
			throw new EntityExistsException("Edificio non presente");
		}
		return edificioDAO.findById(id).get();
	}
	
	
	public List<Edificio> getAllEdifici(){
		return edificioDAO.findAll();
		}
}
