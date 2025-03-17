CREATE TABLE produtos (
                          id uuid not null primary key,
                          restaurante_id uuid NOT NULL,
                          foto_url TEXT,
                          nome VARCHAR(255) NOT NULL,
                          preço NUMERIC(10, 2) NOT NULL,
                          categoria VARCHAR(100) NOT NULL,
                          CONSTRAINT fk_restaurante
                          FOREIGN KEY (restaurante_id)
                          REFERENCES restaurantes(id)
                          ON DELETE CASCADE
);