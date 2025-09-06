package io.github.simulador.simulador_precificacao.service;

import io.github.simulador.simulador_precificacao.domain.HistoricoPreco;
import io.github.simulador.simulador_precificacao.domain.ParametroPreco;
import io.github.simulador.simulador_precificacao.domain.Pedido;
import io.github.simulador.simulador_precificacao.repository.HistoricoPrecoRepository;
import io.github.simulador.simulador_precificacao.repository.ParametroPrecoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class PrecoService {
    private final ParametroPrecoRepository parametroPrecoRepository;
    private final HistoricoPrecoRepository historicoPrecoRepository;

    @Cacheable(value = "parametroPorCategoria", key = "#categoria")
    public Optional<ParametroPreco> parametroPorCategoria(String categoria) {
        return parametroPrecoRepository.findByCategoria(categoria).stream().findFirst();
    }

    public PrecoService(ParametroPrecoRepository parametroPrecoRepository,
                        HistoricoPrecoRepository historicoPrecoRepository) {
        this.parametroPrecoRepository = parametroPrecoRepository;
        this.historicoPrecoRepository = historicoPrecoRepository;
    }

    public BigDecimal calcularPreco(Pedido pedido) {
        var paramOpt = parametroPorCategoria(pedido.getRestaurante().getCategoria());
        // buscar parametro da categoria do restaurante
        Optional<ParametroPreco> parametroOpt = parametroPrecoRepository.findByCategoria(
                pedido.getRestaurante().getCategoria()
        );

        if (parametroOpt.isEmpty()) {
            return pedido.getValorBase(); // sem parâmetro, retorna preço base
        }

        ParametroPreco parametro = parametroOpt.get();

        // simulação: pega variação aleatória entre min e max
        Random random = new Random();
        double variacao = parametro.getVariacaoMinima().doubleValue() +
                (random.nextDouble() * (parametro.getVariacaoMaxima().doubleValue() - parametro.getVariacaoMinima().doubleValue()));

        BigDecimal precoFinal = pedido.getValorBase()
                .multiply(BigDecimal.valueOf(1 + variacao / 100))
                .setScale(2, RoundingMode.HALF_UP);

        // salvar histórico
        HistoricoPreco historico = new HistoricoPreco();
        historico.setPedido(pedido);
        historico.setPrecoCalculado(precoFinal);
        historico.setDataRegistro(LocalDateTime.now());

        historicoPrecoRepository.save(historico);

        return precoFinal;
    }
}