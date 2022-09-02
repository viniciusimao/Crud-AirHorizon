CRUD do site Airhorizon

Fiz um CRUD Simples para o meu banco de dados com todas as suas funções pedidas



Na hora dos testes tudo correu como deveria


Sobre o diagrama de Classes eu não coloquei os métodos gerados dos privates, acredito que não precisasse deles mas caso eu tenha errado desculpas


o código usado no bd para crias as tabelas e seus relacionamentos 



CREATE TABLE Cliente (
    idCli int PRIMARY KEY,
    nomeCli varchar(40),
    tellCli int,
    emailCli varchar(40)
);

CREATE TABLE Voos (
    idVoos int PRIMARY KEY,
    localVoos varchar(40),
    fk_Cliente_idCli int
);
 
ALTER TABLE Voos ADD CONSTRAINT FK_Voos_2
    FOREIGN KEY (fk_Cliente_idCli)
    REFERENCES Cliente (idCli)
    ON DELETE RESTRICT;
