package com.ceiba.core.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.repositorio.RepositorioVehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculoMysql;

@Configuration
public class BeanRepositorio {
	@Bean
	public RepositorioVehiculo repositorioVehiculo(CustomNamedParameterJdbcTemplate repositorioGenerico) {
		return new RepositorioVehiculoMysql(repositorioGenerico);
	}
}
