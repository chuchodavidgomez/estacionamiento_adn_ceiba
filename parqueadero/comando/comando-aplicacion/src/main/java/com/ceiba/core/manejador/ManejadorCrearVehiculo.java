package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.fabrica.FabricaVehiculo;
import com.ceiba.core.modelo.usuario.Vehiculo;
import com.ceiba.core.servicio.vehiculo.ServicioCrearVehiculo;

@Component
public class ManejadorCrearVehiculo implements ManejadorComando<ComandoVehiculo> {

	private final FabricaVehiculo fabricaVehiculo;
	private final ServicioCrearVehiculo servicioCrearVehiculo;

	public ManejadorCrearVehiculo(FabricaVehiculo fabricaVehiculo, ServicioCrearVehiculo servicioCrearVehiculo) {
		this.fabricaVehiculo = fabricaVehiculo;
		this.servicioCrearVehiculo = servicioCrearVehiculo;
	}

	public void ejecutar(ComandoVehiculo comandoVehiculo) {
		Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
}
