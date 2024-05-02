package com.github.analiviamotta.api.conserto;

public record DadosListagemConserto(Long id,
                                    String dataentrada,
                                    String datasaida,
                                    String nome,
                                    String marca,
                                    String modelo) {
    public DadosListagemConserto(Conserto conserto) {
        this(   conserto.getId(),
                conserto.getDataentrada(),
                conserto.getDatasaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }
}
