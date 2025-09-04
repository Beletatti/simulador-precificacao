package io.github.simulador.simulador_precificacao.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ParametroPrecoResponse {
    private Long id;
    private String categoria;
    private BigDecimal variacaoMinima;
    private BigDecimal variacaoMaxima;
    // getters/setters
}