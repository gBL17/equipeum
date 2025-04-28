package com.hackaton.equipeum.dto.equipamento.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastrarEquipamentoRequest {
    private String numeroPatrimonio;
    private String descricaoCompleta;
}
