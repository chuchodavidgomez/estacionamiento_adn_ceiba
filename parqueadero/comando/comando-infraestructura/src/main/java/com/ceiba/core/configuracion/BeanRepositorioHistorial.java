package com.ceiba.core.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.repositorio.RepositorioHistorial;
import com.ceiba.core.repositorio.RepositorioHistorialMysql;

@Configuration
public class BeanRepositorioHistorial {	
	@Bean
	public RepositorioHistorial repositorioHistorial(CustomNamedParameterJdbcTemplate repositorioGenerico) {
		return new RepositorioHistorialMysql(repositorioGenerico);
	}
}
