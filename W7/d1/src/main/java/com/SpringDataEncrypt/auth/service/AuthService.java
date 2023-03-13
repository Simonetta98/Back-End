package com.SpringDataEncrypt.auth.service;

import com.SpringDataEncrypt.auth.payload.LoginDto;
import com.SpringDataEncrypt.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
