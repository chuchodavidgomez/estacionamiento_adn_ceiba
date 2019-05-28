package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.fabrica.FabricaVehiculo;
import com.ceiba.core.modelo.usuario.Vehiculo;
import com.ceiba.core.servicio.usuario.ServicioActualizarUsuario;

@Component
public class ManejadorActualizarUsuario implements ManejadorComando<ComandoVehiculo> {

	private final FabricaVehiculo fabricaUsuario;
	private final ServicioActualizarUsuario servicioActualizarUsuario;

	public ManejadorActualizarUsuario(FabricaVehiculo fabricaUsuario, ServicioActualizarUsuario servicioActualizarUsuario) {
		this.fabricaUsuario = fabricaUsuario;
		this.servicioActualizarUsuario = servicioActualizarUsuario;
	}

	public void ejecutar(ComandoVehiculo comandoUsuario) {
		Vehiculo usuario = this.fabricaUsuario.crear(comandoUsuario);
		this.servicioActualizarUsuario.ejecutar(usuario);
	}
}
