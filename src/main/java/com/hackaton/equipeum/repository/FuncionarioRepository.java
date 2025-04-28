package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Funcionario;
import com.hackaton.equipeum.entity.enums.StatusFuncionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    List<Funcionario> findByStatus(StatusFuncionario status);
}

