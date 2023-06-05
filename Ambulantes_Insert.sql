create database Ambulantes;
use Ambulantes;
/*drop database Ambulantes;*/

create table Vendedor(
id_vendedor int primary key auto_increment,
nome_vendedor varchar(50),
cpf_vendedor varchar(15),
celular_vendedor varchar(15),
cidade_vendedor varchar(50),
estado_vendedor varchar(02),
forma_pagamento varchar(100),
email_vendedor varchar(50),
senha_vendedor varchar(50),
imagem_vendedor varchar(100));

create table Clientes(
id_cliente int primary key auto_increment,
nome_cliente varchar(50),
cpf_cliente varchar(15),
celular_cliente varchar(15),
cidade_cliente varchar(50),
estado_cliente varchar(02),
email_cliente varchar(50),
senha_cliente varchar(50));

create table Localiza_Vendedor(
id_localiza int primary key auto_increment,
id_vendedor int,
id_cliente int,
constraint fk_locavend foreign key(id_vendedor) references Vendedor(id_vendedor),
constraint fk_locaClien foreign key(id_cliente) references Clientes(id_cliente));

create table Categorias(
id_categoria int primary key auto_increment,
nome_categoria varchar(50),
descricao_categoria varchar(100));

create table Produtos(
id_produto int primary key auto_increment,
nome_produto varchar(50),
preco_produto float,
descricao_produto varchar(100),
imagem_produto varchar(100),
id_categoria int,
id_vendedor int,
constraint fk_prodcat foreign key(id_categoria) references Categorias(id_categoria),
constraint fk_prodvend foreign key(id_vendedor) references Vendedor(id_vendedor));


/*select * from Clientes;
select * from vendedor;
select * from produtos;
select * from localiza_vendedor;*/

/*delete from produtos;
delete from Clientes;
delete from Vendedor;*/


insert into categorias(nome_categoria, descricao_categoria) values ("Salgado", "Coxinha, Pizza, Esfirra"), ("Doce", "Doce"),
("Bebida", "Agua, Sucos, Refrigerantes"), ("Bijuteria", "Colares, pulseiras");

insert into clientes(nome_cliente, cpf_cliente, celular_cliente, cidade_cliente, estado_cliente, email_cliente, senha_cliente) 
values ('Cliente', '000.000.000-00', '(00) 00000-0000', 'teste', 'tt', 'teste', 'teste');

insert into vendedor(nome_vendedor, cpf_vendedor, celular_vendedor, cidade_vendedor, estado_vendedor, forma_pagamento, email_vendedor, senha_vendedor, imagem_vendedor) values
('Sr. Camelo', '999.999.999-99', '(44) 44444-4444', 'teste', 'tt', 'DinheiroDebitoCreditoPix', 'teste', 'teste', 'src/Banco_img/1_banner.png'),
('Vendedor 2', '888.888.888-88', '(88) 88888-8888', 'teste', 'tt', 'DinheiroPix', 'teste', 'teste', 'src/Banco_img/2_banner.png'),
('Vendedor 3', '777.777.777-77', '(77) 77777-7777', 'teste', 'tt', 'DebitoCreditoPix', 'teste', 'teste', 'src/Banco_img/3_banner.png'),
('Vendedor 4', '666.666.666-66', '(66) 66666-6666', 'teste', 'tt', 'Pix', 'teste', 'teste', 'src/Banco_img/4_banner.png');

insert into produtos(nome_produto, preco_produto, descricao_produto, imagem_produto, id_categoria, id_vendedor) values
('Esfirra', 8.50, 'Esfirra de Carne com tomate', 'src/Banco_img/1_1_Prod.png', 1, 1),
('Coxinha', 7.00, 'Coxinha de Frango Basico', 'src/Banco_img/1_2_Prod.png', 1, 1),
('Hamburguer', 15.20, 'Hamburguer camada dupla com bacon e cheddar', 'src/Banco_img/1_3_Prod.png', 1, 1),
('Maca do Amor', 3.35, 'Maca do Amor a unidade sai 3.35', 'src/Banco_img/2_4_Prod.png', 2, 2),
('Coca-Cola', 4.50, 'Coca em lata 350 ml Gelada', 'src/Banco_img/3_5_Prod.png', 3, 3),
('Guarana Antartica', 5.00, 'Guarana Antartica Lata 350 Gelada', 'src/Banco_img/3_6_Prod.png', 3, 3),
('Agua Minalba', 3.50, 'Agua minalba garrafa pet 510ml Sem gas', 'src/Banco_img/3_7_Prod.png', 3, 3),
('Pulseira Azul', 26.00, 'Pulseira Azul artesanal', 'src/Banco_img/4_8_Prod.png', 4, 4);


