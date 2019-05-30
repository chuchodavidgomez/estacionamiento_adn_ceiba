package com.ceiba.core.dao.vehiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoVehiculo;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoVehiculo;

@Component
public class DaoVehiculoMysql implements DaoVehiculo{

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="vehiculo", value="listar")
	private String sqlListar;
	
	public DaoVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
	
	@Override
	public List<DtoVehiculo> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoVehiculo());
	}

}
