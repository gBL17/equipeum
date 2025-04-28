package com.hackaton.equipeum.mapper;

import com.hackaton.equipeum.dto.EquipamentoDTO;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {

    public static Equipamento map(EquipamentoDTO equipamentoDTO) {
        return new Equipamento(
                equipamentoDTO.getDescricaoCompleta()
        );
    }
}
