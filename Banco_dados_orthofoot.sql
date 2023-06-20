CREATE DATABASE IF NOT EXISTS orthofoot;
USE orthofoot;

CREATE table endereco(
cep bigint NOT NULL PRIMARY KEY,
rua VARCHAR(100)NOT NULL,
cidade VARCHAR(100)NOT NULL,
estado VARCHAR(100)NOT NULL
);

CREATE table usuarios(
idusuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
login VARCHAR (45) NOT NULL,
senha VARCHAR(45) NOT NULL,
tipoUsuario INT NOT NULL
);

CREATE table medicos(
crm INT NOT NULL PRIMARY KEY,
nomeCompleto VARCHAR(100) NOT NULL,
dataNasc DATE NOT NULL,
sexo VARCHAR(20) 
);

CREATE table paciente(
prontuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomeCompleto VARCHAR(100) NOT NULL,
cpf VARCHAR(45) NOT NULL,
contato VARCHAR(45) NOT NULL,
dataNasc DATE NOT NULL,
convenio VARCHAR (45),
nCarteira VARCHAR (45),
sexo VARCHAR (45)
);

CREATE table agendas(
idconsulta INT NOT NULL PRIMARY KEY auto_increment,
data_cons DATE NOT NULL,
hora TIME NOT NULL,
titulo VARCHAR(45),
nCartao INT,
prontuario INT NOT NULL,
crm INT NOT NULL,
FOREIGN KEY(prontuario) REFERENCES paciente(prontuario),
FOREIGN KEY(crm) REFERENCES medicos(crm)
);

ALTER TABLE `orthofoot`.`agendas` 
CHANGE COLUMN `idconsulta` `idconsulta` INT NOT NULL AUTO_INCREMENT ;


insert into usuarios(idusuario,login,senha,tipoUsuario ) values (1, 'Admin', 'Admin', 1);

SELECT * FROM usuarios;
