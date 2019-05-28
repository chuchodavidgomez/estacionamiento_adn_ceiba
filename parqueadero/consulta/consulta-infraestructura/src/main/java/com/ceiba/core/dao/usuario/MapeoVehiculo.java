package com.ceiba.core.dao.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoVehiculo;

public class MapeoVehiculo implements RowMapper<DtoVehiculo>,MapperResult {

    @Override
    public DtoVehiculo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        
    	String placa = resultSet.getString("placa");
    	String tipo = resultSet.getString("tipo"); 
    	int cilindraje = resultSet.getInt("cilindraje");
    	String modelo = resultSet.getString("modelo");
    	String marca = resultSet.getString("marca");	
        LocalDateTime fechaIngreso = extraerLocalDateTime(resultSet, "fecha_creacion");
        
        return new DtoVehiculo(placa,tipo,cilindraje,modelo,marca,fechaIngreso);
    }

}
