package io.github.simulador.simulador_precificacao.controller;

import io.github.simulador.simulador_precificacao.domain.ParametroPreco;
import io.github.simulador.simulador_precificacao.dto.ParametroPrecoRequest;
import io.github.simulador.simulador_precificacao.dto.ParametroPrecoResponse;
import io.github.simulador.simulador_precificacao.mapper.ParametroPrecoMapper;
import io.github.simulador.simulador_precificacao.repository.ParametroPrecoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parametros")
@RequiredArgsConstructor
public class ParametroPrecoController {

    private final ParametroPrecoRepository repository;
    private final ParametroPrecoMapper mapper;

    @PostMapping
    public ResponseEntity<ParametroPrecoResponse> criar(@Valid @RequestBody ParametroPrecoRequest req) {
        ParametroPreco saved = repository.save(mapper.toEntity(req));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
    }

    @GetMapping
    public Page<ParametroPrecoResponse> listar(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @GetMapping("/categoria/{categoria}")
    public List<ParametroPrecoResponse> porCategoria(@PathVariable String categoria) {
        return repository.findByCategoria(categoria).stream().map(mapper::toResponse).toList();
    }
}