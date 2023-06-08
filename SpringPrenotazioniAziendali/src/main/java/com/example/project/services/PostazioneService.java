package com.example.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.models.Edificio;
import com.example.project.models.Postazione;
import com.example.project.repository.PostazioneDAORepository;

import jakarta.persistence.EntityExistsException;

@Service
public class PostazioneService {
	
	@Autowired private PostazioneDAORepository repo;
	
	public List<Postazione> getAllPostazioni() {
		return repo.findAll();
	}

	public Postazione getPostazioneByID(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Postazione ID non Esiste!!!");
		}
		return repo.findById(id).get();
	}

	public Postazione createPostazione(Postazione postazione) {
		if(repo.findByDescrizioneAndEdificio(postazione.getDescrizione(), postazione.getEdificio()) != null) {
			throw new EntityExistsException("Postazione già Presente!!!");
		}
		return repo.save(postazione);
	}

	public Postazione updatePostazione(Long id, Postazione postazione) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Postazione ID non Esiste!!!");
		}
		return repo.save(postazione);
	}

	public String removePostazione(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Postazione ID non Esiste!!!");
		}
		repo.deleteById(id);
		return "POstazione eliminata!!!";
	}

}
