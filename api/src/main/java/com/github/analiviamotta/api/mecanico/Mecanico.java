package com.github.analiviamotta.api.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosexperiencia;
    public Mecanico(DadosCadastroMecanico dados){
        this.nome = dados.nome();
        this.anosexperiencia = dados.anosexperiencia();
    }
}
