package com.ceiba.core.servicio.vehiculo;

import com.ceiba.core.modelo.vehiculo.Vehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculo;

public class ServicioActualizarVehiculo {
     
	private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(Vehiculo vehiculo) {    	
        this.repositorioVehiculo.actualizar(vehiculo);
    }
}
