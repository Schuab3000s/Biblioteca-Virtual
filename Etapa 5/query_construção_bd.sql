create database biblioteca;
use biblioteca;

create table genero(
id_genero int not null auto_increment,
genero varchar(45),
primary key (id_genero)
);

create table cliente(
id_cliente int not null auto_increment,
nome varchar(45),
cpf varchar(45),
telefone varchar(45),
endereco varchar(45),
primary key (id_cliente)
);

create table usuario(
id_usuario int not null auto_increment,
login varchar(45),
senha varchar(45),
primary key (id_usuario)
);

create table autor(
id_autor int not null auto_increment,
nome varchar(45),
primary key (id_autor)
);

create table livro(
id_livro int not null auto_increment,
nome VARCHAR(45),
data_lancamento DATE,
genero_id INT,
autor_id INT,
primary key (id_livro),
foreign key (autor_id) references autor(id_autor),
foreign key (genero_id) references genero(id_genero)
);

create table emprestimo(
id_emprestimo int not null auto_increment,
data_pedido date,
livro_id int,
cliente_id int,
primary key (id_emprestimo),
foreign key (livro_id) references livro(id_livro),
foreign key (cliente_id) references cliente(id_cliente)
);