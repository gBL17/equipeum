package com.hackaton.equipeum.entity;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipamentos")
public class Equipamento {
    @Id
    private String id;
    @NotBlank
    private String patrimonio;
    @NotBlank
    private String descricaoCompleta;

    public Equipamento() {
    }

    public Equipamento(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Equipamento(String id, String patrimonio, String descricaoCompleta) {
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

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }
}