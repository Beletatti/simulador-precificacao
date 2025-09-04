package io.github.simulador.simulador_precificacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ParametroPrecoRequest {
    @NotBlank
    private String categoria;

    @NotNull
    private BigDecimal variacaoMinima;

    @NotNull
    private BigDecimal variacaoMaxima;
}