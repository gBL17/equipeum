package com.hackaton.equipeum.mapper;

import com.hackaton.equipeum.dto.EquipamentoDTO;
import com.hackaton.equipeum.entity.Equipamento;
import com.hackaton.equipeum.repository.EquipamentoRepository;
import com.hackaton.equipeum.utils.GeradorPatrimonio;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {
    private final GeradorPatrimonio geradorPatrimonio;

    public EquipamentoMapper(GeradorPatrimonio geradorPatrimonio) {
        this.geradorPatrimonio = geradorPatrimonio;
    }

    public Equipamento map(EquipamentoDTO equipamentoDTO) {
        return new Equipamento(
                geradorPatrimonio.gerarPatrimonio(equipamentoDTO.getDescricaoCompleta().getCategoria()),
                equipamentoDTO.getDescricaoCompleta()
        );
    }
}
