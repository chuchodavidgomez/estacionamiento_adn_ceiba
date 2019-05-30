update vehiculo
set 
	placa = :placa, 
	tipo = :tipo, 
	cilindraje = :cilindraje, 
	modelo = :modelo, 
	marca = :marca, 
	fechaIngreso = :fechaIngreso
where placa = :placa