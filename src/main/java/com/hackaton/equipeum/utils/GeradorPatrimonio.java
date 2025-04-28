package com.hackaton.equipeum.utils;

import com.hackaton.equipeum.entity.enums.CategoriaEquipamento;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import org.springframework.stereotype.Component;

@Component
public class GeradorPatrimonio {
    private final EquipamentoRepository equipamentoRepository;

    public GeradorPatrimonio(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public String gerarPatrimonio(CategoriaEquipamento categoria) {
        long quantidade = equipamentoRepository.countByDescricaoCompletaCategoria(categoria) + 1;

        String prefixo;
        switch (categoria) {
            case NOTEBOOK -> prefixo = "NB-";
            case CADEIRA  -> prefixo = "CD-";
            case MONITOR  -> prefixo = "MT-";
            case TECLADO  -> prefixo = "TL-";
            case MOUSE    -> prefixo = "MS-";
            default       -> prefixo = "OUTROS-";
        }

        return prefixo + quantidade;
    }
}
