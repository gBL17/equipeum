package com.hackaton.equipeum.mapper;

import com.hackaton.equipeum.dto.EquipamentoDTO;
import com.hackaton.equipeum.entity.Equipamento;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {
    public static Equipamento map(EquipamentoDTO equipamentoDTO){
        return new Equipamento(
                equipamentoDTO.getPatrimonio(),
                equipamentoDTO.getDescricaoCompleta()
        );
    }
}
