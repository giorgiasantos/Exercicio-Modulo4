-- CRIANDO TABELAS

--create table rebeldes (
--id SERIAL primary key,
--nome varchar(255),
--idade int,
--genero varchar(100)
--);

--create table localizacao (
--id SERIAL primary key,
--rebelde_id int,
--nome_base varchar(200),
--local varchar(200),
--FOREIGN key (rebelde_id) references rebeldes (id)
--);

--create table inventario(
--id SERIAL primary key,
--rebelde_id int,
--item_id int,
--item varchar(200),
--FOREIGN key (rebelde_id) references rebeldes (id),
--FOREIGN key (item_id) references itens_compra (id)
--);

--create table itens_compra(
--id serial primary key,
--item varchar(200),
--valor int
--);

-- ALTERANDO TABELA INVENTARIO
--ALTER TABLE inventario ADD quantidade INT;
--ALTER TABLE inventario DROP COLUMN item;

-- ALTERANDO TABELA REBELDES
--alter table rebeldes add localizacao_atual varchar(255);
--alter table rebeldes add column localizacao_id int;
--ALTER TABLE rebeldes
--ADD CONSTRAINT fk_localizacao_id
--FOREIGN KEY (localizacao_id)
--REFERENCES localizacao (id);
--ALTER TABLE rebeldes ADD COLUMN denuncias INT DEFAULT 0;


--ALTERANDO TABELA LOCALIZAÇÃO
--alter table localizacao drop column rebelde_id;

-- EXIBINDO TABELAS
--
--select * from rebeldes;
--select denuncias from rebeldes;
--select * from localizacao;
--select * from itens_compra;
--select * from inventario;
--select * from traidores;

-- INSERINDO DADOS NA TABELA REBELDES
--INSERT into rebeldes (nome, idade, genero) VALUES ('Luke Skywalker', 22, 'masculino');
--UPDATE rebeldes SET localizacao_atual = '3' WHERE id = 1;
--INSERT into rebeldes (nome, idade, genero, localizacao_id) VALUES ('Leia Ogana', 23, 'feminino', 7);
--update rebeldes set localizacao_atual = 1 where id = 1;
--delete from rebeldes where id = 13;

--DELETANTO DADOS DA TABELA REBELDES
--DELETE FROM rebeldes WHERE nome = 'Leia Ogana';
--DELETE FROM rebeldes WHERE nome = 'Ben Kenobi';
--delete from rebeldes where nome = 'Luke Skywalker';
--delete from inventario where rebelde_id = 2;
--delete from inventario where rebelde_id = 1;
--delete from traidores where id_traidor =25;

-- INSERINDO DADOS NA TABELA ITENS_COMPRA
--insert into itens_compra (item,valor) values ('Arma', 100);
--insert into itens_compra (item,valor) values ('Munição', 30);
--insert into itens_compra (item,valor) values ('Água', 5);
--insert into itens_compra (item,valor) values ('Comida', 15);

--INSERINDO VALORES NA TABELA INVENTARIO
--insert into inventario (rebelde_id, item_id, item) values(1, 3, 'Água');
--UPDATE inventario SET quantidade = 1 WHERE id = 1;
--insert into inventario (rebelde_id, item_id, quantidade) values(2, 1, 2);

-- INSERINDO DADOS NA TABELA LOCALIZAÇÃO
--insert into localizacao (nome_base, local) values ('Base Corvo', 'Yavin 4');
--insert into localizacao (nome_base, local) values ('Base Echo', 'Hoth');
--insert into localizacao (nome_base, local) values ('Base em Dantooine', 'Dantooine');
--insert into localizacao (nome_base, local) values ('Base Falcão', 'Yavin 4');
--insert into localizacao (nome_base, local) values ('Estação Echo 3T8', 'Hoth');
--insert into localizacao (nome_base, local) values ('Estação Echo 57', 'Hoth');
--insert into localizacao (nome_base, local) values ('Grande Templo', 'Yavin 4');
--insert into localizacao (nome_base, local) values ('Posto Avançado de Crait', 'Crait');



-- INSERINDO DADOS NA TABELA DE INVENTARIO

-- TESTES INNER JOIN

--select rebeldes.nome, inventario.id, itens_compra.item, inventario.quantidade
--from inventario 
--inner join itens_compra
--on inventario.item_id = itens_compra.id
--inner join rebeldes
--on inventario.rebelde_id = rebeldes.id
--where inventario.rebelde_id = '1';

--select rebeldes.nome, localizacao.nome_base, localizacao."local" 
--from localizacao
--inner join rebeldes 
--on localizacao.id = rebeldes.localizacao_id;



--select itens_compra.item, inventario.item_id, inventario.quantidade
--from inventario
--inner join itens_compra 
--on inventario.item_id = itens_compra.id;

--select rebeldes.nome, localizacao.nome_base
--from localizacao 
--inner join rebeldes 
--on localizacao.id = rebeldes.id;

--select rebeldes.id, rebeldes.nome, itens_compra.item, inventario.quantidade
--from rebeldes
--inner join inventario on rebeldes.id = inventario.id
--inner join itens_compra on inventario.id = itens_compra.id;

--select rebeldes.nome, itens_compra.item, inventario.quantidade 
--from rebeldes 
--inner join inventario on rebeldes.id = inventario.id 
--inner join itens_compra on inventario.id = itens_compra.id 
--WHERE rebeldes.id = 2;

--select inventario.rebelde_id, inventario.item_id, itens_compra.item, inventario.quantidade
--from inventario 
--inner join itens_compra on itens_compra.id = inventario.id;


