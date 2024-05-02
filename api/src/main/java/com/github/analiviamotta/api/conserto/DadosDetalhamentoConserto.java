package com.github.analiviamotta.api.conserto;

import com.github.analiviamotta.api.mecanico.Mecanico;
import com.github.analiviamotta.api.veiculo.Veiculo;

public record DadosDetalhamentoConserto(
        Long id,
        String dataentrada,
        String datasaida,
        Mecanico mecanico,
        Veiculo veiculo
){
    public DadosDetalhamentoConserto(Conserto conserto){
        this(   conserto.getId(),
                conserto.getDataentrada(),
                conserto.getDatasaida(),
                conserto.getMecanico(),
                conserto.getVeiculo());
    }
}
