package com.hackaton.equipeum.service;

import com.hackaton.equipeum.dto.EmprestimoDTO;
import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import com.hackaton.equipeum.exception.FuncionarioDesligadoException;
import com.hackaton.equipeum.exception.FuncionarioNaoExisteException;
import com.hackaton.equipeum.exception.FuncionarioPossuiEquipamentoException;
import com.hackaton.equipeum.mapper.EmprestimoMapper;
import com.hackaton.equipeum.repository.EmprestimoRepository;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import com.hackaton.equipeum.repository.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    private final EquipamentoRepository equipamentoRepository;
    private final EmprestimoRepository emprestimoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public EmprestimoService(EquipamentoRepository equipamentoRepository, EmprestimoRepository emprestimoRepository, FuncionarioRepository funcionarioRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Emprestimo solicitarEquipamento(EmprestimoDTO emprestimoDTO) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByCpf(emprestimoDTO.getCpfFuncionario());
        if (funcionario.isEmpty()) {
            throw new FuncionarioNaoExisteException();
        } else if (StatusFuncionario.Inativo.equals(funcionario.get().getStatus())){
            throw new FuncionarioDesligadoException();
        }
        List<Emprestimo> emprestimos = emprestimoRepository.findAllByCpfFuncionarioAndDataDevolucaoIsNull(emprestimoDTO.getCpfFuncionario());
        if (!emprestimos.isEmpty()) {
           throw new FuncionarioPossuiEquipamentoException();
        }

        Equipamento equipamento = obterDisponivel(emprestimoDTO.getCategoria());
        Emprestimo emprestimo = EmprestimoMapper.map(emprestimoDTO);
        emprestimo.setDataSolicitacao(LocalDateTime.now());

        if (equipamento != null) {
            emprestimo.setPatrimonio(equipamento.getPatrimonio());
            emprestimo.setDataRetirada(LocalDateTime.now());
        }
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolverEquipamento(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoRepository.findByCategoriaAndCpfFuncionario(emprestimoDTO.getCategoria(), emprestimoDTO.getCpfFuncionario());
        if (emprestimo != null){
            emprestimo.setDataDevolucao(LocalDateTime.now());
            return emprestimoRepository.save(emprestimo);
        } return null;
    }

    public Boolean verificarDisponibilidade(String patrimonio) {
        List<Emprestimo> emprestimos =
                emprestimoRepository.findAllByPatrimonioAndDataDevolucaoIsNull(patrimonio);
        return emprestimos.isEmpty();
    }

    public List<Emprestimo> pegarTodos() {
        return emprestimoRepository.findAll();
    }

    public Equipamento obterDisponivel(CategoriaEquipamento categoria) {
        List<Equipamento> equipamentos = equipamentoRepository.findAllByDescricaoCompletaCategoria(categoria);
        for (Equipamento equipamento : equipamentos) {
            if (verificarDisponibilidade(equipamento.getPatrimonio())) {
                return equipamento;
            }
        }
        return null;
    }

    public List<Emprestimo> findAllByPatrimonio(String patrimonio) {
        return emprestimoRepository.findAllByPatrimonio(patrimonio);
    }

    public List<EmprestimoDTO> findAllByCpf(String cpf) {
        List<Emprestimo> emprestimos = emprestimoRepository.findAllByCpfFuncionario(cpf);
        return EmprestimoMapper.map(emprestimos);
    }

    public List<Emprestimo> consultarPendencias(String cpf) {
        List<Emprestimo> emprestimos = emprestimoRepository.findAllByCpfFuncionarioAndDataDevolucaoIsNull(cpf);
        return emprestimos;
    }

    public List<Emprestimo> listarComprasPendentes() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAllByPatrimonioIsNull();
        return emprestimos;
    }
}
