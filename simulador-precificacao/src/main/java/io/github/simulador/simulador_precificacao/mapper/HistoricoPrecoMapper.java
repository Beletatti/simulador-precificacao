package io.github.simulador.simulador_precificacao.mapper;


import io.github.simulador.simulador_precificacao.domain.HistoricoPreco;
import io.github.simulador.simulador_precificacao.dto.HistoricoPrecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricoPrecoMapper {
    @Mapping(source = "pedido.id", target = "pedidoId")
    HistoricoPrecoResponse toResponse(HistoricoPreco entity);
}