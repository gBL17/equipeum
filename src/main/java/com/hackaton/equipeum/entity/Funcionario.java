package com.hackaton.equipeum.entity;

import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "funcionarios")
public class Funcionario {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    @Indexed(unique = true)
    private String cpf;
    private StatusFuncionario status;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String cpf, String nome, String senha, StatusFuncionario status) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
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

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}