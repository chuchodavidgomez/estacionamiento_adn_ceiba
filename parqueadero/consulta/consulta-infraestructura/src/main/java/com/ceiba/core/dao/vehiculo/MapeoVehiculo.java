package com.ceiba.core.dao.vehiculo;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        
        return new DtoVehiculo(placa,tipo,cilindraje,modelo,marca);
    }

}
