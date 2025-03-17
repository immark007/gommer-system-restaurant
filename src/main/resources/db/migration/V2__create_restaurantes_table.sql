CREATE TABLE restaurantes (
                              id uuid not null primary key,
                              foto_url TEXT,
                              nome VARCHAR(255) NOT NULL,
                              endereco_rua VARCHAR(255) NOT NULL,
                              endereco_numero VARCHAR(50) NOT NULL,
                              endereco_cidade VARCHAR(100) NOT NULL,
                              endereco_estado VARCHAR(50) NOT NULL,
                              endereco_cep VARCHAR(20) NOT NULL,
                              horarios_funcionamento TEXT NOT NULL,
                              usuario_id uuid NOT NULL,
                              CONSTRAINT fk_usuario
                              FOREIGN KEY (usuario_id)
                              REFERENCES usuarios(id)
                              ON DELETE CASCADE
);