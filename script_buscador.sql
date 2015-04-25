CREATE TABLE `avaliacao` (
  `id_avaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(50) DEFAULT NULL,
  `nota` int(11) DEFAULT NULL,
  `data` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_avaliacao`),
  KEY `avaliacao_fk_usuario` (`id_usuario`),
  CONSTRAINT `avaliacao_fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `avaliacao_loja` (
  `id_avaliacao` int(11) NOT NULL,
  `id_loja` int(11) NOT NULL,
  PRIMARY KEY (`id_avaliacao`,`id_loja`),
  KEY `fk_loja` (`id_loja`),
  CONSTRAINT `fk_avaliacao` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`id_avaliacao`) ON DELETE CASCADE,
  CONSTRAINT `avaliacao_loja_fk_loja` FOREIGN KEY (`id_loja`) REFERENCES `loja` (`id_loja`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `avaliacao_produto` (
  `id_avaliacao` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id_avaliacao`,`id_produto`),
  KEY `fk_produto` (`id_produto`),
  CONSTRAINT `avaliacao_produto_fk_avaliacao_produto` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`id_avaliacao`) ON DELETE CASCADE,
  CONSTRAINT `avaliacao_produto_fk_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(30) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `nome_categoria` (`nome_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `loja` (
  `id_loja` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(20) NOT NULL,
  `nome_loja` varchar(50) NOT NULL,
  `localizacao` varchar(100) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `url` varchar(30) NOT NULL,
  `logo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_loja`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `oferta` (
  `id_oferta` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `preco` double NOT NULL,
  `url_oferta` varchar(50) DEFAULT NULL,
  `data_cadastro` time NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_loja` int(11) NOT NULL,
  PRIMARY KEY (`id_oferta`),
  KEY `oferta_fk_produto` (`id_produto`),
  KEY `oferta_fk_loja` (`id_loja`),
  CONSTRAINT `oferta_fk_loja` FOREIGN KEY (`id_loja`) REFERENCES `loja` (`id_loja`) ON DELETE CASCADE,
  CONSTRAINT `oferta_fk_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `num_serie` varchar(50) DEFAULT NULL,
  `nome_produto` varchar(50) NOT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `info_tecnica` varchar(50) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `produto_fk_categoria` (`id_categoria`),
  CONSTRAINT `produto_fk_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `token_fb` varchar(50) DEFAULT NULL,
  `ativo` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8