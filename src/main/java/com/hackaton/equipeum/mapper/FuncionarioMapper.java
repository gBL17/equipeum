package com.hackaton.equipeum.mapper;

import com.hackaton.equipeum.dto.CadastroDTO;
import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario map(CadastroDTO cadastroDTO) {
        return new Funcionario(
                cadastroDTO.getCpf(),
                cadastroDTO.getNome(),
                cadastroDTO.getSenha(),
                StatusFuncionario.Ativo
        );
    }
}
