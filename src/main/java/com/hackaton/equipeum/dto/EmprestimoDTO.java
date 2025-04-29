package com.hackaton.equipeum.dto;

import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;

public class EmprestimoDTO {

    private String cpf;
    private CategoriaEquipamento categoria;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(String cpf, CategoriaEquipamento categoria) {
        this.cpf = cpf;
        this.categoria = categoria;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CategoriaEquipamento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEquipamento categoria) {
        this.categoria = categoria;
    }
}
