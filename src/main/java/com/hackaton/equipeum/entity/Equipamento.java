package com.hackaton.equipeum.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Map;

@Document(collection = "equipamentos")
public class Equipamento {
    @Id
    private String id;
    @NotBlank
    private String patrimonio;
    @NotNull
    private Descricao descricaoCompleta;

    public Equipamento() {
    }

    public Equipamento(Descricao descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Equipamento(String patrimonio, Descricao descricaoCompleta) {
        this.patrimonio = patrimonio;
        this.descricaoCompleta = descricaoCompleta;
    }

    public Equipamento(String id, String patrimonio, Descricao descricaoCompleta) {
        this.id = id;
        this.patrimonio = patrimonio;
        this.descricaoCompleta = descricaoCompleta;
    }

    public String getId() {
        return id;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Descricao getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(Descricao descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

}