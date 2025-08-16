package io.github.simulador.simulador_precificacao.service;

import io.github.simulador.simulador_precificacao.domain.Restaurante;
import io.github.simulador.simulador_precificacao.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }
}