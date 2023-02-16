CREATE database orthofoot;
USE orthofoot;

CREATE table enderecos(
cep INT NOT NULL PRIMARY KEY,
rua VARCHAR(100)NOT NULL,
cidade VARCHAR(100)NOT NULL,
estado VARCHAR(100)NOT NULL
);

CREATE table usuarios(
idusuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
login VARCHAR (45) NOT NULL,
senha VARCHAR(45) NOT NULL,
tipo_usuario INT NOT NULL
);

CREATE table medicos(
crm INT NOT NULL PRIMARY KEY,
nome_completo VARCHAR(100) NOT NULL,
data_nasc DATE NOT NULL,
sexo VARCHAR(20) 
);

CREATE table pacientes(
prontuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome_completo VARCHAR(100) NOT NULL,
cpf VARCHAR(45) NOT NULL,
contato VARCHAR(45) NOT NULL,
data_nasc DATE NOT NULL,
convenio VARCHAR (45),
n_carteira VARCHAR (45),
sexo VARCHAR (45),
cep INT NOT NULL,
FOREIGN KEY (cep) REFERENCES enderecos(cep)
);

CREATE table agendas(
idconsulta INT NOT NULL PRIMARY KEY,
data_cons DATE NOT NULL,
hora TIME NOT NULL,
titulo VARCHAR(45),
n_cartao INT,
prontuario INT NOT NULL,
crm INT NOT NULL,
FOREIGN KEY(prontuario) REFERENCES pacientes(prontuario),
FOREIGN KEY(crm) REFERENCES medicos(crm)
);


insert into enderecos(cep, rua, cidade, estado) values ('101', 'Pass', 'Staten Island', 'NY'),
('500', 'Trail', 'Brooklyn', 'NY'),
('1513', 'Hill', 'Staten Island', 'NY'),
('4749', 'Drive', 'Rochester', 'NY'),
('09794', 'Crossing', 'Jamaica', 'NY'),
('246', 'Circle', 'New York City', 'NY'),
('42', 'Terrace', 'New York City', 'NY'),
('878', 'Parkway', 'Bronx', 'NY'),
('9', 'Way', 'Brooklyn', 'NY');

SELECT * FROM enderecos;
