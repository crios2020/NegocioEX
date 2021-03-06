/*
    url="jdbc:sqlite:/base.db";
    /base.db hace referencia a una ruta absoluta del sistema no del proyecto
*/
drop table if exists detalles;
drop table if exists facturas;
drop table if exists clientes;
drop table if exists articulos;
create table clientes(
    id integer primary key, -- el campo integer y primary key actua como auto_increment
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    tipoDocumento text CHECK(tipoDocumento IN ('DNI','LC','LE','PASAPORTE')) not null,
    -- las check constraint son internas, no se pueden declarar externamente en SQLite
    numeroDocumento char(8),
    direccion varchar(50)
);
create table facturas(
    letra text CHECK(letra in ('A','B','C')),
    numero int unsigned,
    fecha date,
    monto double,
    idCliente int not null references clienes(id),
    primary key(letra,numero)
);
create table articulos(
    id integer primary key,
    descripcion varchar(50) not null,
    costo float,
    precio float,
    stock int unsigned,
    stockMin int unsigned,
    stockMax int unsigned
);
create table detalles(
    letra text CHECK(letra in ('A','B','C')) not null references facturas(letra),
    numero int unsigned not null references facturas(numero),
    idArticulo int,
    primary key(letra,numero,idArticulo)
);
