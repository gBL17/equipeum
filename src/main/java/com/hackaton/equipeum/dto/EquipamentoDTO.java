package com.hackaton.equipeum.dto;

public class EquipamentoDTO {
    private String patrimonio;
    private String descricaoCompleta;

    public EquipamentoDTO() {
    }

    public EquipamentoDTO(String patrimonio, String descricaoCompleta) {
        this.patrimonio = patrimonio;
        this.descricaoCompleta = descricaoCompleta;
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
