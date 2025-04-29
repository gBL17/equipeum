package com.hackaton.equipeum.service;

import com.hackaton.equipeum.dto.EquipamentoDTO;
import com.hackaton.equipeum.entity.Descricao;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.mapper.EquipamentoMapper;
import com.hackaton.equipeum.repository.EmprestimoRepository;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper equipamentoMapper;
    private final EmprestimoRepository emprestimoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, EquipamentoMapper equipamentoMapper, EmprestimoRepository emprestimoRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.equipamentoMapper = equipamentoMapper;
        this.emprestimoRepository = emprestimoRepository;
    }

    public Equipamento cadastrarEquipamento(String modelo, String marca, String cor, CategoriaEquipamento categoria) {
        Descricao descricao = new Descricao(modelo, marca, cor, categoria);
        EquipamentoDTO equipamentoDTO = new EquipamentoDTO(descricao);
        Equipamento equipamentoCadastrado = equipamentoRepository.save(equipamentoMapper.map(equipamentoDTO));
        List<Emprestimo> emprestimosAguardandoCompraEquipamento = emprestimoRepository.findAllByCategoriaAndPatrimonioIsNull(categoria);
        if (!emprestimosAguardandoCompraEquipamento.isEmpty()){
            Emprestimo emprestimo = emprestimosAguardandoCompraEquipamento.getFirst();
            emprestimo.setPatrimonio(equipamentoCadastrado.getPatrimonio());
            emprestimo.setDataRetirada(LocalDateTime.now());
            emprestimoRepository.save(emprestimo);
        }
        return equipamentoCadastrado;
    }

    public ResponseEntity<List<Equipamento>> listarEquipamentos() {
        return ResponseEntity.status(200).body(equipamentoRepository.findAll());
    }


}
