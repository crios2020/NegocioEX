-- drop database if exists negocioX;
-- create database negocioX;
-- use negocioX;

/*
remotemysql.com

Username: dS8cEP1rPM

Database name: dS8cEP1rPM

Password: y0fG9478g0

Server: remotemysql.com

Port: 3306
*/


drop table if exists detalles;
drop table if exists facturas;
drop table if exists clientes;
drop table if exists articulos;
create table clientes(
    id int auto_increment primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    tipoDocumento enum('DNI','LC','LE','PASAPORTE'),
    numeroDocumento char(8),
    direccion varchar(50)
);
create table facturas(
    letra enum('A','B','C'),
    numero int unsigned,
    fecha date,
    monto double,
    idCliente int not null,
    primary key(letra,numero)
);
create table articulos(
    id int auto_increment primary key,
    descripcion varchar(50) not null,
    costo float,
    precio float,
    stock int unsigned,
    stockMin int unsigned,
    stockMax int unsigned
);
create table detalles(
    letra enum('A','B','C') not null,
    numero int unsigned not null,
    idArticulo int not null,
    primary key(letra,numero,idArticulo)
);
alter table clientes
    add constraint U_Clientes_Documento
    unique(tipoDocumento,numeroDocumento);
alter table facturas
    add constraint FK_Facturas_Clientes
    foreign key(idCliente)
    references clientes(id);
alter table detalles
    add constraint FK_Detalles_Facturas
    foreign key(letra,numero)
    references facturas(letra,numero);
alter table detalles
    add constraint FK_Detalles_Articulos
    foreign key(idArticulo)
    references articulos(id);