package com.hackaton.equipeum.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "equipamentos")
public class Equipamento {
    @Id
    private String id;
    @NotBlank
    private String patrimonio;
    @NotBlank
    private String descricao;

    public Equipamento(String patrimonio, String descricao) {
        this.descricao = descricao;
        this.patrimonio = patrimonio;
    }
}