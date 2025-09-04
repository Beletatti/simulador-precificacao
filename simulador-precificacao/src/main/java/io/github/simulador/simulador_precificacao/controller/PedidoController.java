package io.github.simulador.simulador_precificacao.controller;

import io.github.simulador.simulador_precificacao.domain.Pedido;
import io.github.simulador.simulador_precificacao.dto.PedidoRequest;
import io.github.simulador.simulador_precificacao.dto.PedidoResponse;
import io.github.simulador.simulador_precificacao.mapper.PedidoMapper;
import io.github.simulador.simulador_precificacao.repository.PedidoRepository;
import io.github.simulador.simulador_precificacao.repository.RestauranteRepository;
import io.github.simulador.simulador_precificacao.service.PedidoService;
import io.github.simulador.simulador_precificacao.service.PrecoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final RestauranteRepository restauranteRepository;
    private final PedidoMapper mapper;
    private final PrecoService precoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@Valid @RequestBody PedidoRequest req) {
        // valida FK
        if (!restauranteRepository.existsById(req.getRestauranteId())) {
            throw new EntityNotFoundException("Restaurante não encontrado");
        }
        Pedido entity = mapper.toEntity(req);
        Pedido saved = pedidoRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
    }

    @GetMapping
    public Page<PedidoResponse> listar(Pageable pageable) {
        return pedidoRepository.findAll(pageable).map(mapper::toResponse);
    }

    @PostMapping("/{id}/calcular")
    public BigDecimal calcular(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        return precoService.calcularPreco(pedido);
    }
}