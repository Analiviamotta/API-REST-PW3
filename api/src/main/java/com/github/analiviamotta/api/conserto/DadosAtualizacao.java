package com.github.analiviamotta.api.conserto;

import com.github.analiviamotta.api.mecanico.DadosAtualizacaoMecanico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacao(
        @NotNull
        Long id,
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String datasaida,
        @Valid
        DadosAtualizacaoMecanico mecanico
) {
}
