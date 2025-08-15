-- Tabela de restaurantes
create table if not exists restaurante (
                                           id              bigserial primary key,
                                           nome            varchar(120) not null,
    taxa_base       numeric(10,2) not null, -- taxa base do restaurante
    categoria       varchar(60),
    rating          numeric(3,2) default 0,
    criado_em       timestamp not null default now()
    );

-- Tabela de pedidos (básico para Sprint 1)
create table if not exists pedido (
                                      id               bigserial primary key,
                                      cliente_nome     varchar(120) not null,
    restaurante_id   bigint not null references restaurante (id),
    distancia_km     numeric(6,2) not null,
    subtotal         numeric(10,2) not null, -- valor base dos itens do pedido
    criado_em        timestamp not null default now()
    );

create index if not exists idx_pedido_restaurante on pedido(restaurante_id);
