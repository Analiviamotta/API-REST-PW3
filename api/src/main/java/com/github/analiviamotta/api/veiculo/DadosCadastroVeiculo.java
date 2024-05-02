package com.github.analiviamotta.api.veiculo;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVeiculo(@NotBlank String marca,
                                   @NotBlank String modelo,
                                   String cor,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{4}")
                                   String ano){
}
