package com.financeai.dto;

public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String tipo;

    public UsuarioResponse(Long id, String nome, String email, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTipo() { return tipo; }
}