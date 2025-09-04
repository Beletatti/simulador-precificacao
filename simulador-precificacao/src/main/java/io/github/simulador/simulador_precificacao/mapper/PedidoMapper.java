package io.github.simulador.simulador_precificacao.mapper;

import io.github.simulador.simulador_precificacao.domain.Pedido;
import io.github.simulador.simulador_precificacao.domain.Restaurante;
import io.github.simulador.simulador_precificacao.dto.PedidoRequest;
import io.github.simulador.simulador_precificacao.dto.PedidoResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    /* Se na entidade o campo se chama 'subtotal', mapeie assim: */
    @Mappings({
            @Mapping(source = "valorBase", target = "subtotal"),
            @Mapping(source = "restauranteId", target = "restaurante", qualifiedByName = "idToRestaurante")
    })
    Pedido toEntity(PedidoRequest dto);

    /* Se na sua entidade o campo for 'valorBase', troque a linha acima por:
       @Mapping(source="valorBase", target="valorBase")
    */

    @Mappings({
            @Mapping(source = "restaurante.id", target = "restauranteId"),
            @Mapping(target = "valorBase", expression = "java(entity.getSubtotal() != null ? entity.getSubtotal() : entity.getValorBase())")
    })
    PedidoResponse toResponse(Pedido entity);

    @Named("idToRestaurante")
    default Restaurante idToRestaurante(Long id) {
        if (id == null) return null;
        Restaurante r = new Restaurante();
        r.setId(id);
        return r;
    }
}