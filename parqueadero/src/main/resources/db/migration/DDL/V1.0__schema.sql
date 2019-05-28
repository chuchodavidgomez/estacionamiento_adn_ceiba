create table vehiculo (
	placa varchar(100) not null,
	tipo varchar(100) not null,
	cilindraje int(11) not null,
	modelo varchar(100) not null,
	marca varchar(100) not null,
	fechaIngreso datetime null,
  	primary key (placa)
);

insert into vehiculo(placa,tipo,cilindraje,modelo,marca,fechaIngreso) values('aaa000','carro',0,'6','renault',now());