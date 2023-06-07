package com.example.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.models.Edificio;
import com.example.project.repository.EdificioDAORepository;

import jakarta.persistence.EntityExistsException;

@Service
public class EdificioService {
	
	@Autowired private EdificioDAORepository repo;
	
	public List<Edificio> getAllEdifici() {
		return repo.findAll();
	}

	public Edificio getEdificioByID(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Edificio ID non Esiste!!!");
		}
		return repo.findById(id).get();
	}

	public Edificio createEdificio(Edificio edificio) {
		if(repo.findByNomeAndIndirizzoAndCitta(edificio.getNome(), edificio.getIndirizzo(), edificio.getCitta()) != null) {
			throw new EntityExistsException("Edificio già Presente!!!");
		}
		return repo.save(edificio);
	}

	public Edificio updateEdificio(Long id, Edificio edificio) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Edificio ID non Esiste!!!");
		}
		return repo.save(edificio);
	}

	public String removeEdificio(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Edificio ID non Esiste!!!");
		}
		repo.deleteById(id);
		return "Edificio eliminato!!!";
	}

}
