package io.github.simulador.simulador_precificacao.repository;


import io.github.simulador.simulador_precificacao.domain.ParametroPreco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParametroPrecoRepository extends JpaRepository<ParametroPreco, Long> {
    Optional<ParametroPreco> findByCategoria(String categoria);
}