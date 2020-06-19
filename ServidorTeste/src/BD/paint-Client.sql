-- ============================================================== --
-- ====================Criação da base de dados================== --
-- ============================================================== --
CREATE DATABASE IF NOT EXISTS paint;
USE paint;

-- ============================================================== --
-- ================Criação da tabela de desenhos================= --
-- ============================================================== --
CREATE TABLE desenhos (
    ipCliente VARCHAR(250) PRIMARY KEY, 
    idDesenho INT AUTO_INCREMENT NOT NULL,
    dtCriacao VARCHAR(10) NOT NULL,
    dtAtualizacao VARCHAR(10) NOT NULL
);
-- ============================================================== --
-- =================Criação da tabela de figuras================= --
-- ============================================================== --
CREATE TABLE figuras (
    idFigura INT AUTO_INCREMENT PRIMARY KEY,
    strGerador VARCHAR(250) NOT NULL,
	CONSTRAINT fk_id_desenho
        FOREIGN KEY (idDesenho) 
        REFERENCES desenhos (idDesenho)
);