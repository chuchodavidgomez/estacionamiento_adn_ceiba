package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoHistorial;
import com.ceiba.core.fabrica.FabricaHistorial;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.servicio.historial.ServicioActualizarHistorial;

@Component
public class ManejadorActualizarHistorial implements ManejadorComando<ComandoHistorial>{
	
	private final FabricaHistorial fabricaHistorial;
	private final ServicioActualizarHistorial servicioActualizarHistorial;
	
	public ManejadorActualizarHistorial(FabricaHistorial fabricaHistorial, ServicioActualizarHistorial servicioActualizarHistorial) {
		this.fabricaHistorial = fabricaHistorial;
		this.servicioActualizarHistorial = servicioActualizarHistorial;
	}
	
	public void ejecutar(ComandoHistorial comandoHistorial) {
		Historial historial = this.fabricaHistorial.crear(comandoHistorial);
		this.servicioActualizarHistorial.ejecutar(historial);		
	}
}
