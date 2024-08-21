-- drop database canil;

create schema if not exists canil default character set utf8;
show databases;
use canil;


																		-- CRIANDO TABELAS --


create table if not exists novo_cão
(Nome varchar(100), Raça varchar(100), 
Porte varchar(10),
Origem varchar(30), Gênero varchar(20), Idade int);

select * from novo_cão;

------
-- drop table novo_cão;
------

create table if not exists Triagem
(ID int not null auto_increment primary key,
Nome varchar(100), 
Raça varchar(100), Peso varchar(10), 
Porte varchar(10), Origem varchar(50), 
Gênero varchar(20), Idade int, 
Vermifugação varchar(50),
Antirrábica varchar(50), V8 varchar(50), 
Gripe_Canina varchar(50), Leishmaniose varchar(50),
Giárdia varchar(50), data_admissão date, Revacinacao date);
 
 select * from Triagem;
 ------
-- drop table Triagem;
 ------
 
 
 
create table if not exists Cães_raça 
(ID int not null primary key,
Nome varchar(100),
Raça varchar(100), Peso varchar(10),
Porte varchar(10), Origem varchar(30),
 Gênero varchar(20),Idade int,
 data_admissão date, Revacinacao date);
 
 select * from Cães_raça;
 
 -------
 -- drop table Cães_raça;
 -------
 
create table if not exists Cães_viralata
(ID int not null primary key, 
Nome varchar(100), Raça varchar(100),
Peso varchar(10),Porte varchar(10),
Origem varchar(30), Gênero varchar(20),
Idade int, data_admissão date, Revacinacao date);
 
  select * from Cães_viralata;
------
 -- drop table Cães_viralata;
------
 
create table if not exists Clientes 
(ID int not null auto_increment unique primary key, 
Nome varchar(100),
Telefone varchar(50), Endereço varchar(100));
 
 select * from Clientes;
 ----
  -- drop table Clientes;
 ----
 
create table if not exists Vendas 
(ID int not null auto_increment unique primary key, Cliente_id int not null,
Cão_id int not null, Valor varchar(50), 
Data_venda date,
foreign key (Cliente_id) references Clientes(ID),
foreign key (Cão_id) references Cães_raça(ID));
 
 select * from Vendas;
 
 ----
 -- drop table Vendas;
 ----
 
create table if not exists Doações 
(ID int not null auto_increment unique primary key, Cliente_id int not null, 
Cão_id int not null, 
Endereço varchar(100), Telefone varchar(50),
Revacinacao date, Data_doação date,
foreign key (Cliente_id) references Clientes(ID),
foreign key (Cão_id) references Cães_viralata(ID));
 
 select * from doações;
 
 ----
  -- drop table doações;
 ----
																	-- CRIANDO TRIGGERS --
                                                                    
                                                                    
 
 DELIMITER //
 
 Create trigger para_triagem
 before insert on novo_cão
 for each row begin
 insert into Triagem (Nome, Raça, Porte, Origem, Gênero, Idade) values (NEW.Nome, NEW.Raça, NEW.Porte, NEW.Origem, NEW.Gênero, NEW.Idade);
 END//
 
 DELIMITER ;
 
-----
  -- drop trigger para_triagem;
-----

DELIMITER //

  create trigger para_cães
  before update on triagem
  for each row 
  begin
  
  declare condição boolean;
  
  IF (NEW.Raça='Vira-lata') then
  set condição = true;
  
  else
  
  set condição = false;
  
  END IF;
  
  IF condição then 
  
  insert into cães_viralata values (NEW.ID, NEW.Nome, NEW.Raça, NEW.Peso, NEW.Porte, NEW.Origem, NEW.Gênero, NEW.Idade, NEW.data_admissão, NEW.Revacinacao);
  
  else
 
insert into cães_raça values (NEW.ID, NEW.Nome, NEW.Raça, NEW.Peso, NEW.Porte, NEW.Origem, NEW.Gênero, NEW.Idade, NEW.data_admissão, NEW.Revacinacao);

END IF; 

  END//
  
  DELIMITER ;

--
-- drop trigger para_cães;
--



																	-- CRIANDO PROCEDURES --

DELIMITER //

create procedure listar_cães(in tipo varchar(30))
begin

if tipo = 'Vira-lata' then
select * from cães_viralata;

elseif tipo = 'Raça' then
select * from cães_raça;

else 
select * from cães_raça
union all 
select ID, Nome, 'Vira-lata' as Raça, Peso, Porte, Origem, Gênero, Idade, data_admissão, Revacinacao from cães_viralata;

end if;

end // 

DELIMITER ;

----
-- drop procedure listar_cães;
----

DELIMITER //

																		-- CRIANDO FUNCTIONS --

create function quantidade_cães() returns int
begin 
return 
(select count(*) as todos_cães from(
select * from cães_raça
union all 
select * from cães_viralata)
as raça_viralata);

end//

DELIMITER ;

