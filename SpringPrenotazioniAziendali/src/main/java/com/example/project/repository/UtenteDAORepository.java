package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.Utente;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long> {

}
