package com.hackaton.equipeum.dto;

public class EquipamentoDTO {
    private String descricaoCompleta;

    public EquipamentoDTO() {
    }

    public EquipamentoDTO(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }
}
