package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoHistorial;
import com.ceiba.core.fabrica.FabricaHistorial;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.servicio.historial.ServicioActualizarHistorial;

@Component
public class ManejadorActualizarHistorial implements ManejadorComandoRespuesta<ComandoHistorial, ComandoRespuesta<Double>>{
	
	private final FabricaHistorial fabricaHistorial;
	private final ServicioActualizarHistorial servicioActualizarHistorial;
	
	public ManejadorActualizarHistorial(FabricaHistorial fabricaHistorial, ServicioActualizarHistorial servicioActualizarHistorial) {
		this.fabricaHistorial = fabricaHistorial;
		this.servicioActualizarHistorial = servicioActualizarHistorial;
	}
	
	public ComandoRespuesta<Double> ejecutar(ComandoHistorial comandoHistorial) {
		Historial historial = this.fabricaHistorial.crear(comandoHistorial);
		
		return new ComandoRespuesta<>(this.servicioActualizarHistorial.ejecutar(historial));		
	}
}
