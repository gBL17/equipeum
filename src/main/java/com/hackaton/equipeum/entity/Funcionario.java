package com.hackaton.equipeum.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "funcionarios")
public class Funcionario {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    private String status;

    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}