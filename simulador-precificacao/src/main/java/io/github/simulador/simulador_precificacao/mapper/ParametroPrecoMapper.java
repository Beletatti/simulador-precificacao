package io.github.simulador.simulador_precificacao.mapper;

import io.github.simulador.simulador_precificacao.domain.ParametroPreco;
import io.github.simulador.simulador_precificacao.dto.ParametroPrecoRequest;
import io.github.simulador.simulador_precificacao.dto.ParametroPrecoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParametroPrecoMapper {
    ParametroPreco toEntity(ParametroPrecoRequest dto);
    ParametroPrecoResponse toResponse(ParametroPreco entity);
}