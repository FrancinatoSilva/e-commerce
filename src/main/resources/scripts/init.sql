
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE categoria (
                           categoria_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                           nome VARCHAR(255) NOT NULL,
                           descricao TEXT
);

CREATE TABLE usuario (
                         usuario_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                         nome VARCHAR(255) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL,
                         senha VARCHAR(255) NOT NULL,
                         data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE produto (
                         produto_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                         nome VARCHAR(255) NOT NULL,
                         descricao TEXT,
                         preco DECIMAL(10,2) NOT NULL,
                         estoque INTEGER NOT NULL,
                         ativo BOOLEAN DEFAULT TRUE,
                         categoria_id UUID REFERENCES categoria(categoria_id)
);

CREATE TABLE carrinho (
                          carrinho_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          usuario_id UUID REFERENCES usuario(usuario_id),
                          data_criacao DATE DEFAULT CURRENT_DATE,
                          status VARCHAR(50)
);

CREATE TABLE item_carrinho (
                               item_carrinho_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                               carrinho_id UUID REFERENCES carrinho(carrinho_id),
                               produto_id UUID REFERENCES produto(produto_id),
                               quantidade INTEGER NOT NULL,
                               preco_unitario DECIMAL(10,2) NOT NULL
);

CREATE TABLE pedido (
                        pedido_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                        usuario_id UUID REFERENCES usuario(usuario_id),
                        data_pedido DATE DEFAULT CURRENT_DATE,
                        valor_total DECIMAL(10,2) NOT NULL,
                        status VARCHAR(50)
);

CREATE TABLE item_pedido (
                             item_pedido_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                             pedido_id UUID REFERENCES pedido(pedido_id),
                             produto_id UUID REFERENCES produto(produto_id),
                             quantidade INTEGER NOT NULL,
                             preco_unitario DECIMAL(10,2) NOT NULL,
                             sub_total DECIMAL(10,2) NOT NULL
);