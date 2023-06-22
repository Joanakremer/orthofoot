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

insert into medicos (crm, nomeCompleto, dataNasc, sexo) values ('1111','Steffi Devin', '1966-10-08', 'Feminino'),
('1211','Tammara Stanmer', '1960-02-21', 'Feminino'),
('1311','Salomi Sprionghall', '1950-12-14', 'Feminino'),
('1411','Dill Escott', '1960-11-16', 'Masculino'),
('1511','Eleanore Evemy', '1981-10-30', 'Feminino'),
('1611','Madeline Newlin', '1961-01-06', 'Feminino'),
('1711','Arley Parish', '1999-05-03', 'Masculino'),
('1811','Glyn Sawforde', '1985-12-12', 'Feminino'),
('1911','Clemens Burkett', '1997-09-24', 'Masculino'),
('1101','Tobe Dumblton', '1964-02-28', 'Feminino');

insert into paciente (nomeCompleto, cpf, contato, dataNasc, sexo) values ('Rodrique Howgill', '11111111111', '4077720597', '1990-11-25', 'Masculino'),
('Adrian Elegood', '21111111111', '4248113547', '1955-09-27', 'Masculino'),
('Ibby Hurn', '31111111111', '4118610312', '1991-01-24', 'Feminino'),
('Vernice Jirzik', '41111111111', '3137588560', '1962-07-20', 'Feminino'),
('Juditha Ridolfo', '51111111111', '9941832786', '1989-01-14', 'Feminino'),
('Jenifer Wrefford', '61111111111', '1667801254', '1962-08-12', 'Feminino'),
('Erastus Marion', '71111111111', '1814164490', '1988-12-30', 'Masculino'),
('Sula Arend', '81111111111', '7403088050', '2002-10-05', 'Feminino'),
('Jory Pesek', '91111111111', '4062344990', '1953-10-06', 'Masculino'),
('Estevan Durkin', '10111111111', '5304156692', '1963-01-02', 'Masculino');

insert into agendas (data_cons, hora,titulo,nCartao,prontuario,crm) values ('1963-06-08', '23:24','','','1','1111'),
('1990-09-05', '12:20','','','2','1211'),
('1955-10-15', '17:10','','','3','1311'),
('1998-05-13', '19:17','','','4','1411'),
('1968-07-19', '21:39','','','5','1511'),
('1990-03-26', '12:09','','','6','1611'),
('1970-02-22', '16:18','','','7','1711'),
('197-08-16', '18:15','','','8','1811'),
('1954-02-26', '13:56','','','9','1911'),
('1958-01-30', '16:42','','','10','1101');

