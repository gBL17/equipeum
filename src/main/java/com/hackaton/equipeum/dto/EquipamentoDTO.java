package com.hackaton.equipeum.dto;

import com.hackaton.equipeum.entity.Descricao;

public class EquipamentoDTO {
    private Descricao descricaoCompleta;

    public EquipamentoDTO() {
    }

    public EquipamentoDTO(Descricao descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Descricao getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(Descricao descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }
}
