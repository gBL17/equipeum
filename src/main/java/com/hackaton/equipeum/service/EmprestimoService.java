package com.hackaton.equipeum.service;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.mapper.EmprestimoMapper;
import com.hackaton.equipeum.repository.EmprestimoRepository;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmprestimoService {
    private final EquipamentoRepository equipamentoRepository;
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EquipamentoRepository equipamentoRepository, EmprestimoRepository emprestimoRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo solicitarEmprestimo(EmprestimoDTO emprestimoDTO) {
        Equipamento equipamento = obterDisponivel(emprestimoDTO.getCategoria());
        Emprestimo emprestimo = EmprestimoMapper.map(emprestimoDTO);
        emprestimo.setDataSolicitacao(LocalDateTime.now());

        if (equipamento != null) {
            emprestimo.setPatrimonio(equipamento.getPatrimonio());
            emprestimo.setDataRetirada(LocalDateTime.now());
        }
        return emprestimoRepository.save(emprestimo);
    }

    public ResponseEntity<?> devolverEquipamento(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoRepository.findByPatrimonio(emprestimoDTO.getPatrimonio());
        emprestimo.setDataDevolucao(LocalDateTime.now());
        return ResponseEntity.status(200)
                .body(emprestimoRepository.save(emprestimo));
    }

    public Boolean verificarDisponibilidade(String patrimonio) {
        List<Emprestimo> emprestimos =
                emprestimoRepository.findAllByPatrimonioAndDataDevolucaoIsNull(patrimonio);
        return emprestimos.isEmpty();
    }

    public List<Emprestimo> pegarTodos() {
        return emprestimoRepository.findAll();
    }

    public Equipamento obterDisponivel(CategoriaEquipamento categoria) {
        List<Equipamento> equipamentos = equipamentoRepository.findAllByDescricaoCompletaCategoria(categoria);
        for (Equipamento equipamento : equipamentos) {
            if (verificarDisponibilidade(equipamento.getPatrimonio())) {
                return equipamento;
            }
        }
        return null;
    }
}

