package io.github.simulador.simulador_precificacao.repository;

import io.github.simulador.simulador_precificacao.domain.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {}