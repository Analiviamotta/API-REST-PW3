package com.github.analiviamotta.api.conserto;

public record DadosListagemConserto(String dataentrada,
                                    String datasaida,
                                    String nome,
                                    String marca,
                                    String modelo) {
    public DadosListagemConserto(Conserto conserto) {
        this(   conserto.getDataentrada(),
                conserto.getDatasaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }
}
