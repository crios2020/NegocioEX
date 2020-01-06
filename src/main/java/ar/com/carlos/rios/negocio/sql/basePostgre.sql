/*
    url default: jdbc:postgresql://localhost:5432/ default url
    user default: postgres
    pass default: postgres
*/

-- drop schema if exists negocioX;
-- create schema negocioX;
-- use negocioX;
-- SET search_path = negocioX;
set schema 'negocioX';
drop table if exists negocioX.detalles;
drop table if exists negocioX.articulos;
drop table if exists negocioX.facturas;
drop table if exists negocioX.clientes;
drop type if exists negocioX.tipoDocumento;
drop type if exists negocioX.letra;
create type negocioX.tipoDocumento as enum('DNI','LC','LE','PASAPORTE');
create type negocioX.letra as enum('A','B','C');
create table negocioX.clientes(
    id serial primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    tipoDocumento negocioX.tipoDocumento,
    numeroDocumento char(8),
    direccion varchar(50)
);
create table negocioX.facturas(
    letra negocioX.letra,
    numero int check(numero >=0),     -- no se encuentra el modificador unsigned
    fecha date,
    monto float8 check(monto >=0),   -- float 8 es equivalente a double
    idCliente int not null,
    primary key(letra,numero)
);
create table negocioX.articulos(
    id serial primary key,
    descripcion varchar(50) not null,
    costo float,
    precio float,
    stock int check(stock >=0),
    stockMin int check(stockMin >=0),
    stockMax int check(stockMax >=0)
);
create table negocioX.detalles(
    letra negocioX.letra,
    numero int not null,
    idArticulo int not null,
    primary key(letra,numero,idArticulo)
);
alter table negocioX.clientes
    add constraint U_Clientes_Documento
    unique(tipoDocumento,numeroDocumento);
alter table negocioX.facturas
    add constraint FK_Facturas_Clientes
    foreign key(idCliente)
    references negocioX.clientes(id);
alter table negocioX.detalles
    add constraint FK_Detalles_Facturas
    foreign key(letra,numero)
    references negocioX.facturas(letra,numero);
alter table negocioX.detalles
    add constraint FK_Detalles_Articulos
    foreign key(idArticulo)
    references negocioX.articulos(id);
