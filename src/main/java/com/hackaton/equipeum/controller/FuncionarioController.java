package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

//    @GetMapping
//    public List<FuncionarioResponse> listarFuncionarios() {
//        return funcionarioRepository.findAll().stream()
//                .map(f -> FuncionarioResponse.builder()
//                        .id(f.getId())
//                        .nome(f.getNome())
//                        .cpf(f.getCpf())
//                        .status(f.getStatus())
//                        .build())
//                .collect(Collectors.toList());
//    }
}
