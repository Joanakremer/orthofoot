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

insert into medicos (crm, nomeCompleto, dataNasc, sexo) values ('1111','Steffi Devin', '08/10/1966', 'Feminino'),
('1211','Tammara Stanmer', '04/02/1960', 'Feminino'),
('1311','Salomi Sprionghall', '15/12/1950', 'Feminino'),
('1411','Dill Escott', '18/11/1960', 'Masculino'),
('1511','Eleanore Evemy', '24/10/1981', 'Feminino'),
('1611','Madeline Newlin', '10/01/1961', 'Feminino'),
('1711','Arley Parish', '22/05/1999', 'Masculino'),
('1811','Glyn Sawforde', '05/12/1985', 'Feminino'),
('1911','Clemens Burkett', '03/09/1997', 'Masculino'),
('1101','Tobe Dumblton', '22/02/1964', 'Feminino');

insert into paciente (nomeCompleto, cpf, contato, dataNasc, sexo) values ('Rodrique Howgill', '11111111111', '4077720597', '21/11/1990', 'Masculino'),
('Adrian Elegood', '21111111111', '4248113547', '23/09/1955', 'Masculino'),
('Ibby Hurn', '31111111111', '4118610312', '02/01/1991', 'Feminino'),
('Vernice Jirzik', '41111111111', '3137588560', '05/07/1962', 'Feminino'),
('Juditha Ridolfo', '51111111111', '9941832786', '02/01/1989', 'Feminino'),
('Jenifer Wrefford', '61111111111', '1667801254', '28/08/1962', 'Feminino'),
('Erastus Marion', '71111111111', '1814164490', '17/12/1988', 'Masculino'),
('Sula Arend', '81111111111', '7403088050', '24/10/2002', 'Feminino'),
('Jory Pesek', '91111111111', '4062344990', '07/10/1953', 'Masculino'),
('Estevan Durkin', '10111111111', '5304156692', '10/01/1963', 'Masculino');

insert into agendas (data_cons, hora,titulo,nCartao,prontuario,crm) values ('08/06/1963', '23:24','','','1','1111'),
('26/09/1990', '12:20','','','2','1211'),
('21/10/1955', '17:10','','','3','1311'),
('11/05/1998', '19:17','','','4','1411'),
('24/07/1968', '21:39','','','5','1511'),
('07/03/1990', '12:09','','','6','1611'),
('10/02/1970', '16:18','','','7','1711'),
('15/08/1975', '18:15','','','8','1811'),
('27/02/1954', '13:56','','','9','1911'),
('07/01/1958', '16:42','','','10','1101');

