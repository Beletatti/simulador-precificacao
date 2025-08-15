package io.github.simulador.simulador_precificacao.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "restaurante")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 120)
    private String nome;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "taxa_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal taxaBase;

    @Column(length = 60)
    private String categoria;

    @DecimalMin("0.00")
    @DecimalMax("5.00")
    @Column(precision = 3, scale = 2)
    private BigDecimal rating;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private Instant criadoEm;
}