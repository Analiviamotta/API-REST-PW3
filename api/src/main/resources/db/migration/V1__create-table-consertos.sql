create table consertos(

    id bigint not null auto_increment,
    dataentrada varchar(20),
    datasaida varchar(20),
    marca varchar(100),
    modelo varchar(100),
    ano varchar(100),
    nome varchar(100),
    anosexperiencia int,

    primary key(id)
);