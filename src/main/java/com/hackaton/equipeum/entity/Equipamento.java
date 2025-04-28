package com.hackaton.equipeum.entity;

import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "equipamentos")
public class Equipamento {
    @Id
    private String id;
    @NotBlank
    private String patrimonio;
    @NotBlank
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

    public static String gerarPatrimonio(CategoriaEquipamento categoria) {
        Map<CategoriaEquipamento, String> prefixos = new HashMap<>();
        prefixos.put(CategoriaEquipamento.NOTEBOOK, "NB-");
        prefixos.put(CategoriaEquipamento.CADEIRA, "CD-");
        prefixos.put(CategoriaEquipamento.MONITOR, "MT-");
        prefixos.put(CategoriaEquipamento.MOUSE, "MS-");
        prefixos.put(CategoriaEquipamento.TECLADO, "TL-");
        prefixos.put(CategoriaEquipamento.OUTROS, "OUTROS");

        Map<CategoriaEquipamento, Integer> numeros = new HashMap<>();
        numeros.put(categoria, numeros.getOrDefault(categoria, 0) + 1);
        Integer contador = numeros.get(categoria);

        String resultado = prefixos.getOrDefault(categoria, "OUTROS");
        return resultado + contador;
    }
}