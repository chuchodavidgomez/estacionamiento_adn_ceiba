package com.ceiba.core.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.core.historial.ComandoHistorial;
import com.ceiba.core.modelo.historial.Historial;
@Component
public class FabricaHistorial {

	public Historial crear(ComandoHistorial comandoHistorial) {
		return new Historial(
				 comandoHistorial.getId(),
				 comandoHistorial.getPlacaVehiculo(),
				 comandoHistorial.getFechaIngreso(),
				 comandoHistorial.getFechaSalida(),
				 comandoHistorial.getPago());	
	}
}
