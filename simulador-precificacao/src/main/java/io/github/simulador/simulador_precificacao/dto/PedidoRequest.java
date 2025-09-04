package io.github.simulador.simulador_precificacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoRequest {
    @NotBlank
    private String clienteNome;

    @NotNull
    private Long restauranteId;

    @NotNull
    private BigDecimal distanciaKm;

    @NotNull
    private BigDecimal valorBase; // <- mapear para o campo da entidade

}