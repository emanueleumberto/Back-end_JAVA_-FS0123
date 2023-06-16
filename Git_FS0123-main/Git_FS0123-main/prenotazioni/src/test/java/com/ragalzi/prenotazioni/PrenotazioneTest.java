package com.ragalzi.prenotazioni;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ragalzi.prenotazioni.enumerates.PostazioneType;
import com.ragalzi.prenotazioni.models.Edificio;
import com.ragalzi.prenotazioni.models.Postazione;
import com.ragalzi.prenotazioni.models.Prenotazione;
import com.ragalzi.prenotazioni.repository.PrenotazioneRepository;
import com.ragalzi.prenotazioni.security.entity.User;
import com.ragalzi.prenotazioni.security.payload.RegisterDto;
import com.ragalzi.prenotazioni.security.repository.UserRepository;
import com.ragalzi.prenotazioni.security.service.AuthService;
import com.ragalzi.prenotazioni.services.EdificioService;
import com.ragalzi.prenotazioni.services.PostazioneService;

@SpringBootTest
class PrenotazioneTest {
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	@Autowired
	EdificioService edificioService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostazioneService postazioneService;
	@Autowired
	AuthService authService;
	
	private Prenotazione prenotazione;
	private RegisterDto registerDto;
	
	@BeforeEach
	void setUp() throws Exception {
		registerDto = new RegisterDto();
		registerDto.setName("Utente Register");
		registerDto.setUsername("utenteDtoRegister");
		registerDto.setEmail("utente@example.com");
		registerDto.setPassword("password");
		authService.register(registerDto);
		User u = userRepository.findByUsername(registerDto.getUsername()).get();
		System.out.println(u);
		Edificio e = new Edificio();
		e.setCitta("Catania");
		e.setIndirizzo("via Etnea 234");
		e.setNome("pincoPallino");
		edificioService.saveEdificio(e);
		System.out.println(e);
		Postazione p = new Postazione();
		p.setEdificio(e);
		p.setDescrizione("belledificio");
		p.setNumMaxOccupanti(20);
		p.setTipo(PostazioneType.SALA_RIUNIONI);
		postazioneService.savePostazione(p);
		System.out.println(p);
		prenotazione = new Prenotazione();
		prenotazione.setDataPrenotazione(LocalDate.now());
		prenotazione.setPostazione(p);
		prenotazione.setUser(u);
		prenotazioneRepository.save(prenotazione);
		
	}

	@Test
	void testSavePrenotazione() {
		assertEquals(prenotazione.getId(), prenotazioneRepository.findById(prenotazione.getId()).get().getId());
	}

	

}
