package com.hackaton.equipeum.dto.funcionario;

public class FuncionarioResponse {
    private String id;
    private String nome;
    private String cpf;
    private String status;

    public FuncionarioResponse() {
    }

    public FuncionarioResponse(String id, String nome, String cpf, String status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


