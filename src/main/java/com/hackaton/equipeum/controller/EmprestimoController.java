package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private final EmprestimoService emprestimoService ;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/solicitar-equipamento")
    public ResponseEntity<?> solicitarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        return emprestimoService.solicitarEmprestimo(emprestimoDTO);
    }

    @PatchMapping("/devolver-equipamento")
    public ResponseEntity<?> devolverEquipamento(@RequestBody EmprestimoDTO emprestimoDTO) {
        return emprestimoService.devolverEquipamento(emprestimoDTO);
    }
}
