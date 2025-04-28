package com.hackaton.equipeum.service;

import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import com.hackaton.equipeum.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public ResponseEntity<?> inativarFuncionario(String id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (funcionario.getStatus() == StatusFuncionario.Inativo) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário já está inativo.");
        }
        funcionario.setStatus(StatusFuncionario.Inativo);

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
    }

    public ResponseEntity<?> inativarFuncionarioPorCpf(String cpf){
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf).orElse(null);
//        if (funcionario == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        if (funcionario.getStatus() == StatusFuncionario.Inativo) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário já está inativo.");
//        }
//        funcionario.setStatus(StatusFuncionario.Inativo);

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
    }

    public ResponseEntity<List<Funcionario>> listarFuncionariosAtivos() {
        List<Funcionario> funcionariosAtivos = funcionarioRepository.findByStatus(StatusFuncionario.Ativo);
        return ResponseEntity.status(HttpStatus.OK).body(funcionariosAtivos);
    }

    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findAll());
    }

    public ResponseEntity<?> criarFuncionario(Funcionario funcionario) {
        funcionario.setStatus(StatusFuncionario.Ativo);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
    }
}
