package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoHistorial;
import com.ceiba.core.fabrica.FabricaHistorial;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.servicio.historial.ServicioCrearHistorial;

@Component
public class ManejadorCrearHistorial implements ManejadorComandoRespuesta<ComandoHistorial, ComandoRespuesta<Long>>{
	
	private final FabricaHistorial fabricaHistorial;
	private final ServicioCrearHistorial servicioCrearHistorial;
	
	public ManejadorCrearHistorial(FabricaHistorial fabricaHistorial, ServicioCrearHistorial servicioCrearHistorial) {
		this.fabricaHistorial = fabricaHistorial;
		this.servicioCrearHistorial = servicioCrearHistorial;
	}
	
	public ComandoRespuesta<Long> ejecutar(ComandoHistorial comandoHistorial) {
		Historial historial = this.fabricaHistorial.crear(comandoHistorial);
		return new ComandoRespuesta<>(this.servicioCrearHistorial.ejecutar(historial));
	}
}
