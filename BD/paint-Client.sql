-- ============================================================== --
-- ====================Criação da base de dados================== --
-- ============================================================== --
CREATE DATABASE IF NOT EXISTS paint;
USE paint;

-- ============================================================== --
-- =================Criação da tabela de cliente================= --
-- ============================================================== --
CREATE TABLE clientes (
    idCliente INT AUTO_INCREMENT PRIMARY KEY, 
    nomeDesenho VARCHAR(100) NOT NULL,
    dataCriacao DATETIME NOT NULL,
    dataUltimaAtualizacao DATETIME NOT NULL,
    conteudo VARCHAR(250) NOT NULL
);