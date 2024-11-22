package org.example.projcrudpoo.model;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }
}
