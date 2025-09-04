package io.github.simulador.simulador_precificacao.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class HistoricoPrecoResponse {
    private Long id;
    private Long pedidoId;
    private BigDecimal precoCalculado;
    private LocalDateTime dataRegistro;
}