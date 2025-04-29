package com.hackaton.equipeum.dto.funcionario;

import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import jakarta.validation.constraints.NotBlank;

public class CadastroDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    private String senha;
    private StatusFuncionario status;

    public CadastroDTO(String cpf, String nome, String senha, StatusFuncionario status) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.status = status;
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

    public void setSenha(String senha){ this.senha = senha; }

    public String getSenha(){ return senha; }
}
