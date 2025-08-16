package io.github.simulador.simulador_precificacao.repository;

import io.github.simulador.simulador_precificacao.domain.HistoricoPreco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoPrecoRepository extends JpaRepository<HistoricoPreco, Long> {
}