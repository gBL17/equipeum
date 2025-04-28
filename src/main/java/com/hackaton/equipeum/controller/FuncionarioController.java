package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import com.hackaton.equipeum.repository.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping("/cadastro")
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        funcionario.setStatus(StatusFuncionario.Ativo);
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionariosAtivos = funcionarioRepository.findByStatus(StatusFuncionario.Ativo);
        return ResponseEntity.ok(funcionariosAtivos);
    }

    @PutMapping("/inativar/{id}")
    public ResponseEntity<String> inativarFuncionario(@PathVariable String id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        if (funcionario.getStatus() == StatusFuncionario.Inativo) {
            return ResponseEntity.badRequest().body("Funcionário já está inativo.");
        }
        funcionario.setStatus(StatusFuncionario.Inativo);
        funcionarioRepository.save(funcionario);

        return ResponseEntity.ok("Funcionário inativado com sucesso!");
    }
}
