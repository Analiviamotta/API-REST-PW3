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
    private String anosexperiencia;
    public Mecanico(DadosCadastroMecanico dados){
        this.nome = dados.nome();
        this.anosexperiencia = dados.anosexperiencia();
    }

    public void atualizaDados(DadosAtualizacaoMecanico dados){
        if(dados.nome() != null) nome = dados.nome();

        if(dados.anosexperiencia() != null) anosexperiencia = dados.anosexperiencia();
    }

}
