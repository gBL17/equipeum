package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import com.hackaton.equipeum.service.EmprestimoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import com.hackaton.equipeum.dto.CadastroDTO;
import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.mapper.FuncionarioMapper;
import com.hackaton.equipeum.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;
    private final EmprestimoService emprestimoService;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioController(FuncionarioService funcionarioService, EmprestimoService emprestimoService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
        this.emprestimoService = emprestimoService;
        this.funcionarioMapper = funcionarioMapper;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> criarFuncionario(@RequestBody @Valid CadastroDTO cadastroDTO) {
        Funcionario funcionario = funcionarioMapper.map(cadastroDTO);
        return funcionarioService.criarFuncionario(funcionario);
    }

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("cadastroDTO", new CadastroDTO());
        return "telaCadastro";
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/buscar-ativos")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAtivos() {
        return funcionarioService.listarFuncionariosAtivos();
    }

    @PutMapping("/inativar-cpf/{cpf}")
    public ResponseEntity<?> inativarFuncionarioPorCpf(@PathVariable String cpf) {
        try {
            return ResponseEntity.status(200).body(funcionarioService.inativarFuncionarioPorCpf(cpf));
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        }
    }

    @GetMapping("/consultar-desligamento/{cpf}")
    public ResponseEntity<StatusFuncionario> consultarDesligamento(@PathVariable String cpf) {
      return ResponseEntity.status(200).body(funcionarioService.consultarDesligamento(cpf));
    }

    @GetMapping("/consultar-pendencias/{cpf}")
    public ResponseEntity<List<Emprestimo>> consultarPendencias(@PathVariable String cpf) {
        List<Emprestimo> emprestimos = emprestimoService.consultarPendencias(cpf);
        if (emprestimos.isEmpty()) {
            return ResponseEntity.status(404).body(emprestimos);
        }
        return ResponseEntity.status(200).body(emprestimos);
    }

    @PostMapping
    public String getHtmlMenu(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/funcionario/login";
        }
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String cpf,
                        @RequestParam String senha,
                        HttpSession session,
                        Model model) {
        try {
            Funcionario funcionario = funcionarioService.autenticar(cpf, senha);
            session.setAttribute("usuarioLogado", funcionario);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
            return "telaLogin";
        }
    }

    @GetMapping("/login")
    public String getHtmlLogin() {
        return "telaLogin";
    }

    @GetMapping("/listar")
    public String listarFuncionarios(@RequestParam(required = false) String status, Model model) {
        List<Funcionario> funcionarios = null;

        if (status == null || status.isBlank()) {
            funcionarios = funcionarioService.listarFuncionarios().getBody();
        } else if (status.equals("Ativo")) {
            try {
                funcionarios = funcionarioService.listarFuncionariosAtivos().getBody();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            funcionarios = funcionarioService.listarFuncionariosPorStatus(StatusFuncionario.Inativo).getBody();
        }


        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionarios";
    }

}
