package com.hackaton.equipeum.service;

import com.hackaton.equipeum.dto.EquipamentoDTO;
import com.hackaton.equipeum.entity.Descricao;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.mapper.EquipamentoMapper;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public ResponseEntity<?> cadastrarEquipamento(String modelo, String marca, String cor, CategoriaEquipamento categoria) {
        Descricao descricao = new Descricao(modelo, marca, cor, categoria);
        EquipamentoDTO equipamentoDTO = new EquipamentoDTO(descricao);
        return ResponseEntity.status(200)
                .body(equipamentoRepository
                        .save(EquipamentoMapper.map(equipamentoDTO)));
    }

    public ResponseEntity<List<Equipamento>> listarEquipamentos() {
        return ResponseEntity.status(200).body(equipamentoRepository.findAll());
    }
}
