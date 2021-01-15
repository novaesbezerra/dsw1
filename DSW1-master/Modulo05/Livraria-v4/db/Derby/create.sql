connect 'jdbc:derby:Livraria;create=true;user=root;password=root';

create table Editora(id bigint not null generated always as identity, cnpj varchar(18) not null, nome varchar(256) not null, constraint Editora_PK primary key (id));

create table Livro(id bigint not null generated always as identity, titulo varchar(256) not null, autor varchar(256) not null, ano integer not null, preco float not null, editora_id bigint not null, constraint Livro_PK primary key (id), constraint Editora_FK foreign key (editora_id) references Editora(id));

insert into Editora(cnpj, nome) values  ('55.789.390/0008-99', 'Companhia das Letras');

insert into Editora(cnpj, nome) values ('71.150.470/0001-40', 'Record');

insert into Editora(cnpj, nome) values ('32.106.536/0001-82', 'Objetiva');

insert into Livro(titulo, autor, ano, preco, editora_id) values ('Ensaio sobre a Cegueira', 'José Saramago', 1995, 54.9, 1);

insert into Livro(titulo, autor, ano, preco, editora_id) values  ('Cem anos de Solidão', 'Gabriel Garcia Márquez', 1977, 59.9, 2);

insert into Livro(titulo, autor, ano, preco, editora_id) values ('Diálogos Impossíveis', 'Luis Fernando Verissimo', 2012, 22.9, 3);

create table Usuario(id bigint not null generated always as identity (start with 1, increment by 1), nome varchar(256) not null, login varchar(20) not null unique, senha varchar(64) not null, papel varchar(10), constraint Usuario_PK primary key (id));

insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');

insert into Usuario(nome, login, senha, papel) values ('Usuario', 'user', 'user', 'USER');


create table Compra(id bigint not null generated always as identity, data varchar(10) not null, valor float not null, livro_id bigint not null, usuario_id bigint not null, constraint Compra_PK primary key (id), constraint LIVRO_FK foreign key (livro_id) references Livro(id), constraint USUARIO_FK foreign key (usuario_id) references Usuario(id));

insert into Compra(data, valor, livro_id, usuario_id) values ('30/08/2020', 10.88, 1, 2);

disconnect;

quit;
