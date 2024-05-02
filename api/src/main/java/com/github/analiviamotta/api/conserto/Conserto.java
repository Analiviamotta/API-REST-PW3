package com.github.analiviamotta.api.conserto;

import com.github.analiviamotta.api.mecanico.DadosCadastroMecanico;
import com.github.analiviamotta.api.mecanico.Mecanico;
import com.github.analiviamotta.api.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "consertos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataentrada;
    private String datasaida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;
    public Conserto(DadosCadastroConserto dados){
        this.dataentrada = dados.dataentrada();
        this.datasaida = dados.datasaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }
    public void atualizaDados(DadosAtualizacao dados){
        if(dados.datasaida() != null)
            datasaida = dados.datasaida();
        if(dados.mecanico() != null)
            mecanico.atualizaDados(dados.mecanico());
    }
}
