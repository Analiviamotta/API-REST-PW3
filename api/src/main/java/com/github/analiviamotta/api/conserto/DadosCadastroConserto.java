package com.github.analiviamotta.api.conserto;

import com.github.analiviamotta.api.mecanico.DadosCadastroMecanico;
import com.github.analiviamotta.api.veiculo.DadosCadastroVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String dataentrada,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String datasaida,
        @NotNull
        @Valid
        DadosCadastroMecanico mecanico,
        @NotNull
        @Valid
        DadosCadastroVeiculo veiculo) {
}
