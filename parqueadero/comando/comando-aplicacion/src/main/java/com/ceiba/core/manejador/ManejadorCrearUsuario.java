package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.fabrica.FabricaVehiculo;
import com.ceiba.core.modelo.usuario.Vehiculo;
import com.ceiba.core.servicio.usuario.ServicioCrearUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoVehiculo, ComandoRespuesta<Long>> {

	private final FabricaVehiculo fabricaUsuario;
	private final ServicioCrearUsuario servicioCrearUsuario;

	public ManejadorCrearUsuario(FabricaVehiculo fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
		this.fabricaUsuario = fabricaUsuario;
		this.servicioCrearUsuario = servicioCrearUsuario;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoVehiculo comandoUsuario) {
		Vehiculo usuario = this.fabricaUsuario.crear(comandoUsuario);
		return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
	}
}
