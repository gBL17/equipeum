package com.hackaton.equipeum.entity;

import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;

public class Descricao {
    private String modelo;
    private String marca;
    private String cor;
    private CategoriaEquipamento categoria;

    public Descricao(String modelo, String marca, String cor, CategoriaEquipamento categoria) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public CategoriaEquipamento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEquipamento categoria) {
        this.categoria = categoria;
    }
}
