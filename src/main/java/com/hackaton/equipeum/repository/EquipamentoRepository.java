package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends MongoRepository<Equipamento, String> {
    long countByDescricaoCompletaCategoria(CategoriaEquipamento categoria);

}
