package com.ceiba.core.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.repositorio.RepositorioVehiculo;
import com.ceiba.core.servicio.vehiculo.ServicioActualizarVehiculo;
import com.ceiba.core.servicio.vehiculo.ServicioCrearVehiculo;
import com.ceiba.core.servicio.vehiculo.ServicioEliminarVehiculo;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}

	@Bean
	public ServicioEliminarVehiculo servicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioEliminarVehiculo(repositorioVehiculo);
	}
	
	@Bean
	public ServicioActualizarVehiculo servicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioActualizarVehiculo(repositorioVehiculo);
	}

}
