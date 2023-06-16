package com.ragalzi.prenotazioni.models;

import java.time.LocalDate;

import com.ragalzi.prenotazioni.security.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_prenotazione")
	private LocalDate dataPrenotazione;

	@ManyToOne
	private User user;
	@ManyToOne
	private Postazione postazione;

}
