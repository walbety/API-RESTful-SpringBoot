

USE db_pessoas;
CREATE TABLE pessoas (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NULL,
    idade INT NULL,
    cpf VARCHAR(15) NULL,
    rg VARCHAR(15) NULL,
    data_nasc VARCHAR(15) NULL,
    signo VARCHAR(30) NULL,
    mae VARCHAR(80) NULL,
    pai VARCHAR(80) NULL,
    email VARCHAR(90) NULL,
    senha VARCHAR(30) NULL,
    cep VARCHAR(15) NULL,
    endereco VARCHAR(80) NULL,
    numero INT NULL,
    bairro VARCHAR(50) NULL,
    cidade VARCHAR(30) NULL,
    estado VARCHAR(30) NULL,
    telefone_fixo VARCHAR(20) NULL,
    celular VARCHAR(20) NULL,
    altura DECIMAL(3,2) NULL,
    peso INT NULL,
    tipo_sanguineo VARCHAR(5) NULL,
    cor VARCHAR(10) NULL,
    PRIMARY KEY(id)
);