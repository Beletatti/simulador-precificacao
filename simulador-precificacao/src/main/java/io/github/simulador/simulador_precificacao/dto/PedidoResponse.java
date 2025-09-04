package io.github.simulador.simulador_precificacao.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoResponse {
    private Long id;
    private String clienteNome;
    private Long restauranteId;
    private BigDecimal distanciaKm;
    private BigDecimal valorBase;
}