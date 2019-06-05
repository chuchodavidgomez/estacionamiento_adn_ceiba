SELECT count(1) FROM vehiculo
INNER JOIN historial ON vehiculo.placa = historial.placaVehiculo 
WHERE tipo = :tipo AND pago IS NULL