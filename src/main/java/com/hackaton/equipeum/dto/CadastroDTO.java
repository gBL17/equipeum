package com.hackaton.equipeum.dto;

import org.hibernate.validator.constraints.br.CPF;

public class CadastroDTO {

    private String nome;

    @CPF
    private String cpf;
    private String senha;

    public CadastroDTO() {
    }

    public CadastroDTO(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
