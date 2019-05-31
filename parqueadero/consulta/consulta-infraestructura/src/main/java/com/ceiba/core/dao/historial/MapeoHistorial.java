package com.ceiba.core.dao.historial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoHistorial;

public class MapeoHistorial implements RowMapper<DtoHistorial>,MapperResult {

    @Override
    public DtoHistorial mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        
    	Long id = resultSet.getLong("id");
        String placaVehiculo = resultSet.getString("placaVehiculo");
        LocalDateTime fechaIngreso = extraerLocalDateTime(resultSet, "fechaSalida");
        LocalDateTime fechaSalida = extraerLocalDateTime(resultSet, "fechaSalida");
        Double pago = resultSet.getDouble("pago");
        return new DtoHistorial(id,placaVehiculo,fechaIngreso,fechaSalida,pago);
    }

}
