create schema vehiculos;

use vehiculos;

create table autos(
	id INT not null auto_increment primary key,
	marca varchar (25),
    modelo varchar (25),
    color varchar (25),
    numero_serie varchar (15)
)