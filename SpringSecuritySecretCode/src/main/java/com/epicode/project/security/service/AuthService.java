package com.epicode.project.security.service;

import com.epicode.project.security.payload.LoginDto;
import com.epicode.project.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
