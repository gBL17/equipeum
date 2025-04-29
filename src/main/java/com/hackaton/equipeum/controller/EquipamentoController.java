package com.hackaton.equipeum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.service.EquipamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipamento")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(
            @RequestParam("modelo") String modelo,
            @RequestParam("marca") String marca,
            @RequestParam("cor") String cor,
            @RequestParam("categoria") String categoria
            ) {
        Equipamento equipamento = equipamentoService.cadastrarEquipamento(modelo, marca, cor, CategoriaEquipamento.valueOf(categoria));
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamento);
    }

    @GetMapping("/cadastro")
    public String getHtmlCadastro() {
        return "cadastrarEquipamento";
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Equipamento>> buscarTodos() {
        return equipamentoService.listarEquipamentos();
    }

    @GetMapping("/buscar-equipamentos")
    public String listarEquipamentos(Model model) {
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos().getBody();
        model.addAttribute("equipamentos", equipamentos);
        return "buscarEquip";
    }

}
