package com.hackaton.equipeum.service;

import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import com.hackaton.equipeum.mapper.FuncionarioMapper;
import com.hackaton.equipeum.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public Funcionario autenticar(String cpf, String senha) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByCpf(cpf);

        Funcionario funcionario = funcionarioOptional.orElse(null);

        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario;
        }
        return null;
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
        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Já existe um funcionário cadastrado com este CPF");
        }

        funcionario.setStatus(StatusFuncionario.Ativo);
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

//    public ResponseEntity<?> loginFuncionario(String cpf, String senha) {
//        CadastroDTO cadastroDTO = new CadastroDTO(cpf, senha);
//        return ResponseEntity.status(200).body((Funcionario)this.funcionarioRepository.save(this.funcionarioMapper.map(cadastroDTO)));
//    }

    public boolean loginFuncionario(String cpf, String senha){
        return funcionarioRepository.findByCpf(cpf)
                .filter(funcionario -> funcionario.getSenha().equals(senha))
                .isPresent();
    }

}
