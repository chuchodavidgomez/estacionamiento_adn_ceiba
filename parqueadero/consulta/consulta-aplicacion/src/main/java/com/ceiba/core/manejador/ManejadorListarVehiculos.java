package com.ceiba.core.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoVehiculo;
import com.ceiba.core.modelo.DtoVehiculo;

@Component
public class ManejadorListarVehiculos {

    @Autowired
	private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculos(DaoVehiculo daoVehiculo){
        this.daoVehiculo = daoVehiculo;
    }

    public List<DtoVehiculo> ejecutar(){
        return this.daoVehiculo.listar();
    }
}
