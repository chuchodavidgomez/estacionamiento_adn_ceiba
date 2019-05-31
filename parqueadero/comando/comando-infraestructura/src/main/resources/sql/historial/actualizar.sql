update historial
set  
	placaVehiculo = :placaVehiculo, 
	fechaIngreso = :fechaIngreso, 
	fechaSalida = :fechaSalida, 	
	pago = :pago
where id = :id