package com.ceiba.core.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.vehiculo.Vehiculo;

@Repository
public class RepositorioVehiculoMysql implements RepositorioVehiculo{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="vehiculo", value="crear")
	private String sqlCrear;
	
	@SqlStatement(namespace="vehiculo", value="actualizar")
	private String sqlActualizar;
	
	@SqlStatement(namespace="vehiculo", value="eliminar")
	private String sqlEliminar;
	
	@SqlStatement(namespace="vehiculo", value="existe")
	private String sqlExiste;
	
	public RepositorioVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}
	
	@Override
	public void crearVehiculo(Vehiculo vehiculo) {			
		this.customNamedParameterJdbcTemplate.crear(vehiculo, this.sqlCrear);
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo, String placaKey) {
		this.customNamedParameterJdbcTemplate.actualizarConKey(vehiculo, placaKey, this.sqlActualizar);
	}

	@Override
	public void eliminarVehiculo(String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("placa", placa);	    
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);		
	}

	@Override
	public boolean existeVehiculo(String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("placa", placa);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}
	
}
