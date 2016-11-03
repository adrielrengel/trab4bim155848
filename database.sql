/*
*	Esse arquivo será relacionado com o banco de dados da aplicação
*	Vai conter o banco,  a tabela e um insert de conteudo para a tabela
*	Eles serão comentados a medida que forem aparecendo
*	@author - Adriel Rengel
*/

/*  Esse comando vai criar o banco de dados que será usado no trabalho */
CREATE DATABASE db_estudo_java; 

/*  Esse comando vai criar a tabela de usuarios
*	Cada usuario vai possuir tres atributos, o Login e a senha
*	E cada um vai possuir uma ID para identificacao
*/
CREATE TABLE db_estudo_java.tb_usuario(
 
	id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DO USUÁRIO',
	ds_login   VARCHAR(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
	ds_senha   VARCHAR(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA'   	
 
);

/*  Esse comando vai criar a tabela de pessoas
*	Cada usupessoa  vai possuir alguns atributos como ID, nome, sexo
*	data em que foi realizado o cadastro, email, endereco, origem do cadastro
*	e a ID do usuario que cadastrou o individuo
*/
CREATE TABLE db_estudo_java.tb_pessoa(
 
    id_pessoa           INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DA PESSOA',
    nm_pessoa           VARCHAR(70)  NOT NULL COMMENT 'NOME DA PESSOA',
    fl_sexo	        CHAR(1)	     NOT NULL COMMENT 'INFORMAR M OU F',
    dt_cadastro         DATETIME     NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
    ds_email	        VARCHAR(80)  NOT NULL COMMENT 'EMAIL DA PESSOA',
    ds_endereco         VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
    fl_origemCadastro   CHAR(1)	     NOT NULL COMMENT 'ORIGEM DO CADASTRO (I) = INPUT OU (X) = XML',	
    id_usuario_cadastro	INT	     NOT NULL COMMENT  'USUÁRIO LOGADO QUE CADASTROU A PESSOA'
 
);


/*	Esse comando vai criar a chave estrangeira na tabela de pessoa que faz referencia ao usuario */
 ALTER TABLE db_estudo_java.tb_pessoa ADD FOREIGN KEY (id_usuario_cadastro) REFERENCES db_estudo_java.tb_usuario(id_usuario);

/* 	Esse comando vai criar uma tupla com informacoes na tabela usuario*/
INSERT INTO db_estudo_java.tb_usuario (ds_login,ds_senha) VALUES('admin','123456');
