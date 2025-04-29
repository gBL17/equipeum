package com.hackaton.equipeum.controller;

import jakarta.servlet.http.HttpSession;
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

    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
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
        return funcionarioService.inativarFuncionarioPorCpf(cpf);
    }

    @GetMapping("/consultar-desligamento/{cpf}")
    public RuntimeException consultarDesligamento(@PathVariable String cpf)throws Exception {
      return new RuntimeException("Não implementado");
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(
//            @RequestParam("cpf") String cpf,
//            @RequestParam("senha") String senha
//    ) {
//        return ResponseEntity.ok("");
//        return funcionarioService.loginFuncionario(cpf, senha);
//    }

//    @GetMapping("/")
//    public  String getHtmlMenu() { return "index"; }

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
        Funcionario funcionario = funcionarioService.autenticar(cpf, senha);

        if (funcionario != null) {
            session.setAttribute("usuarioLogado", funcionario);
            return "redirect:/";
        } else {
            model.addAttribute("erro", "CPF ou senha inválidos.");
            return "login";
        }
    }

    @GetMapping("/login")
    public String getHtmlLogin() {
        return "telaLogin";
    }

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios().getBody();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionarios";
    }

}
