package com.ragalzi.prenotazioni.security.service;

import com.ragalzi.prenotazioni.security.payload.LoginDto;
import com.ragalzi.prenotazioni.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
