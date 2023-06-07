package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.Edificio;

@Repository
public interface EdificioDAORepository extends JpaRepository<Edificio, Long> {

	public Edificio findByNomeAndIndirizzoAndCitta(String nome, String indirizzo, String citta);
	
}
