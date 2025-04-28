package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.EquipamentoDTO;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.service.EquipamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipamento")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestParam("descricaoEquip") String descricao) {
        return equipamentoService.cadastrarEquipamento(descricao);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Equipamento>> buscarTodos() {
        return equipamentoService.listarEquipamentos();
    }

    @GetMapping("/cadastro")
    public String getHtmlCadastro() {
        return "cadastrarEquipamento";
    }
}
