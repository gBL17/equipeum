package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Equipamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends MongoRepository<Equipamento, String> {
}
