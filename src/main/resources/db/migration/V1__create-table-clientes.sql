CREATE TABLE clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    data_nascimento VARCHAR(10) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    ativo TINYINT,
    admin TINYINT,

    PRIMARY KEY(id)
);

CREATE TABLE estacionamentos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_clientes BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    telefone_empresa VARCHAR(14) NOT NULL,
    dia_funcionamento VARCHAR(100) NOT NULL,
    horario_funcionamento VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    ativo TINYINT,

    PRIMARY KEY(id),
    FOREIGN KEY(id_clientes) REFERENCES clientes(id)
);