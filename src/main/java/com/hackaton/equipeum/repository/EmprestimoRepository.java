package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Emprestimo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {
    Emprestimo findByPatrimonio(String patrimonio);
}
