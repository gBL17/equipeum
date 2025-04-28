package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.equipamento.request.CadastrarEquipamentoRequest;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.service.EquipamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/equipamento")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
    }
}
