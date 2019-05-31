package com.ceiba.core.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.repositorio.RepositorioHistorial;
import com.ceiba.core.servicio.historial.ServicioActualizarHistorial;
import com.ceiba.core.servicio.historial.ServicioCrearHistorial;
import com.ceiba.core.servicio.historial.ServicioEliminarHistorial;
@Configuration
public class BeanServicioHistorial {
	
	@Bean
	public ServicioCrearHistorial servicioCrearHistorial(RepositorioHistorial repositorioHistorial) {
		return new ServicioCrearHistorial(repositorioHistorial);
	}

	@Bean
	public ServicioEliminarHistorial servicioEliminarHistorial(RepositorioHistorial repositorioHistorial) {
		return new ServicioEliminarHistorial(repositorioHistorial);
	}
	
	@Bean
	public ServicioActualizarHistorial servicioActualizarHistorial(RepositorioHistorial repositorioHistorial) {
		return new ServicioActualizarHistorial(repositorioHistorial);
	}

}
