package com.hackaton.equipeum.repository;

import com.hackaton.equipeum.entity.Emprestimo;
import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {
    List<Emprestimo> findAllByPatrimonioAndDataDevolucaoIsNull(String patrimonio);
    List<Emprestimo> findAllByCategoria(CategoriaEquipamento categoria);
    List<Emprestimo> findAllByPatrimonio(String patrimonio);
    List<Emprestimo> findAllByCpfFuncionario(String cpfFuncionario);
    Emprestimo findByCategoriaAndCpfFuncionario(CategoriaEquipamento categoria, String cpfFuncionario);
    List<Emprestimo> findAllByCategoriaAndPatrimonioIsNull(CategoriaEquipamento categoria);
    List<Emprestimo> findAllByCpfFuncionarioAndDataDevolucaoIsNull(String cpfFuncionario);
    List<Emprestimo> findAllByPatrimonioIsNull();
}
