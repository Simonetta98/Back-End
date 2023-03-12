package com.GestioneDispositivi.service;

import com.GestioneDispositivi.payload.LoginDto;
import com.GestioneDispositivi.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
