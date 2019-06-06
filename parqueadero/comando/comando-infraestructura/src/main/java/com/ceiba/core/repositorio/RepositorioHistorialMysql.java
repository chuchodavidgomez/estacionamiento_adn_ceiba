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
	private String sqlEstaParqueado;
	
	@SqlStatement(namespace="historial", value="cantidadVehiculo") 
	private String sqlCantidadVehiculo;
	
	@SqlStatement(namespace="historial", value="devuelveTipo") 
	private String sqldevuelveTipo;
	
	@SqlStatement(namespace="historial", value="devuelveCilindraje") 
	private String sqldevuelveCilindraje;
	
	public RepositorioHistorialMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}
	
	@Override
	public Long crear(Historial historial) {
		return this.customNamedParameterJdbcTemplate.crearR(historial, sqlCrear);
	}

	@Override
	public Double actualizar(Historial historial) {
		this.customNamedParameterJdbcTemplate.actualizar(historial, this.sqlActualizar);				
		return historial.getPago();
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
		
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEstaParqueado, paramSource, Boolean.class);
	}

	@Override
	public boolean existe(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("id", id);
	    
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public int cantidadVehiculos(String tipo) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("tipo", tipo);
	    
	    return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadVehiculo,paramSource, Integer.class);
	}

	@Override
	public String devuelveTipo(String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("placa", placa);
	    
	    return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqldevuelveTipo,paramSource, String.class);
	}

	@Override
	public int devuelveCilindraje(String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("placa", placa);
	    
	    return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqldevuelveCilindraje,paramSource, Integer.class);
	}

}
