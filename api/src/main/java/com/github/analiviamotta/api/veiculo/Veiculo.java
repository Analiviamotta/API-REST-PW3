package com.github.analiviamotta.api.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String cor;
    private String ano;

    public Veiculo(DadosCadastroVeiculo dados){
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.cor = dados.cor();
        this.ano = dados.ano();
    }
}
