package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.Prenotazione;

@Repository
public interface PrenotazioneDAORepository extends JpaRepository<Prenotazione, Long> {

}
