package com.hackaton.equipeum.entity;

import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "emprestimos")
public class Emprestimo {

    @Id
    private String id;
    private String patrimonio;
    @NotBlank
    private CategoriaEquipamento categoria;
    @NotBlank
    private String cpfFuncionario;
    @NotNull
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(CategoriaEquipamento categoria, String cpfFuncionario, LocalDateTime dataSolicitacao) {
        this.categoria = categoria;
        this.cpfFuncionario = cpfFuncionario;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Emprestimo(String patrimonio, CategoriaEquipamento categoria, String cpfFuncionario) {
        this.patrimonio = patrimonio;
        this.categoria = categoria;
        this.cpfFuncionario = cpfFuncionario;
    }

    public Emprestimo(String cpfFuncionario, String patrimonio) {
        this.cpfFuncionario = cpfFuncionario;
        this.patrimonio = patrimonio;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public CategoriaEquipamento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEquipamento categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
