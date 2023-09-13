create database empresa;

CREATE TABLE funcionario (
    matricula VARCHAR(255),
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    senha VARCHAR(255),
    cpf VARCHAR(11),
    cargo_Id INT, -- Coluna para a chave estrangeira
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);

-- Criação da tabela cargo
CREATE TABLE cargo (
    id serial PRIMARY KEY,
    nome VARCHAR(255) UNIQUE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL
);

-- Inserção de dados de exemplo
INSERT INTO cargo (nome, salario) VALUES
    ('Gerente', 5000.00),
    ('Analista', 3500.00),
    ('Desenvolvedor', 4000.00),
    ('Designer', 3500.00),
    ('Assistente', 3000.00),
    ('Outro', 3000.00);
    
-- Inserir um funcionário na tabela funcionario
INSERT INTO funcionario (matricula, nome, email, senha, cpf, cargo_id)
VALUES ('123456', 'João Silva', 'joao.silva@example.com', 'senha123', '12345678901', 1);