package com.financeai.controller;

import com.financeai.dto.RegisterRequest;
import com.financeai.dto.UsuarioResponse;
import com.financeai.dto.LoginRequest;
import com.financeai.dto.LoginResponse;
import com.financeai.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public UsuarioResponse register(@RequestBody RegisterRequest request) {
        return authService.registrar(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}