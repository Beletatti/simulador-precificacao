package io.github.simulador.simulador_precificacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String categoria;
    @NotNull
    private BigDecimal taxaBase;
    // getters/setters
}