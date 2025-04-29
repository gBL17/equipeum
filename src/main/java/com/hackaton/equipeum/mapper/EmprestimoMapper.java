package com.hackaton.equipeum.mapper;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmprestimoMapper {
    public static Emprestimo map(EmprestimoDTO emprestimoDTO){
        return new Emprestimo(
                emprestimoDTO.getCategoria(),
                emprestimoDTO.getCpf(),
                LocalDateTime.now()
        );
    }
}
