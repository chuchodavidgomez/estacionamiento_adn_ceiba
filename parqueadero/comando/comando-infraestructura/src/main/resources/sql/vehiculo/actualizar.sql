update vehiculo
set 
	placa = :placa, 
	tipo = :tipo, 
	cilindraje = :cilindraje, 
	modelo = :modelo, 
	marca = :marca	
where placa = :objectkey