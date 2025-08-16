package io.github.simulador.simulador_precificacao.controller;

import io.github.simulador.simulador_precificacao.domain.Restaurante;
import io.github.simulador.simulador_precificacao.service.RestauranteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteService.listarTodos();
    }

    @PostMapping
    public Restaurante criar(@RequestBody Restaurante restaurante) {
        return restauranteService.salvar(restaurante);
    }
}