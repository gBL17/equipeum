package com.hackaton.equipeum.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FuncionarioRequest {
    private String nome;
    private String cpf;
    private boolean status;
}


