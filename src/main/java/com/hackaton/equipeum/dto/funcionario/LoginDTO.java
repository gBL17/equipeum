package com.hackaton.equipeum.dto.funcionario;

public class LoginDTO {
    private String cpf;
    public String senha;

    public LoginDTO(){}
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha(){ return senha; }

    public void setSenha(String senha) { this.senha = senha; }
}
