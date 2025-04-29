package com.hackaton.equipeum.controller;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.service.EmprestimoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private final EmprestimoService emprestimoService ;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PatchMapping("/solicitar-equipamento")
    public ResponseEntity<?> solicitarEquipamento(@RequestBody EmprestimoDTO emprestimoDTO) {
        try {
            return ResponseEntity.status(200).body(emprestimoService.solicitarEquipamento(emprestimoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        }
    }

    @GetMapping("/solicitar")
    public String solicitarPaginaEquipamento(){
        return "solicitarEquipamento";
    }

    public ResponseEntity<Emprestimo> solicitarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        return ResponseEntity.status(200).body(emprestimoService.solicitarEquipamento(emprestimoDTO));
    }

    @PatchMapping("/devolver-equipamento")
    public ResponseEntity<?> devolverEquipamento(@RequestBody EmprestimoDTO emprestimoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.devolverEquipamento(emprestimoDTO));
    }

    @GetMapping("/verificar-disponibilidade/{patrimonio}")
    public ResponseEntity<Boolean> verificar(@PathVariable String patrimonio) {
        return ResponseEntity.status(200).body(emprestimoService.verificarDisponibilidade(patrimonio));
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Emprestimo>> pegarTodos() {
        return ResponseEntity.status(200).body(emprestimoService.pegarTodos());
    }
    @GetMapping("/inventario")
    public String buscarInventarioHtml(){
            return "buscarInventario";
    }


    @GetMapping("/obter-disponivel/{categoria}")
    public ResponseEntity<?> obterDisponivel(@PathVariable CategoriaEquipamento categoria) {
        Equipamento equipamento = emprestimoService.obterDisponivel(categoria);
        if (equipamento == null) {
            return ResponseEntity.status(404).body("Não existe item disponivel");
        }
        return ResponseEntity.status(200).body(equipamento);
    }

    @GetMapping("/historico-equipamento/{patrimonio}")
    public ResponseEntity<?> obterHistoricoEquipamento(@PathVariable String patrimonio){
        List<Emprestimo> emprestimos = emprestimoService.findAllByPatrimonio(patrimonio);
        if(!emprestimos.isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).body(emprestimos);
        }
        return ResponseEntity.status(404).body("Equipamento não possui histórico disponível!");
    }

    @GetMapping("/historico-funcionario/{cpf}")
    public ResponseEntity<?> obterEmprestimosFuncionario(@PathVariable String cpf){
        List<EmprestimoDTO> emprestimosDTOS = emprestimoService.findAllByCpf(cpf);
        if (!emprestimosDTOS.isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).body(emprestimosDTOS);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Funcionário não tem equipamentos emprestados"));    }

    @GetMapping("/listar-compras-pendentes")
    public ResponseEntity<?> listarComprasPendentes() {
        return ResponseEntity.status(200).body(emprestimoService.listarComprasPendentes());
    }

    @PostMapping("/emprestimos-funcionario/{cpf}")
    public ResponseEntity<?> buscaEmprestados(@PathVariable String cpf){
        List<EmprestimoDTO> emprestimoDTOS = emprestimoService.findAllCurrentByCpf(cpf);
        if (!emprestimoDTOS.isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoDTOS);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não tem equipamentos Emprestados");
    }
    @GetMapping("/historico-funcionario")
    public String getHtmlHistorico(){
        return "historicoEquipamento";
    }
    @GetMapping("/devolucao")
    public String carregarTelaDevolucao(HttpSession session, Model model) {
        Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");

        if (funcionario == null) {
            return "telaLogin";
        }
        List<EmprestimoDTO> emprestimos = emprestimoService.findAllCurrentByCpf(funcionario.getCpf());
        model.addAttribute("emprestimos", emprestimos);
        return "devolverEquipamento";
    }
    @GetMapping("/compras-pendentes")
    public String listarComprasPendentes(Model model) {
        List<Emprestimo> emprestimos = emprestimoService.listarComprasPendentes();
        model.addAttribute("emprestimos", emprestimos);
        return "listarComprasPendentes";
    }
    @GetMapping("/historico-equipamento")
    public String getHtmlHistoricoEquip() {
        return "buscarPorPatrimonio";
    }
}
