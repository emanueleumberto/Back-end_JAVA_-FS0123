package com.epicode.project.service;

import com.epicode.project.payload.LoginDto;
import com.epicode.project.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
