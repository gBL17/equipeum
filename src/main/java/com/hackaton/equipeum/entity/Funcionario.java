package com.hackaton.equipeum.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "funcionarios")
public class Funcionario {

    @Id
    private String cpf;
    private String nome;
    private boolean status;
}
