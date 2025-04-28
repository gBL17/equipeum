package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.funcionario.FuncionarioRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody FuncionarioRequest request) {
        String nome = request.getNome();
        String cpf = request.getCpf();
        boolean status = request.isStatus();

        return ResponseEntity.ok("Cadastro realizado com sucesso!");
    }
}
