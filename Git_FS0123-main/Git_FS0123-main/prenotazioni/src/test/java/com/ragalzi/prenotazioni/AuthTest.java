package com.ragalzi.prenotazioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ragalzi.prenotazioni.security.entity.User;
import com.ragalzi.prenotazioni.security.payload.RegisterDto;
import com.ragalzi.prenotazioni.security.repository.UserRepository;
import com.ragalzi.prenotazioni.security.service.AuthService;

@SpringBootTest
class AuthTest {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	UserRepository userRepository;
	
	private RegisterDto  registerDto;
	
	@Autowired 
	UserRepository userRepo;
	User u;
	
	
	@BeforeEach
	void setUp() throws Exception {

		registerDto = new RegisterDto();
		registerDto.setName("Utente Register");
		registerDto.setUsername("utenteDtoRegister");
		registerDto.setEmail("utente@example.com");
		registerDto.setPassword("password");
		authService.register(registerDto);
		u = userRepo.findByUsername(registerDto.getUsername()).get();
	}

	@Test
	void test() {
		assertEquals(u.getId(), userRepo.findByUsername(u.getUsername()).get().getId());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
	}

}
