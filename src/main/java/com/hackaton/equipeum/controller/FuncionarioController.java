package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.CadastroDTO;
import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.mapper.FuncionarioMapper;
import com.hackaton.equipeum.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioMapper = funcionarioMapper;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> criarFuncionario(@RequestBody CadastroDTO cadastroDTO) {
        return funcionarioService.criarFuncionario(funcionarioMapper.map(cadastroDTO));
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/buscar-ativos")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAtivos() {
        return funcionarioService.listarFuncionariosAtivos();
    }

    @PutMapping("/inativar/{id}")
    public ResponseEntity<?> inativarFuncionario(@PathVariable String id) {
        return funcionarioService.inativarFuncionario(id);
    }

    @PutMapping("/inativar-cpf/{cpf}")
    public ResponseEntity<?> inativarFuncionarioPorCpf(@PathVariable String cpf) {
        return funcionarioService.inativarFuncionarioPorCpf(cpf);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("senha") String senha
    ) {
        return funcionarioService.loginFuncionario(nome, cpf, senha);
    }

    @GetMapping("/login")
    public String getHtmlLogin() {
        return "telaLogin";
    }

}
