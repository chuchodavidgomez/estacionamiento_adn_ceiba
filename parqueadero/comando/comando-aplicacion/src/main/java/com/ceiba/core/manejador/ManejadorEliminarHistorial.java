package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.servicio.historial.ServicioEliminarHistorial;

@Component
public class ManejadorEliminarHistorial implements ManejadorComando<Long>{
	
	private final ServicioEliminarHistorial servicioEliminarHistorial;
	
	public ManejadorEliminarHistorial(ServicioEliminarHistorial servicioEliminarHistorial) {
		this.servicioEliminarHistorial = servicioEliminarHistorial;
	}
		
	public void ejecutar(Long id) {		
		servicioEliminarHistorial.ejecutar(id);		
	}
}
