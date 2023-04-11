CREATE database orthofoot;
USE orthofoot;

CREATE table endereco(
cep INT NOT NULL PRIMARY KEY,
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

CREATE table pacientes(
prontuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nomeCompleto VARCHAR(100) NOT NULL,
cpf VARCHAR(45) NOT NULL,
contato VARCHAR(45) NOT NULL,
dataNasc DATE NOT NULL,
convenio VARCHAR (45),
nCarteira VARCHAR (45),
sexo VARCHAR (45),
cep INT NOT NULL,
FOREIGN KEY (cep) REFERENCES endereco(cep)
);

CREATE table agendas(
idconsulta INT NOT NULL PRIMARY KEY,
data_cons DATE NOT NULL,
hora TIME NOT NULL,
titulo VARCHAR(45),
nCartao INT,
prontuario INT NOT NULL,
crm INT NOT NULL,
FOREIGN KEY(prontuario) REFERENCES pacientes(prontuario),
FOREIGN KEY(crm) REFERENCES medicos(crm)
);


insert into usuarios(idusuario,login,senha,tipoUsuario ) values (1, 'Admin', 'Admin', 1);

SELECT * FROM usuarios;
