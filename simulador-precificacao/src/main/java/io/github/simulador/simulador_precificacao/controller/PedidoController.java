package io.github.simulador.simulador_precificacao.controller;

import io.github.simulador.simulador_precificacao.domain.Pedido;
import io.github.simulador.simulador_precificacao.service.PedidoService;
import io.github.simulador.simulador_precificacao.service.PrecoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    private final PrecoService precoService;

    public PedidoController(PedidoService pedidoService, PrecoService precoService) {
        this.pedidoService = pedidoService;
        this.precoService = precoService;
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarTodos();
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

    @PostMapping("/{id}/calcular-preco")
    public BigDecimal calcularPreco(@PathVariable Long id) {
        Pedido pedido = pedidoService.listarTodos()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return precoService.calcularPreco(pedido);
    }
}