package com.ragalzi.prenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragalzi.prenotazioni.models.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
