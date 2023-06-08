package com.example.project.security.service;

import com.example.project.security.payload.LoginDto;
import com.example.project.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
