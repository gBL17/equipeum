package com.hackaton.equipeum.dto;

import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.entity.enums.StatusEmprestimo;

import java.time.LocalDateTime;

public class EmprestimoDTO {
    private String patrimonio;
    private CategoriaEquipamento categoria;
    private String cpfFuncionario;
    private StatusEmprestimo statusEmprestimo;
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(String cpfFuncionario, CategoriaEquipamento categoria) {
        this.cpfFuncionario = cpfFuncionario;
        this.categoria = categoria;
    }

    public EmprestimoDTO(String patrimonio, CategoriaEquipamento categoria, String cpfFuncionario, StatusEmprestimo statusEmprestimo, LocalDateTime dataSolicitacao, LocalDateTime dataRetirada, LocalDateTime dataDevolucao) {
        this.patrimonio = patrimonio;
        this.categoria = categoria;
        this.cpfFuncionario = cpfFuncionario;
        this.statusEmprestimo = statusEmprestimo;
        this.dataSolicitacao = dataSolicitacao;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public CategoriaEquipamento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEquipamento categoria) {
        this.categoria = categoria;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
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
}
