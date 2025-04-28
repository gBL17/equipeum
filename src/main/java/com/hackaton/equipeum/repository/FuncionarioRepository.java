package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FuncionarioRepository extends MongoRepository <Funcionario, String>{
    Optional<Funcionario> findByString(String cpf);
}
