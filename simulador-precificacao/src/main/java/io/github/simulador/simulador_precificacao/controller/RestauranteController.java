package io.github.simulador.simulador_precificacao.controller;

import io.github.simulador.simulador_precificacao.domain.Restaurante;
import io.github.simulador.simulador_precificacao.dto.RestauranteRequest;
import io.github.simulador.simulador_precificacao.dto.RestauranteResponse;
import io.github.simulador.simulador_precificacao.mapper.RestauranteMapper;
import io.github.simulador.simulador_precificacao.repository.RestauranteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteRepository repository;
    private final RestauranteMapper mapper;

    @PostMapping
    public ResponseEntity<RestauranteResponse> criar(@Valid @RequestBody RestauranteRequest req) {
        Restaurante saved = repository.save(mapper.toEntity(req));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
    }

    @GetMapping
    public Page<RestauranteResponse> listar(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @GetMapping("/{id}")
    public RestauranteResponse buscar(@PathVariable Long id) {
        Restaurante r = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado"));
        return mapper.toResponse(r);
    }
}