----
-- drop function quantidade_cães;
----

DELIMITER //

create function quantidade_raça() returns int
begin 
return (select count(*) from cães_raça);
end//

DELIMITER ;

----
-- drop function quantidade_raça;
----


DELIMITER //

create function quantidade_viralata() returns int 
begin
return (select count(*) from cães_viralata);
end//

DELIMITER ;


--
-- drop function quantidade_viralata;
--


																	-- POPULANDO AS TABELAS/TESTANDO AS TRIGGERS --
 
 
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values ('Pitico', 'Pinscher', 'P', 'Doado', 'Macho', '1');
insert into novo_cão (Nome,Raça, Porte, Origem, Gênero, Idade) values (null, 'Vira-lata','M','Resgatado','Macho', '4');
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values ('Odin', 'Golden Retriver', 'G', 'Criado', 'Macho', '3');
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values(null,'Vira-lata','P','Resgatado', 'Fêmea', '3');
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values(null,'Vira-lata','M','Resgatado', 'Fêmea', '5');
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values('Lola', 'Shi Tzu', 'P', 'Doado',' Fêmea', '1');
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values('Duque' , 'Rottweiler', 'G', 'Criado', 'Macho', '6');
insert into novo_cão (Nome, Raça, Porte, Origem, Gênero, Idade) values('Paçoca','Vira-lata','M','Doado','Macho','1');
  
select * from novo_cão;

select * from triagem;



update Triagem set Peso = '4kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2025-06-06' where ID = 1;
  
update Triagem set Nome = 'Bidu', Peso = '12kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2025-06-06' where ID = 2;
  
  update Triagem set Peso = '19kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2025-06-06' where ID = 3;
  
  update Triagem set Nome = 'Bolacha', Peso = '5kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2025-08-13' where ID = '4';
  
  update Triagem set Nome = 'Amora', Peso = '11kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2026-04-16' where ID = '5';
  
  update Triagem set Peso = '4kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2024-11-20' where ID = '6';
  
  update Triagem set Peso = '20kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2026-06-25' where ID = '7';
  
  update Triagem set Peso = '12kg', Vermifugação = 'aplicado', Antirrábica = 'aplicado', v8 = 'aplicado', gripe_canina = 'aplicado', 
  leishmaniose  = 'aplicado', Giárdia  = 'aplicado', data_admissão = curdate(), Revacinacao = '2025-06-14' where ID = '8';
  
  
  
  select * from cães_raça;
  select * from cães_viralata;
  
  
insert into Clientes values (null, 'Evandro Nunes', '99246-2106', 'Casa 40 Lote 8 Mansões Pôr do Sol');
insert into Clientes values (null, 'Márcia dos Santos', '99327-8294', 'Casa 4 Lote 15 Jardim Sumaré');
insert into Clientes values (null, 'Otávio Ribeiro Barros', '2311-5434', 'Casa 30 Lote 36 Jardim Progresso');
insert into Clientes values (null, 'Cauã Carvalho Santos', '3286-1632', 'Casa 6 Lote 15 Setor Central');
insert into Clientes values (null, 'Bruno Ferreira Gomes', '8940-2478', 'Rua João Correia Sobrinho, 631');
insert into Clientes values (null, 'Camila Costa Dias', '9171-2058', 'Rua Antônio Carlos Leonel da Silva, 1784');
insert into Clientes values (null, 'Yasmin Cavalcanti Souza', '5205-2147', 'Rua Sessenta e Nove, 1202');

select * from Clientes;

insert into doações values (null, 1, 2, 'Casa 40 Lote 8 Mansões Pôr do Sol','9246-2106','2025-06-06', curdate());
insert into doações values (null, 6, 4, 'Rua Antônio Carlos Leonel da Silva, 1784', '9171-2058', '2025-08-13', curdate());
insert into doações values (null, 7, 8, 'Rua Sessenta e Nove, 1202', '5205-2147', '2025-06-14', curdate());


select * from doações;

insert into vendas values (null, 2, 1,'R$1.700', curdate());
insert into vendas values (null, 3,3,'R$ 400', curdate());
insert into vendas values (null, 4, 6,'R$700', curdate());
insert into vendas values (null, 5, 7, 'R$900', curdate());

select * from vendas;


																	-- CHAMANDO PROCEDURES E FUNCTIONS --

-----

call listar_cães('todos');

-----

select quantidade_cães();
select quantidade_raça();
select quantidade_viralata();

																		-- INNER JOINS --		

select v.ID, cr.Nome, cr.Raça, v.Valor, c.Nome, c.Telefone, v.Data_venda
from Vendas as v
join cães_raça as cr on v.Cão_id = cr.ID
join clientes as c on v.Cliente_id = c.ID;

select d.ID, cv.Nome, c.Nome, c.Telefone, d.Data_doação
from Doações as d
join cães_viralata as cv on d.Cão_id = cv.ID
join clientes as c on d.Cliente_id = c.ID;
