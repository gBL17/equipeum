package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}

