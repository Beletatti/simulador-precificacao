package io.github.simulador.simulador_precificacao.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "parametro_preco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroPreco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;

    @Column(name = "variacao_minima", nullable = false)
    private Double variacaoMinima;

    @Column(name = "variacao_maxima", nullable = false)
    private Double variacaoMaxima;
}