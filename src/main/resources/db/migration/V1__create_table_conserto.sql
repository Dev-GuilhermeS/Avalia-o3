CREATE TABLE consertos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_entrada VARCHAR(50),
    data_saida VARCHAR(50),

    marca VARCHAR(50),
    modelo VARCHAR(50),
    ano INTEGER,

    nome VARCHAR(100),
    anos_experiencia INTEGER
);