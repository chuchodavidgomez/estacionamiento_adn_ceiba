package com.ceiba.core.dao.historial;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoHistorial;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoHistorial;

@Component
public class DaoHistorialMysql implements DaoHistorial {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    
    @SqlStatement(namespace="historial", value="listar")
	private String sqlListar;

    public DaoHistorialMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
	public List<DtoHistorial> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoHistorial());
    }
}
