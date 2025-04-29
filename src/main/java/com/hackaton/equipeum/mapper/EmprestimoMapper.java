package com.hackaton.equipeum.mapper;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmprestimoMapper {
    public static Emprestimo map(EmprestimoDTO emprestimoDTO){
        return new Emprestimo(
                emprestimoDTO.getCategoria(),
                emprestimoDTO.getCpfFuncionario(),
                LocalDateTime.now()
        );
    }

    public static EmprestimoDTO map(Emprestimo emprestimo){
        return new EmprestimoDTO(
                emprestimo.getPatrimonio(),
                emprestimo.getCategoria(),
                emprestimo.getCpfFuncionario(),
                emprestimo.getStatusEmprestimo(),
                emprestimo.getDataSolicitacao(),
                emprestimo.getDataRetirada(),
                emprestimo.getDataDevolucao()
        );
    }

    public static List<EmprestimoDTO> map(List<Emprestimo> emprestimos){
        List<EmprestimoDTO> emprestimoDTOS = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos){
            emprestimoDTOS.add(map(emprestimo));
        }
        return emprestimoDTOS;
    }
}
