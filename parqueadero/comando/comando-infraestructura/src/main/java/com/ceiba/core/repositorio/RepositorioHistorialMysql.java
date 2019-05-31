package com.ceiba.core.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.historial.Historial;

@Repository
public class RepositorioHistorialMysql implements RepositorioHistorial{

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="historial", value="crear")
	private String sqlCrear;
	
	@SqlStatement(namespace="historial", value="actualizar")
	private String sqlActualizar;
	
	@SqlStatement(namespace="historial", value="eliminar")
	private String sqlEliminar;
	
	@SqlStatement(namespace="historial", value="existe")
	private String sqlExiste;
	
	@SqlStatement(namespace="historial", value="estaParqueado") 
	private String estaParqueado;
	
	public RepositorioHistorialMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}
	
	@Override
	public Long crear(Historial historial) {
		return this.customNamedParameterJdbcTemplate.crearR(historial, sqlCrear);
	}

	@Override
	public void actualizar(Historial historial) {
		this.customNamedParameterJdbcTemplate.actualizar(historial, this.sqlActualizar);		
	}

	@Override
	public void eliminar(long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("id", id);	    
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);		
	}

	@Override
	public boolean estaParqueado(String placaVehiculo) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("placaVehiculo", placaVehiculo);
		
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(estaParqueado, paramSource, Boolean.class);
	}

	@Override
	public boolean existe(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("id", id);
	    
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

}
