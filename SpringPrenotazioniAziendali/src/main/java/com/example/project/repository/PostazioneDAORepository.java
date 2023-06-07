package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.Postazione;

@Repository
public interface PostazioneDAORepository extends JpaRepository<Postazione, Long> {

}
