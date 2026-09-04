package com.financeai.service;

import com.financeai.dto.RegisterRequest;
import com.financeai.dto.UsuarioResponse;
import com.financeai.dto.LoginRequest;
import com.financeai.dto.LoginResponse;
import com.financeai.model.Usuario;
import com.financeai.repository.UsuarioRepository;
import com.financeai.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UsuarioResponse registrar(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha())); // criptografa aqui
        usuario.setTipo(request.getTipo());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioResponse(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getTipo());
    }

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Email ou senha inválidos");
        }

        String token = jwtUtil.gerarToken(usuario.getEmail());
        return new LoginResponse(token);
    }
}