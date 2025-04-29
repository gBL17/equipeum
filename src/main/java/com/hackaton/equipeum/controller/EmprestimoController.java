package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private final EmprestimoService emprestimoService ;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/solicitar-equipamento")
    public ResponseEntity<Emprestimo> solicitarEquipamento(@RequestBody EmprestimoDTO emprestimoDTO) {
        return ResponseEntity.status(200).body(emprestimoService.solicitarEquipamento(emprestimoDTO));
    }

    @PatchMapping("/devolver-equipamento")
    public ResponseEntity<?> devolverEquipamento(@RequestBody EmprestimoDTO emprestimoDTO) {
        return emprestimoService.devolverEquipamento(emprestimoDTO);
    }

    @GetMapping("/verificar-disponibilidade/{patrimonio}")
    public ResponseEntity<Boolean> verificar(@PathVariable String patrimonio) {
        return ResponseEntity.status(200).body(emprestimoService.verificarDisponibilidade(patrimonio));
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Emprestimo>> pegarTodos() {
        return ResponseEntity.status(200).body(emprestimoService.pegarTodos());
    }

    @GetMapping("/obter-disponivel/{categoria}")
    public ResponseEntity<?> obterDisponivel(@PathVariable CategoriaEquipamento categoria) {
        Equipamento equipamento = emprestimoService.obterDisponivel(categoria);
        if (equipamento == null) {
            return ResponseEntity.status(404).body("Nao existe item disponivel");
        }
        return ResponseEntity.status(200).body(equipamento);
    }

    @GetMapping("/historio-equipamento/{patrimonio}")
    @GetMapping("/historio-funcionario/{cpf}")
}
