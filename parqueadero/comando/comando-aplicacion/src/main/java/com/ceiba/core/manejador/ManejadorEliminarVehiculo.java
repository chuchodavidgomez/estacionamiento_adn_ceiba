package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.servicio.vehiculo.ServicioEliminarVehiculo;

@Component
public class ManejadorEliminarVehiculo implements ManejadorComando<String> {

	private final ServicioEliminarVehiculo servicioEliminarUsuario;

	public ManejadorEliminarVehiculo(ServicioEliminarVehiculo servicioEliminarUsuario) {
		this.servicioEliminarUsuario = servicioEliminarUsuario;
	}

	public void ejecutar(String placa) {
		this.servicioEliminarUsuario.ejecutar(placa);

	}
}
