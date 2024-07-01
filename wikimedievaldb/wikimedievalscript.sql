create database wikimedieval;
use wikimedieval;

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario ENUM('admin', 'usuario') NOT NULL
);

-- Inserir um administrador
INSERT INTO Usuarios (nome, email, senha, tipo_usuario) VALUES 
('Admin', 'admin@wikimedieval.com', 'admin123', 'admin');

-- Inserir um usuário comum
INSERT INTO Usuarios (nome, email, senha, tipo_usuario) VALUES 
('Usuario', 'usuario@wikimedieval.com', 'usuario123', 'usuario');

use wikimedieval;
-- Atualizar o email do administrador
UPDATE Usuarios
SET email = 'admin'
WHERE email = 'admin@wikimedieval.com';

-- Atualizar o email do usuário comum
UPDATE Usuarios
SET email = 'usuario'
WHERE email = 'usuario@wikimedieval.com';

select * from Usuarios;


use wikimedieval;

CREATE TABLE midias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    tipo ENUM('Livro', 'Filme', 'Videogame') NOT NULL,
    descricao TEXT,
    autor_diretor VARCHAR(255),
    ano_lancamento INT
);

INSERT INTO midias (titulo, tipo, descricao, autor_diretor, ano_lancamento) VALUES
('O Nome da Rosa', 'Filme', 'Adaptação do romance de Umberto Eco sobre assassinatos em um mosteiro beneditino medieval.', 'Jean-Jacques Annaud', 1986),
('Coração Valente', 'Filme', 'A história de William Wallace e sua luta pela independência da Escócia.', 'Mel Gibson', 1995),
('Excalibur', 'Filme', 'A lenda do Rei Arthur e os Cavaleiros da Távola Redonda.', 'John Boorman', 1981),
('O Senhor dos Anéis: A Sociedade do Anel', 'Filme', 'A primeira parte da épica trilogia de fantasia baseada nos livros de J.R.R. Tolkien.', 'Peter Jackson', 2001),
('Monty Python em Busca do Cálice Sagrado', 'Filme', 'Uma comédia satírica sobre a lenda do Rei Arthur.', 'Terry Gilliam, Terry Jones', 1975);

INSERT INTO midias (titulo, tipo, descricao, autor_diretor, ano_lancamento) VALUES
('O Nome da Rosa', 'Livro', 'Romance histórico e de mistério ambientado em um mosteiro beneditino na Itália medieval.', 'Umberto Eco', 1980),
('As Crônicas de Artur', 'Livro', 'Trilogia que reconta a lenda do Rei Arthur e os Cavaleiros da Távola Redonda.', 'Bernard Cornwell', 1995),
('Os Pilares da Terra', 'Livro', 'História épica da construção de uma catedral na Inglaterra do século XII.', 'Ken Follett', 1989),
('A Canção de Rolando', 'Livro', 'Um dos mais antigos e famosos poemas épicos medievais da literatura francesa.', 'Desconhecido', 1098),
('Ivanhoé', 'Livro', 'Romance histórico ambientado na Inglaterra do século XII, com cavaleiros, torneios e batalhas.', 'Walter Scott', 1819);

INSERT INTO midias (titulo, tipo, descricao, autor_diretor, ano_lancamento) VALUES
('The Witcher 3: Wild Hunt', 'Videogame', 'RPG de ação em um mundo de fantasia medieval baseado na série de livros The Witcher.', 'CD Projekt Red', 2015),
('Dark Souls', 'Videogame', 'Jogo de RPG de ação conhecido por sua dificuldade, ambientado em um mundo de fantasia sombria.', 'FromSoftware', 2011),
('Medieval II: Total War', 'Videogame', 'Jogo de estratégia em tempo real ambientado na Europa medieval.', 'Creative Assembly', 2006),
('The Elder Scrolls V: Skyrim', 'Videogame', 'RPG de mundo aberto ambientado em um mundo de fantasia com forte influência medieval.', 'Bethesda Game Studios', 2011),
('Kingdom Come: Deliverance', 'Videogame', 'RPG de ação realista ambientado na Boêmia medieval.', 'Warhorse Studios', 2018);