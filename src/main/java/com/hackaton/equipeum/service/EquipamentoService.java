package com.hackaton.equipeum.service;

import com.hackaton.equipeum.dto.equipamento.request.CadastrarEquipamentoRequest;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {
    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public ResponseEntity<?> cadastrarEquipamento(Equipamento equipamento) {
        return ResponseEntity.status(200).body(equipamentoRepository.save(equipamento));
    }
}
