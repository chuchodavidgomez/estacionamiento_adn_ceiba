package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.fabrica.FabricaVehiculo;
import com.ceiba.core.modelo.usuario.Vehiculo;
import com.ceiba.core.servicio.vehiculo.ServicioActualizarVehiculo;

@Component
public class ManejadorActualizarVehiculo implements ManejadorComando<ComandoVehiculo> {

	private final FabricaVehiculo fabricaVehiculo;
	private final ServicioActualizarVehiculo servicioActualizarVehiculo;

	public ManejadorActualizarVehiculo(FabricaVehiculo fabricaVehiculo, ServicioActualizarVehiculo servicioActualizarVehiculo) {
		this.fabricaVehiculo = fabricaVehiculo;
		this.servicioActualizarVehiculo = servicioActualizarVehiculo;
	}

	public void ejecutar(ComandoVehiculo comandoVehiculo) {
		Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
		this.servicioActualizarVehiculo.ejecutar(vehiculo);
	}
}
