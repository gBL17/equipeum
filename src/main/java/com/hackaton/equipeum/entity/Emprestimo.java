package com.hackaton.equipeum.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "emprestimos")
public class Emprestimo {

    @Id
    private String id;
    @NotBlank
    private String patrimonio;
    @NotBlank
    private String responsavel;
    @NotNull
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(String patrimonio, String responsavel, LocalDateTime dataRetirada) {
        this.patrimonio = patrimonio;
        this.responsavel = responsavel;
        this.dataRetirada = dataRetirada;
    }

    public Emprestimo(String responsavel, String patrimonio) {
        this.responsavel = responsavel;
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
