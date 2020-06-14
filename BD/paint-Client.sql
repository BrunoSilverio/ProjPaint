-- ============================================================== --
-- ====================Criação da base de dados================== --
-- ============================================================== --
CREATE DATABASE IF NOT EXISTS paint;
USE paint;

-- ============================================================== --
-- =================Criação da tabela de cliente================= --
-- ============================================================== --
CREATE TABLE client (
    idClient INT AUTO_INCREMENT PRIMARY KEY, 
    drawName VARCHAR(100) NOT NULL,
    startDate DATETIME NOT NULL,
    lastSave DATETIME NOT NULL,
    drawContent VARCHAR(250) NOT NULL
);