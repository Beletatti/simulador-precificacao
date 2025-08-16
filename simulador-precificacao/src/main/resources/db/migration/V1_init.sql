-- Criar tabela restaurante
CREATE TABLE restaurante (
                             id BIGSERIAL PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             categoria VARCHAR(100) NOT NULL
);

-- Criar tabela pedido
CREATE TABLE pedido (
                        id BIGSERIAL PRIMARY KEY,
                        restaurante_id BIGINT NOT NULL,
                        valor_base NUMERIC(10,2) NOT NULL,
                        data_pedido TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
);

-- Criar tabela parametro_preco
CREATE TABLE parametro_preco (
                                 id BIGSERIAL PRIMARY KEY,
                                 categoria VARCHAR(100) NOT NULL UNIQUE,
                                 variacao_minima NUMERIC(5,2) NOT NULL,
                                 variacao_maxima NUMERIC(5,2) NOT NULL
);

-- Criar tabela historico_preco
CREATE TABLE historico_preco (
                                 id BIGSERIAL PRIMARY KEY,
                                 pedido_id BIGINT NOT NULL,
                                 preco_calculado NUMERIC(10,2) NOT NULL,
                                 data_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
