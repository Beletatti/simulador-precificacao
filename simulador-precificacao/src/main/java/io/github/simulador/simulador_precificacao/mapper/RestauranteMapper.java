package io.github.simulador.simulador_precificacao.mapper;

import io.github.simulador.simulador_precificacao.domain.Restaurante;
import io.github.simulador.simulador_precificacao.dto.RestauranteRequest;
import io.github.simulador.simulador_precificacao.dto.RestauranteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {
    Restaurante toEntity(RestauranteRequest dto);
    RestauranteResponse toResponse(Restaurante entity);
}