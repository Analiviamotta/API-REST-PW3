package com.github.analiviamotta.api.mecanico;

import jakarta.validation.constraints.NotBlank;


public record DadosCadastroMecanico(@NotBlank String nome,
                                    int anosexperiencia) {
}
