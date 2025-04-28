package com.hackaton.equipeum.service;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.mapper.EmprestimoMapper;
import com.hackaton.equipeum.repository.EmprestimoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public ResponseEntity<?> solicitarEmprestimo(EmprestimoDTO emprestimoDTO) {
        return ResponseEntity.status(200)
                .body(emprestimoRepository
                        .save(EmprestimoMapper.map(emprestimoDTO)));
    }

    public ResponseEntity<?> devolverEquipamento(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoRepository.findByPatrimonio(emprestimoDTO.getPatrimonio());
        emprestimo.setDataDevolucao(LocalDateTime.now());
        return ResponseEntity.status(200)
                .body(emprestimoRepository.save(emprestimo));
    }

}

