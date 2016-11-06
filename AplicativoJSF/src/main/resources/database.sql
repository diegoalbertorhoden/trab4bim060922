--Arquivo criado por Diego Rhoden às 14:55 do dia 05/11/2016 com os comandos para criação da nossa base de dados

--Comando que cria o banco de dados
CREATE DATABASE db_estudo_java;
--Comando que cria uma das tabelas, a tb_usuario
CREATE TABLE db_estudo_java.tb_usuario(
--Campo da tabela do tipo int com auto incrementação, sendo chave primária desta tabela e não nulo
	id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DO USUÁRIO',
--Os dois campos abaixo sao do tipo varchar(texto) com limitação de 30 caracteres e não podem ser nulos
	ds_login   VARCHAR(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
	ds_senha   VARCHAR(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA'   	
 
);
--Criação da tabela tb_pessoa
CREATE TABLE db_estudo_java.tb_pessoa(
--Campo da tabela do tipo int com auto incrementação, sendo chave primária desta tabela e não nulo
    id_pessoa           INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DA PESSOA',
--Campo texto com 70 caracteres e não nulo
    nm_pessoa           VARCHAR(70)  NOT NULL COMMENT 'NOME DA PESSOA',
--campo com um caracter: M ou F não podendo ser nulo
    fl_sexo	        CHAR(1)	     NOT NULL COMMENT 'INFORMAR M OU F',
--campo de datahora    
    dt_cadastro         DATETIME     NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
--campo de email com limite de 80 caracteres e nao nulo    
    ds_email	        VARCHAR(80)  NOT NULL COMMENT 'EMAIL DA PESSOA',
--campo de endereco com 200 caracteres e nao nulo
    ds_endereco         VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
--campo origem do cadastro nao nulo com apenas um caractere i ou x
    fl_origemCadastro   CHAR(1)	     NOT NULL COMMENT 'ORIGEM DO CADASTRO (I) = INPUT OU (X) = XML',	
--campo que será linkado posteriormente com o cadastro de usuario logado
    id_usuario_cadastro	INT	     NOT NULL COMMENT  'USUÁRIO LOGADO QUE CADASTROU A PESSOA'
 
);
--comando de alteracao para chave estrangeira na tabela pessoa do campo id_usuario_cadastro referenciando o id_usuario da tb_usuario
ALTER TABLE db_estudo_java.tb_pessoa ADD FOREIGN KEY (id_usuario_cadastro) REFERENCES db_estudo_java.tb_usuario(id_usuario);
--insercao de informacoes de login e senha
INSERT INTO db_estudo_java.tb_usuario (ds_login,ds_senha) VALUES('admin','123456');